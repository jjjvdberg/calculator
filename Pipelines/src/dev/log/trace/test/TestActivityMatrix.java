package dev.log.trace.test;

import java.util.ArrayList;

import dev.log.activity.ComponentVector;
import dev.log.activity.ErrorVector;
import dev.log.activity.Matrix;

public class TestActivityMatrix {

	public static void main(String[] args) {
		ComponentVector component1 = new ComponentVector();
		ComponentVector component2 = new ComponentVector();
		ComponentVector component3 = new ComponentVector();
		ErrorVector error = new ErrorVector();

		error.setHeader("ei");error.addValue(1);error.addValue(1);error.addValue(0);
		
		component1.setHeader("c1");component1.addValue(1);component1.addValue(0);component1.addValue(1);component1.updateCounts(error);
		component2.setHeader("c2");component2.addValue(0);component2.addValue(1);component2.addValue(0);component2.updateCounts(error);
		component3.setHeader("c3");component3.addValue(1);component3.addValue(1);component3.addValue(1);component3.updateCounts(error);


		ArrayList<ComponentVector> components = new ArrayList<ComponentVector>();
		
		components.add(component1);
		components.add(component2);
		components.add(component3);
		
		Matrix matrix = new Matrix(components,error);
		System.out.println(matrix.getRank());
		System.out.println(matrix);
		try {
			matrix.strip("c2");
			System.out.println(matrix);
			System.out.println(matrix.getComponent("c1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
