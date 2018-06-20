package com.joydeep.lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.joydeep.lamdas.interfaces.Conditional;
import com.joydeep.lamdas.vo.Person;

/**
 * @author jbhattac
 * 
 *         In this class we need to perform the following functions using the
 *         standard java 7 way.
 * 
 *         sort the list by lastname.
 * 
 *         print all the elements of the list.
 * 
 *         print all the elements of the list , where last name start with N
 *
 */
public class AppJava7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> people = Arrays.asList(new Person("John", "Drink", "50"), new Person("David", "Water", "26"),
				new Person("Peter", "Smith", "31"), new Person("Ari", "Paya", "23"), new Person("Sam", "Nicole", "23"));

		// sort the list by lastname.
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});

		// print all the elements of the list.

		printElements(people, new Conditional() {

			@Override
			public boolean testCondition(Person p) {
				// TODO Auto-generated method stub
				return true;
			}
		});

		// print all the elements of the list , where last name start with N

		printElements(people, new Conditional() {

			@Override
			public boolean testCondition(Person p) {
				// TODO Auto-generated method stub
				return p.getLastName().startsWith("N");
			}
		});

	}

	private static void printElements(List<Person> people, Conditional  cond) {
		for (Person person : people) {
			if (cond.testCondition(person)) {
				System.out.println(person);

			}
		}
	}

}
