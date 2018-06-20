/**
 * 
 */
package java8.defaultmethods;

/**
 * @author JBhattacharjee 
 * We create a simple interface with a default method
 * that has exactly the same signature as in DefaultInterface1
 *
 */
public interface DefaultInterface2 {
	default void defaultMethod() {
		System.out.println("This is from DefaultInterface2");
	}

}
