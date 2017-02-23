package com.joydeep.lamdas.methodref;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.joydeep.lamdas.vo.Person;

public class MethodRefWithParam {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("John", "Drink", "50"), new Person("David", "Water", "26"),
				new Person("Peter", "Smith", "31"), new Person("Ari", "Paya", "23"), new Person("Sam", "Nicole", "23"));

		// TODO This is an example of Method referance that 
				// works with  parameters.

		print(people, (person) -> person.getLastName().startsWith("N"),System.out::println);//p->System.out.println(p)=System.out::println

	}
	
	
	public static void print(List<Person> peo, Predicate<Person> pred, Consumer<Person> con) {

		for (Person person : peo) {
			if (pred.test(person))
				con.accept(person);
		}
	}

}
