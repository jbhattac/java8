/**
 * 
 */
package java8.functionalInterface;

/**
 * @author JBhattacharjee
 *
 */
@FunctionalInterface
public interface FunctionalInterfaceFun {
	
	void fun(String name);
	
	//void sad(String name); -> Compiler complains that the Interface is not functional if this method is enabled
	
	default void defaultFun() {
		System.out.println("I am default fun ");
	}
	
	default void defaultHappy() {
		System.out.println("I am default Joy ");
	}

}
