/**
 * 
 */
package java8.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java8.lambdas.interfaces.Conditional;
import java8.lambdas.vo.Person;

/**
 * @author jbhattac
 * 
 *         In this class we need to perform the following functions using the
 *         standard java 7 way followed by the java 8 way wherein we will be
 *         using lambda.
 * 
 *         We will be having a list and we will perform the following :
 * 
 *         sort the list by lastname.
 * 
 *         print all the elements of the list.
 * 
 *         print all the elements of the list , where last name start with N
 *
 */
public class CompareJava7WithLamda {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("John", "Drink", "50"), new Person("David", "Water", "26"),
				new Person("Peter", "Smith", "31"), new Person("Ari", "Paya", "23"), new Person("Sam", "Nicole", "23"));

		// sort the list by lastname using the comparator.
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});

		// Java -8 way sort the list by lastname, here also we use lambda instead of the
		// anonymous inner class .

		Collections.sort(people, (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));

		// print all the elements of the list.

		printElements(people, new Conditional() {

			@Override
			public boolean testCondition(Person p) {
				// TODO Auto-generated method stub
				return true;
			}
		});
		
		// Java -8 way print elements in the list, and again we provide lambdas instead of  anonymous inner class .

		printElements(people, (person) -> true);
		
		
		// print all the elements of the list , where last name start with N

		printElements(people, new Conditional() {

			@Override
			public boolean testCondition(Person p) {
				// TODO Auto-generated method stub
				return p.getLastName().startsWith("N");
			}
		});
		
		// Java -8 way print elements in the list where Name starts with N, and again we provide lambdas instead of  anonymous inner class .

		printElements(people, (person) ->  person.getLastName().startsWith("N"));
	}

	private static void printElements(List<Person> people, Conditional cond) {
		for (Person person : people) {
			if (cond.testCondition(person)) {
				System.out.println(person);

			}
		}
	}

}
