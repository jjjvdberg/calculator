package dev.log.health;

import java.util.ArrayList;
import java.util.HashMap;

public class Function {
	
	private ArrayList<Term> terms = new ArrayList<Term>();
	private ArrayList<String> components = new ArrayList<String>();
	
	public Function(ArrayList<Term> terms) {
		this.terms = terms;
		for(Term term : terms) {
			for(String component : term.getComponents())
				if(!this.components.contains(component))
					this.components.add(component);
		}
	}
	
	public float calculate(HashMap<String,Float> values) {
		
		float result = 1.0f;
		
		for(Term term : terms) {
			result *= term.calculate(values);
		}
		return result;
	}
	
	public float diff(HashMap<String,Float> values, String component) {
		
		float margin = 0.01f;
		float before = calculate(values);
		values.put(component, values.get(component) + margin) ;
		float after = calculate(values);
		
		return (after-before)/margin;
	}

	public HashMap<String,Float> maximize() {
		
		float eps = 0.01f; // step size
		float precision = 0.000001f; // Tweak tweak
		float min = eps;
		int i = 0;
		
		HashMap<String,Float> oldC = new HashMap<String,Float>();
		HashMap<String,Float> newC = new HashMap<String,Float>();
		for(String component : components) {
			oldC.put(component, 0.0f);
			newC.put(component, min); // algorithm starts at x = 0.1
		}
		
		while(!hitPrecision(newC,oldC,precision)) {
			for(String component : components) {
				oldC.put(component, newC.get(component));
				newC.put(component, Math.max(min,oldC.get(component) + eps * diff(newC,component)));
			}
			i++;
		}
		newC.put("value",calculate(newC));
		System.out.println("Completed after "+ i + " iterations.");
		return newC;
	}

	private boolean hitPrecision(HashMap<String, Float> newC, HashMap<String, Float> oldC, float precision) {
		for(String component : components) {
			if(newC.get(component) - oldC.get(component) > precision) return false;
		}
		return true;
	}
	
}
