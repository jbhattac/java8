package com.joydeep.lamdas.closure;

import com.joydeep.lamdas.interfaces.Process;

public class ClosureJava7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int i = 7;
		 int d =10;

		doProcess(i, new Process() {
			
			@Override
		
			public void doProcess(int i) {
				// TODO Auto-generated method stub
				//d =9; //->Local variable d defined in an enclosing scope must be final or effectively final
				System.out.println(i+d);
			}

		});
	}

	private static void doProcess(int i, Process process) {
		// TODO Auto-generated method stub
		process.doProcess(i);
	}

}


