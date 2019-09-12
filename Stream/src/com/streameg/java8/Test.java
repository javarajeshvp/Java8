package com.streameg.java8;

import java.util.Arrays;

public class Test {
	public int forEachLambdaMaxInteger() {
	    final Wrapper wrapper = new Wrapper();
	    wrapper.inner = Integer.MIN_VALUE;
	    Integer integers[] = {0,2,3,4,5,21,345};
	    
	    Arrays.asList(integers).forEach(i -> helper(i, wrapper));
	    return wrapper.inner.intValue();
	}

public static void main (String hj[]){
	Test t = new Test();
	t.forEachLambdaMaxInteger();
}
	public static class Wrapper {
	    public Integer inner;
	}
	 
	private int helper(int i, Wrapper wrapper) {
	    wrapper.inner = Math.max(i, wrapper.inner);
	    return wrapper.inner;
	}
}
