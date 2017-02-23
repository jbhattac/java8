package com.joydeep.lamdas.methodref;

public class MethodRefExample1 {

	public static void main(String[] args) {
		// TODO This is an example of Method referance that 
		// works with only no parameter.
		
		Thread t = new Thread(MethodRefExample1::printMessage);//()->printMessage() = MethodRefExample1::printMessage
		t.start();
	}

	private static void printMessage() {
		// TODO Auto-generated method stub
		System.out.println("Helloworld from thread ");
	}

}
