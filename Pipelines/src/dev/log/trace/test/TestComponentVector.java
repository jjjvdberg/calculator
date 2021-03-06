package dev.log.trace.test;

import junit.framework.TestCase;

import org.junit.Test;

import dev.log.barinel.activity.ComponentVector;
import dev.log.barinel.activity.ErrorVector;

public class TestComponentVector extends TestCase {

	ComponentVector testVector1;
	ComponentVector testVector2;
	ComponentVector copyVector;
	
	public void setUp() {
		ErrorVector error = new ErrorVector();
		error.addValue(1);
		error.addValue(1);
		error.addValue(0);
		error.addValue(0);
		
		testVector1 = new ComponentVector();
		testVector1.setHeader("component1");
		testVector1.addValue(1);
		testVector1.addValue(0);
		testVector1.addValue(1);
		testVector1.addValue(1);
		testVector1.updateCounts(error);
		
		testVector2 = new ComponentVector();
		testVector2.setHeader("component2");
		testVector2.addValue(1);
		testVector2.addValue(1);
		testVector2.addValue(0);
		testVector2.addValue(0);
		testVector2.updateCounts(error);
	}
	
	@Test
	public void testCopy() {
		copyVector = testVector1.copy();
		assertNotSame(copyVector, testVector1);
	}
	
	@Test
	public void testEquals() {
		copyVector = testVector1.copy();
		assertTrue(copyVector.equals(testVector1));
		assertFalse(copyVector.equals(testVector2));
	}
}
