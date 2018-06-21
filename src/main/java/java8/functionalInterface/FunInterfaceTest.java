/**
 * 
 */
package java8.functionalInterface;

import java.util.function.Consumer;

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
		Consumer<String> con = (p)-> System.out.println("Using java 8 consumer "+p);
		
	}

	private static Object fun() {
		// TODO Auto-generated method stub
		return null;
	}

}
