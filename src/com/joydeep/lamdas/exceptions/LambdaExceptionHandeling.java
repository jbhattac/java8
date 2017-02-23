package com.joydeep.lamdas.exceptions;

import java.util.function.BiConsumer;

public class LambdaExceptionHandeling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer opI1 = 1;
		Integer opI2 = 2;
		
		String op1 ="operation 1 done ";
		
		String op2 ="operation 2 done ";

		process(opI1, opI2, wrapperLambda((i, k) -> System.out.println(i + k)));
		process(op1, op2, wrapperLambda((i, k) -> System.out.println(op1+op2)));

	}

	private static <T,U> BiConsumer<T, U> wrapperLambda(BiConsumer<T, U> bicon) {

		return (T, U) -> {
			System.out.println("In the exception handeling wrapper");
			try {
				bicon.accept(T, U);
			} catch (ArithmeticException ae) {
				System.out.println("Exception while doing arithmetic exception / by zero");
			}

		};
	}

	private static <T,U> void process(T op1, U op2, BiConsumer<T, U> bicon) {
		// TODO Auto-generated method stub
		bicon.accept(op1,op2);
	}

}
