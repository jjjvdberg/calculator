package dev.log.barinel.test;

import java.util.ArrayList;

import dev.log.barinel.Barinel;
import dev.log.barinel.activity.Matrix;
import dev.log.barinel.health.Function;
import dev.log.barinel.health.Term;
import dev.log.barinel.mhs.HittingSet;

public class TestBarinel {

	static String matrix = 
		"1 1 0	-\n" +
		"0 1 1	-\n" +
		"1 0 0	-\n" +
		"1 0 1	+\n"/* +
		"1 0 0	+\n"*/;
	
	public static void main(String[] args) {
//		ArrayList<String> components = new ArrayList<String>();
//		components.add("c1");
//		components.add("c2");
//		Term t1 = new Term(components, 1);
//		ArrayList<Term> terms = new ArrayList<Term>();
//		terms.add(t1);
//		Function function = new Function(terms);
//		System.out.println("MAXIMIZE: "+ function.maximize());
//		ArrayList<HittingSet> set = Barinel.calculate(Read.readFile("matrix_even_smaller.txt"));
		long start = System.nanoTime();
		double div = 1000.0*1000.0;
//		Matrix a = Read.readFile("matrix_smaller.txt");
		Matrix a = Read.readString(matrix);
		System.out.println("Time taken for reading in the matrix (and AIM) : " + ((System.nanoTime() - start)/div) + "(ms)");
		System.out.println("Hitting sets are: \n"+a.getHittingSets());
		start = System.nanoTime();
		ArrayList<HittingSet> set = Barinel.calculate(a);
		System.out.println("Time taken for the Barinel algorithm           : " + ((System.nanoTime() - start)/div) + "(ms)");
		System.out.println(set);
		System.out.println(a);
	}
}
