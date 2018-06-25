package java8.lambdas;

/**
 * @author jbhattac
 * 
 *         In this class we will create a thread that will run a certain
 *         operations  . We will be using
 *         standard java -7 way of doing this operation.
 * 
 * 
 *
 */

public class Java7WayThread {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("From another thread ");
			}

		});
		
		t.sleep(10000);
		t.start();
		System.out.println("From main thread");

	}

}
