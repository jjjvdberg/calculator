package dev.log.activity;

import java.util.ArrayList;
import java.util.HashMap;

public class ComponentVector extends Vector<String,Integer> {
	
	private HashMap<String,Integer> counts;
	private Double ochiaiValue;
	
	public ComponentVector() {
		super();
		counts = new HashMap<String,Integer>();
		this.setCounts(0, 0, 0);
		ochiaiValue = 0.0;
	}
	
	public void updateCounts(ErrorVector errorVector) {
		
		int i = 0,
		    n11 = 0,
			n10 = 0,
			n01 = 0;
		
		for(Integer value : getValues() ) {
			int ei = errorVector.getValues().get(i);
			
			int aij = value;
			
			if(aij == 1 && ei == 1) n11++;
			if(aij == 1 && ei == 0) n10++;
			if(aij == 0 && ei == 1) n01++;
			
			i++;
		}
		
		counts.put("n11", n11);
		counts.put("n10", n10);
		counts.put("n01", n01);
		
		updateOchiai();
	}
	
	private void updateOchiai() {

	    int n11 = counts.get("n11"),
			n10 = counts.get("n10"),
			n01 = counts.get("n01");
	    
		ochiaiValue = n11 / (double)(Math.sqrt((n11+n01)*(n11+n10)));	
	}
	
	public Double getOchiaiValue() {
		
		return this.ochiaiValue;
		
	}
	
	private void setCounts(Integer n11, Integer n10, Integer n01) {
		counts.put("n11", n11);
		counts.put("n10", n10);
		counts.put("n01", n01);
		
		updateOchiai();
	}
	
	public HashMap<String,Integer> getCounts() {
		return this.counts;
	}

	public ComponentVector copy() {

		ComponentVector newVector = new ComponentVector();
		
		
		newVector.setHeader(new String(this.getHeader()));
		
		for(Integer value : this.getValues()) {
			newVector.addValue(value);
		}

		newVector.setCounts(this.counts.get("n11"), this.counts.get("n10"), this.counts.get("n01"));
		
		return newVector;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof ComponentVector) {
			ComponentVector vector = (ComponentVector) obj;
			if(vector.getValues().size() != this.getValues().size())
				return false;
			for(int i = 0; i < vector.getValues().size(); i++) {
				if(this.getValue(i) != vector.getValue(i))
					return false;
			}
			if(	this.counts.get("n11") != vector.counts.get("n11") ||
				this.counts.get("n10") != vector.counts.get("n10") ||
				this.counts.get("n01") != vector.counts.get("n01")){
				return false;
			}
			if(!this.ochiaiValue.equals(vector.getOchiaiValue())) {
				return false;
			}
			
			return true;
			
		}
		return false;
	}
	
	@Override
	public String toString() {
		ArrayList<Object> output = new ArrayList<Object>();
		output.add(this.getHeader());
		output.addAll(this.getValues());
		output.addAll(this.getCounts().values());
		output.add(this.getOchiaiValue());
		return output.toString();
	}
}