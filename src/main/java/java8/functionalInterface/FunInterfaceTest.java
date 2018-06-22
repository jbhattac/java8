/**
 * 
 */
package java8.functionalInterface;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author JBhattacharjee
 * A test class to implement the F.I 
 * 
 */
public class FunInterfaceTest  {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Define the behavior of the defined F.I.
		// we simply print the argument with an appended string.
		FunctionalInterfaceFun interf = (s)->System.out.println("Hello there its time to have fun "+s);
		interf.fun(" Joydeep ");
		// we define a second implementation
		FunctionalInterfaceFun interf1 = (s)->System.out.println("Length is  "+s.length());
		interf1.fun(" Joydeep ");
		
		// let us do the same stuff with java provided interfaces
		// Predicates : -> Predicates are boolean-valued functions of one argument, they accept one argument and returns boolean.
		Predicate<Object> isNull = o -> o == null;
		Object obj = null;
		System.out.println(isNull.test(obj));
		// Functions : -> Represents a function that accepts one argument and produces a result. 
		Function<String, Integer> fun = s-> Integer.parseInt(s);
		
		// Chaining functions using andThen
		Function<String, String> againToString = fun.andThen(String::valueOf);
		System.out.println(againToString.apply("90"));
		// Consumers : -> Accepts a input and performs some operation on that intput .
		Consumer<String> con = (p)-> System.out.println("Using java 8 consumer "+p);
		
		//  Supplier : -> Do not  accept any argument but instead returns newly generated values.
		Supplier<String> sup = () -> Integer.toString((new Date()).getDate());
		System.out.println("Todays date "+sup.get());
	}

	private static Object fun() {
		// TODO Auto-generated method stub
		return null;
	}

}
