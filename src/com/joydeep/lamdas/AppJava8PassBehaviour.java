package com.joydeep.lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
public class AppJava8PassBehaviour {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("John", "Drink", "50"), new Person("David", "Water", "26"),
				new Person("Peter", "Smith", "31"), new Person("Ari", "Paya", "23"), new Person("Sam", "Nicole", "23"));


		// Java -8 way sort the list by lastname.

		Collections.sort(people, (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));

		// Java -8 way print elements in the list

		print(people, (person) -> true,p->System.out.println(p));

		// Java -8 way print all the element of the list that have last name
		// starts with N

		print(people, (person) -> person.getLastName().startsWith("N"),p->System.out.println(p.getLastName()));

	}
	
	
	public static void print(List<Person> peo, Predicate<Person> pred, Consumer<Person> con) {

		for (Person person : peo) {
			if (pred.test(person))
				con.accept(person);
		}
	}

}
