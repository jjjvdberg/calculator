package dev.log.barinel.health;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The function for calculating Pr(e|d) consists of terms that are combined
 * together (since they are independent). The components need to be tracked
 * so that they can be used for calculating the gradient of the function.
 * This gradient is then used to maximize the function and determine the
 * likelyhood of the error being caused by the diagnosis represented by the
 * function.
 * 
 * @author Joel van den Berg
 */
public class Function {
	
	/**
	 * The terms that make up this function.
	 */
	private ArrayList<Term> terms = new ArrayList<Term>();
	
	/**
	 * The components that are in the terms of this function.
	 */
	private ArrayList<String> components = new ArrayList<String>();
	
	/**
	 * Construct the function by the terms taking out the components from
	 * these terms.
	 * 
	 * @param terms List of terms that make up this function.
	 */
	public Function(ArrayList<Term> terms) {
		this.terms = terms;
		for(Term term : terms) {
			for(String component : term.getComponents())
				if(!this.components.contains(component))
					this.components.add(component);
		}
	}
	
	/**
	 * Calculate the result of this function by the product of each
	 * term in this function.
	 * 
	 * @param values The values for each component.
	 * @return The result of this function for the values.
	 */
	public float calculate(HashMap<String,Float> values) {
		
		float result = 1.0f;
		
		for(Term term : terms) {
			result *= term.calculate(values);
		}
		return result;
	}
	
	/**
	 * Calculate the gradient for this function in some point described by
	 * the value HashMap.
	 * 
	 * We define the gradient by the partial derivatives of the function,
	 * which means we should differentiate the function for each component.
	 * Then we put in the value map, which calculates the gradient vector.
	 * This vector can then be used to determine the new values for the
	 * components.
	 * 
	 * Instead of computing the real derivative of the function, we will
	 * estimate it by using the central divided difference scheme and 
	 * Richardson's Extrapolation.
	 * 
	 * @param values The point for which to calculate the gradient.
	 * @return The gradient for this function.
	 */
	public HashMap<String,Float> gradient(HashMap<String,Float> values) {
		
		float margin = 0.1f;
		HashMap<String,Float> newValues = new HashMap<String,Float>();
		
		for(String key : values.keySet()) {
			float d1 = centralDividedDifference(values,key,margin);
			float d2 = centralDividedDifference(values,key,margin/2);
			//Richardson's Extrapolation
			newValues.put(key, d2 + ((d2 - d1) / 3));
		}
		
		return newValues;
	}
	
	/**
	 * The central divided difference is calculated by keeping all values in the values HashMap
	 * constant but increasing and decreasing the value for component by margin. The CDD is then
	 * returned by the value:
	 * (f(x1,x2,xc+margin,..) - f(x1,x2,xc-margin,..)) / ( 2 * margin )
	 * 
	 * @param values The values that describe a point of the function
	 * @param component The component for which we differentiate
	 * @param margin The margin size
	 * @return The CDD value for component in the point described by values
	 */
	public float centralDividedDifference(HashMap<String,Float> values, String component, float margin) {
		Float value = values.get(component);
		values.put(component, value+margin);
		float plus = this.calculate(values);
		values.put(component, value-margin);
		float min = this.calculate(values);
		values.put(component, value);
		return (plus-min)/(2*margin);
	}
	
	/**
	 * Maximize this function with respect to the components in this functions.
	 * The maximization is done by using the gradient ascent method. For calculating
	 * the gradients of a component vector, we differentiate the function by using an
	 * approximation method, which results in the different slopes of the function for
	 * each component.
	 * 
	 * The parameters used are partly taken from the original c code and partly tweaked
	 * by testing.
	 * 
	 * @return The components with the values for which the function is maximum.
	 */
	public HashMap<String,Float> maximize() {
		
		float gamma = 0.01f; // step size for gradient ascent (taken from c * 100)
		float precision = Float.MIN_VALUE; // Tweak tweak stop condition
		float prOld;
		float pr = 1.0f; // Start at 0.0f
		int i = 0; // iteration count
		float min = 0.0001f; // taken from c
		float max = 0.9999f; // taken from c
		float p = 0.01f; // taken from paper
		
		HashMap<String,Float> gj = new HashMap<String,Float>(); // The values for the components
		for(String component : components) { // And initiate them to 0.0f
			gj.put(component, 0.1f);
		}
		
		do { // gradient ascent
			i++;
			prOld = pr;
			HashMap<String,Float> gradients = this.gradient(gj);
			//System.out.println("in: " + gj + " gradients: "+gradients + " pr " + pr);
			//System.out.println("grads: " + gradients);
			for(String component : components) {
				float val = gj.get(component) + gamma * gradients.get(component);
				if(val > max) val = max;
				if(val < min) val = min;
				gj.put(component,val);
			}
			pr = this.calculate(gj);

		} while (Math.abs(prOld - pr) > precision /*&& i <= 1500*/);
		
//		System.out.println("pr: "+pr);
//		System.out.println("calc: "+(( (0.185/(p*p))*4/3 ) + ( (0.036/(p*p))*4/3 )));
//		System.out.println("calc: "+( (0.185/(p*p))*4/3 )/2946.6667411057297);
//		System.out.println("calc: "+( (0.036/(p*p))*4/3 )/2946.6667411057297);
//		System.out.println("gj: "+gj);
//		System.out.println("i: "+i);
//		System.out.println("=========================");
		
		return gj;
	}

	/**
	 * Print this function in a more readable manner.
	 * @return Human readable representation.
	 */
	@Override
	public String toString() {
		String str = "Pr(e|d) = ";
		int i = 0;
		for(Term term : this.terms) {
			if(i != 0) {
				str += " * ";
			}
			str += term.toString();
			i++;
		}
		return str;
	}
	
}
