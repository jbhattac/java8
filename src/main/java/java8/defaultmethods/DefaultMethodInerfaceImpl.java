/**
 * 
 */
package java8.defaultmethods;

/**
 * @author JBhattacharjee
 * 
 * Problem : DefaultMethodInerfaceImpl implements DefaultInterface1,DefaultInterface2
 * where both the interfaces have the same signature default method

 * 
 * Duplicate default methods named defaultMethod with the 
 * parameters () and () are inherited from the types DefaultInterface2 
 * and DefaultInterface1
 *
 */
public class DefaultMethodInerfaceImpl implements DefaultInterface1,DefaultInterface2 {

	/**
	 * Solution 1
	 * We define a default method 
	 * in the implementing class itself 
	 * to resolve the conflicts.
	 */
	/*public void defaultMethod() {
		System.out.println("This is from DefaultInterface1");
	}*/
	
	
	
	/**
	 * Solution 2
	 * We define a default method 
		and specify which default 
		method we are interested in.
	 */
	public void defaultMethod(){
		 DefaultInterface1.super.defaultMethod();
	    }
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultMethodInerfaceImpl impl = new DefaultMethodInerfaceImpl();
		impl.defaultMethod();

	}

}
