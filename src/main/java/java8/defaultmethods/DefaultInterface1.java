/**
 * 
 */
package java8.defaultmethods;

/**
 * @author JBhattacharjee
 * 
 * We create a simple interface with a default
 * method
 *
 */
public interface DefaultInterface1 {
	
	default void defaultMethod() {
		System.out.println("This is from DefaultInterface1");
	}

}
