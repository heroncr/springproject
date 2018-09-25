package com.testing;


import java.util.Arrays;
import java.util.List;

interface Test{
	
	void show();
}

//class C implements Test{
//	
//	
//	@Override
//	public void show(){
//		
//		System.out.println("hello");
//	}
//}

public class LamdaTest {

	public static void main(String[] args) {
		
//		Test t = new C();
//		t.show();
//		
		
//		
		Test t1 = ()->{
			
			System.out.println("==============HEllO===============");
		};
		
		t1.show();
		List<Integer> dlist =  Arrays.asList(10,20,30,40);
		
	 dlist.forEach(x -> System.out.println(x));
	
	}
	
}
