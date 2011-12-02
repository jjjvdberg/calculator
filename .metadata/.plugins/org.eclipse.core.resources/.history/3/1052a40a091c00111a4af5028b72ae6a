package dev.log.activity;

public class ErrorVector extends Vector<String,Integer> {

	public ErrorVector copy() {
		ErrorVector new_vector = new ErrorVector();
		
		new_vector.setHeader(new String(this.getHeader()));
		for(Integer value : this.getValues())
			new_vector.addValue(value);
		
		return new_vector;
	}

}
