package com.testing;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

	
	public static void main(String[] args) {
		
		
		
		List<String> mlist = Arrays.asList("a2","b2","c4","car","c1","c6");
		
		mlist.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
	
	
	System.out.println("Another example");
	
	
//	Stream.of("a1","a2","a1","a3").distint
	
	
	Arrays.stream(new int[] {1,2,3}).map(n -> 2* n+1).average().ifPresent(System.out::println);
	
	
	
	
}
}