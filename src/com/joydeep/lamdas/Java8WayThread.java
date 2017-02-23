package com.joydeep.lamdas;

/**
 * @author jbhattac
 * 
 *         In this class we will create a thread that will run a certain
 *         functions in that thread, so that the other function will runs in its
 *         own stack . We will be using not the standard java -7 way of doing
 *         this operation, but java 8 lambdas.
 * 
 * 
 *
 */

public class Java8WayThread {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Lambdas are anonymous function which can be passed around.
		 * 
		 * Here we have removed the anonymous inner class declaration and also 
		 * function name.Which are just part of the ceremony 
		 * , and not doing any actual stuff.
		
		 * Functions typically has 4 things 
		 * 1. Name  -> no need of the method name.
		 * 2. Body -> It is the most important part as it describes what the function actually do
		 * 3. parameter list -> This is the operators on which the function acts . This is important .
		 * 4. return Type -> Need not be declared explicitly , can be inferred.
		 * 
		 * If we keep the bare minimum part of this i.e. body and parameter list 
		 * it is called the lambda expression.
		 * 
		 * Lambda expression have a name and a parameter list.
		 * 
		 * What does it mean lambdas in java
		 * 
		 * Lambda in java 8 are backward compatible i.e. we can use lambda even with old api.
		 * That is why they are backed by single abstract method interfaces which are named as 
		 * Functional Interfaces.
		 * So lambda are useful even with old codes.So lambda can be used with any old code 
		 * like runnable or callable etc , basically
		 * where there is a interface with a single abstract method.
		 * 
		 * Is lambda a syntactical sugar i.e. the compiler changes the lambda to anonymous inner classes as in other 
		 * languages.
		 * In java that is not true, lambda is implementated as invokedynamic in java 
		 * which are function pointers. This can be found by using javap. So it consumes much less space in 
		 * memory and it is much faster.
		 * 
		 * 
		 *  Java can predict the type of the elements passed by the collection types, so it allows 
		 * type inference, but only for lambda.
		 * 
		 * () is optional in lambda expression but only for one parameter lambdas.
		 * 
		 * lambdas should be of one lines,ogic should not be written in lambdas.
		 * 
		 */
		Thread t = new Thread( 	()->System.out.println("In another thread")	);
		
		t.sleep(1000);
		t.start();

	}

}
