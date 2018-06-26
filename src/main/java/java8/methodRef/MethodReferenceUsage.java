/**
 * 
 */
package java8.methodRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import java8.lambdas.vo.Person;

/**
 * @author JBhattacharjee
 *
 */
public class MethodReferenceUsage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Person> people = Arrays.asList(new Person("Dan","Brown","54"), new Person("Laura","Brown","44"));
		//  Static method reference 
		//(args) -> Class.staticMethod(args)
		// Class::staticMethods
        // Lambda expression
        list.forEach(number -> MethodReferenceUsage.print(number));
		//  Method reference
        list.forEach(MethodReferenceUsage::print);
        
        
        
       //Instance method reference of an existing object
        //(args) -> obj.instanceMethod(args)
       final  ExampleComparator exComparator = new ExampleComparator();
       // Lambda expression
       Collections.sort(list, (a,b) -> exComparator.compare(a,b));
       //  Method reference
       Collections.sort(list,exComparator::compare);
       
       
       // Instance method reference of an object of a particular type
       //(obj, args) -> obj.instanceMethod(args)
       // Class::instanceMethod
       
       // Lambda expression
       people.forEach(person -> person.toString());
       //  Method reference
       people.forEach(Person::toString);
       
       
       //Constructor method reference
       //(args) -> new ClassName(args)
       //ClassName::new
       
       // Lambda expression
       copyElements(list, () -> new ArrayList<Integer>());
       // Method Reference
       copyElements(null, ArrayList<Integer>::new);
	}
	
    private static void print(final int number) {

        System.out.println("Printing: " + number);

    }
    
    private static void copyElements(final List<Integer> list, final Supplier<Collection<Integer>> targetCollection) {

        // Method reference to a particular instance

        list.forEach(targetCollection.get()::add);

    }
    
    static class ExampleComparator {

        public int compare(final Integer a, final Integer b) {

            return a.compareTo(b);

        }

    }

}


