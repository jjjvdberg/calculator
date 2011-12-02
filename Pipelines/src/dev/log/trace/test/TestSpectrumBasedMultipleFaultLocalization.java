package dev.log.trace.test;

import java.util.ArrayList;

import dev.log.activity.ComponentVector;
import dev.log.activity.ErrorVector;
import dev.log.activity.Matrix;
import dev.log.trace.SpectrumBasedMultipleFaultLocalization;
import dev.log.trace.Staccato;

public class TestSpectrumBasedMultipleFaultLocalization {

	public static void main(String[] args) throws Exception {
		
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

//		Staccato stac = new Staccato();
//		ArrayList<ArrayList<String>> d = new ArrayList<ArrayList<String>>();
//		ArrayList<String> a = new ArrayList<String>();
//		ArrayList<String> b = new ArrayList<String>();
//		ArrayList<String> c = new ArrayList<String>();
//		ArrayList<String> jprime = new ArrayList<String>();
//		b.add("c3");b.add("c2");
//		if(!stac.isSubsumed(d, b)) d.add(b);
//		jprime.add("c1");
//		if(!stac.isSubsumed(d, jprime)) d.add(jprime);
//		a.add("c1");a.add("c2");
//		if(!stac.isSubsumed(d, a)) d.add(a);
//		c.add("c3");c.add("c1");c.add("c4");
//		if(!stac.isSubsumed(d, c)) d.add(c);
//		System.out.println(d);
		
		SpectrumBasedMultipleFaultLocalization local = new SpectrumBasedMultipleFaultLocalization();
		System.out.println("END: "+local.calculate(matrix, 1.0));
	}
}