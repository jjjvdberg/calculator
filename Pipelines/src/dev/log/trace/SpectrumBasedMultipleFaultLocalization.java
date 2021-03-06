package dev.log.trace;

import java.util.ArrayList;

import org.apache.commons.math.analysis.polynomials.PolynomialFunction;
import org.jaxen.function.ext.EvaluateFunction;

import dev.log.barinel.activity.ComponentVector;
import dev.log.barinel.activity.ErrorVector;
import dev.log.barinel.activity.Matrix;

public class SpectrumBasedMultipleFaultLocalization {
	
	/**
	 * http://photon.isy.liu.se/dx09/papers/dx09_submission_19.pdf
	 * @input matrix (A,e)
	 * @input number of components M
	 * @input lambda stop criterion
	 * @input L stop criterion
	 */
	
	/**
	 * calculate the spectrum based multiple localization
	 * @throws Exception 
	 */
	public ArrayList<ArrayList<String>> calculate(Matrix matrix) throws Exception {
		 ArrayList<ArrayList<String>> d = Staccato.calculate(matrix);
		 for(ArrayList<String> dk : d) {
			 
			 Double expr = generatePr(matrix, dk);
			 System.out.println(expr);
		 }
		 return d;
	}

	private Double generatePr(Matrix matrix,ArrayList<String> dk) {
		
		ErrorVector error = matrix.getError();
		int i = 0;
		Double result = 1.0;
		
		for(Integer eval : error.getValues()){
			for(String dkItem : dk) {
			}
			
			if(eval == 1) {
			
			} 
			i++;
		}
		
		return 0.0;
	}

	/**
	 * @input matrix (A,e)
	 * @input dk
	 */
	public void generatePr(){
		
	}
	
	/**
	 * @input expr
	 * @input (for all j element of dk) gj
	 */
	public void evaluate(){
		
	}
	
	public static void main(String[] args) {
		/**
		 * TEST A MAXIMIZATION
		 */
		System.out.println(gradientMax());
		
	}
	
	public static float gradientMax() {
		float x_old = 0;
		float y_old = 0;
		float x_new = 0.1f; // algorithm starts at x = 0.5
		float y_new = 0.1f;
		float eps = 0.0001f; // step size
		float precision = 0.000001f;
		
		while(x_new - x_old > precision || y_new - y_old > precision) {
			x_old = x_new;
			y_old = y_new;
			x_new = Math.max(0.0f,x_old + eps * diff(new float[]{x_new,y_new},0));
			y_new = Math.max(0.0f,y_old + eps * diff(new float[]{x_new,y_new},1));
			
		}
		return function(x_new,y_new);
		
	}
	
	public static float function(float x1,float x2) {
	  	return (1-x1*x2)*(1-x2)*(1-x1)*x1;
	}
	
	public static float diff(float[] vars, int pos) {
		
		float margin = 0.01f;
		float before = function(vars[0],vars[1]);
		vars[pos] += margin;
		float after = function(vars[0],vars[1]);
		
		return (after-before)/margin;
	}
	
}
