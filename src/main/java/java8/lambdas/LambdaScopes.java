/**
 * 
 */
package java8.lambdas;

import java.util.function.Function;

/**
 * @author JBhattacharjee
 *
 */
public class LambdaScopes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int con = 1;
		
		Function<String, Integer> fun = s-> Integer.parseInt(s);
		
		//Access for final variable in the local scope with read access.
		System.out.println(fun.apply(Integer.toString(con+2)));
		
		// Implicit final variables are acceptable however the values should not alter
		
		int test =2;
		System.out.println(fun.apply(Integer.toString(test+2)));
		//test =3;
		
		//In constrast to local variables we have both read and write access to instance
		//fields and static variables from within lambda expressions. 
		
		//Default methods cannot be accessed from within lambda expressions.
	}

}
