package com.joydeep.lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.joydeep.lamdas.interfaces.Conditional;
import com.joydeep.lamdas.vo.Person;


/**
 * @author jbhattac
 * 
 *         In this class we need to perform the following functions using the
 *         standard java 8 way.
 * 
 *         sort the list by lastname.
 * 
 *         print all the elements of the list.
 * 
 *         print all the elements of the list , where last name start with N
 *         
 *         what are lambda expression - they are annonomous functions .
 *
 */
public class AppJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(new Person("John", "Drink", "50"), new Person("David", "Water", "26"),
				new Person("Peter", "Smith", "31"), new Person("Ari", "Paya", "23"), new Person("Sam", "Nicole", "23"));

		//Java -8 way sort the list by lastname.

		Collections.sort(people, (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));

		// Java -8 way print elements in the list

		print(people, (person) -> true);

		// Java -8 way print all the element of the list that have last name
		// starts with N

		print(people, (person) -> person.getLastName().startsWith("N"));

	}

	public static void print(List<Person> peo, Conditional cond) {

		for (Person person : peo) {
			if (cond.testCondition(person))
				System.out.println(person.toString());
		}
	}

}
