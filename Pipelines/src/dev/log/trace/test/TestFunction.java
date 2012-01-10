package dev.log.trace.test;

import java.util.ArrayList;
import java.util.HashMap;

import dev.log.barinel.health.Function;
import dev.log.barinel.health.Term;

public class TestFunction {

	public static void main(String[] args) {
		ArrayList<String> e1components = new ArrayList<String>();
		e1components.add("h1");
		e1components.add("h2");
		Term h1 = new Term(e1components,true);
	
		ArrayList<String> e2components = new ArrayList<String>();
		e2components.add("h2");
		Term h2 = new Term(e2components,true);

		ArrayList<String> e3components = new ArrayList<String>();
		e3components.add("h1");
		Term h3 = new Term(e3components,true);

		ArrayList<String> e4components = new ArrayList<String>();
		e4components.add("h1");
		Term h4 = new Term(e4components,false);
		
		ArrayList<Term> terms = new ArrayList<Term>();
		terms.add(h1);terms.add(h2);terms.add(h3);terms.add(h4);
		Function func = new Function(terms);
		System.out.println(func);
		System.out.println(func.maximize());
		
		ArrayList<String> e12components = new ArrayList<String>();
		e12components.add("h1");
		Term h12 = new Term(e12components,true);
	
		ArrayList<String> e22components = new ArrayList<String>();
		e22components.add("h3");
		Term h22 = new Term(e22components,true);

		ArrayList<String> e32components = new ArrayList<String>();
		e32components.add("h1");
		Term h32 = new Term(e32components,true);

		ArrayList<String> e42components = new ArrayList<String>();
		e42components.add("h1");
		e42components.add("h3");
		Term h42 = new Term(e42components,false);
		
		ArrayList<Term> terms2 = new ArrayList<Term>();
		terms2.add(h12);terms2.add(h22);terms2.add(h32);terms2.add(h42);
		Function func2 = new Function(terms2);
		System.out.println(func2);
		System.out.println(func2.maximize());
		
//		HashMap<String,Float> values = new HashMap<String,Float>();
//		values.put("h1",0.41f);
//		values.put("h2",0.50f);
//		System.out.println(func.calculate(values));
		
System.out.println("======================");
		HashMap<String,Float> values = new HashMap<String, Float>();
		values.put("h1", 0.1f);
		values.put("h2", 0.1f);
		System.out.println(func.gradient(values));
		
	}
}
