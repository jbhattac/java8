package com.joydeep.lamdas.closure;

import com.joydeep.lamdas.interfaces.Process;

public class ClosureJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int i = 7;
		 int d =10;

		doProcess(i, p->System.out.println(i+d));
	}
	
	private static void doProcess(int i, Process process) {
		// TODO Auto-generated method stub
		process.doProcess(i);
	}

}

