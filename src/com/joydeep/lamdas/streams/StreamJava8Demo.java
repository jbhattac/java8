package com.joydeep.lamdas.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.joydeep.lamdas.vo.Person;

public class StreamJava8Demo {
	
	/*
	 * Streams are pipelines of transformations.
	 * where several transformations takes place on data .
	 * But streams in no way are place holders for data.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(new Person("John", "Drink", "50"), new Person("David", "Water", "26"),
				new Person("John", "Smith", "31"), new Person("Ari", "Paya", "23"), new Person("Sam", "Nicole", "23"));
		List<Integer> numbers = Arrays.asList(1,2,3,3,4,4,5,6,7,8,9);
		System.out.println();
		
		
		// for loop in java - 8
		people.forEach(p->System.out.println(p));
		
		// for loop in java - 8 using method referance.
		people.forEach(System.out::println);
		
		// streams in java - 8 using method referance, and other filters.
		people.stream().filter(p->p.getFirstName().startsWith("J")).forEach(System.out::println);
		
		numbers.stream()
		.filter(i->i%2==0)
		.map(i->i*2)
		.reduce(0,Integer::sum);
		/*
		 * filter - I am going to bock some data and letothers flow through. So no of output<= no of inputs
		 * Types of Input for Filter -> Stream<T> is going to take Filter<T>.
		 * 
		 * Map : Transforms values -> The no of output == No of input
		 * But no gurantee on the type of the input and type of the output.
		 * 
		 * Stream<T> takes a Function<T,R> where Stream<R> is the output.So it cconverts a Stream<T> to Stream<R>.
		 * 
		 * Reduce cuts across swimlanes.
		 * 
		 * Reduce on Stream<T> takes in two parameters, first parameter is of type T
		 * Second parameter is a Bifunction<R,t,R> to produce R.
		 * 
		 * Sum is also a reduce function.
		 * 
		 * Collect is also a reduce operation
		 * 
		 * Both Filter and Map stay within their swimlanes.
		 * 
		 * 			Filter       Map		Reduce
		 * 										0		 * 										0
		 * X1        |							|
		 * 
		 * X2		 ->			  x2'		-> x2'+ 0
		 * 										|
		 * X3        |							|
		 * 										|
		 * X4        ->	          x4'		->x4'+(x2'+0)	
		 * 
		 * 
		 */
		
		/*
		 * 
		 */
		
		/*
		 * The objective is to put the results of the computation to a list 
		 */
		
		List<Integer> list = new ArrayList<>();
		/*
		 * This code is devil's work 
		 * 
		 * Since we are changing the arraylist and we are doing this on a stream
		 * which can be run in parallel and shared mutability is bad.
		 * 
		 */
		numbers.stream()
			   .filter(i->i%2==0)
			   .map(i->i*2)
			   .forEach(i->list.add(i));
		
		/*
		 * Instead of shared mutability we could do something like this.
		 * The toList function will collect the elements to a list .
		 */
		
		List<Integer> list1 = numbers.stream()
				   .filter(i->i%2==0)
				   .map(i->i*2)
				   .collect(Collectors.toList());
		/*
		 * This is how we create a set.
		 * 
		 */
		
		Set<Integer> set = numbers.stream()
								   .filter(i->i%2==0)
								   .map(i->i*2)
								   .collect(Collectors.toSet());
		/*
		 * Here we create a map of person with first name as the key 
		 * and the person object as the value.
		 * 
		 */
		
		Map<String,Person> map = people.stream()
				   						.collect(Collectors.toMap(p->p.getFirstName(),p->p));
		
		/*
		 * We can also do groupings and mappings of object
		 * For example we want to create a map where the key is the name
		 * and the value is the person objects who has the name same as the 
		 * key.
		 */
		
		Map<String, List<String>> groupMap = people.stream()
											.collect(
								Collectors.groupingBy(Person::getFirstName,
								Collectors.mapping(Person::getLastName,
								Collectors.toList())));
		/*
		 * The operations are applied on the the data per element and none 
		 * of the operation is applied on the entire list .
		 * 
		 * The computation is performed lazyly i.e. to say  the terminal operation
		 * initates the intermidiate operation .
		 * 
		 * 
		 * Characteristic of stream :sized, ordered,distinct , sorted.
		 */
		
		    numbers.stream()
		   		   .filter(i->i%2==0)
		   		   .map(i->i*2)
				   .sorted()
				   .distinct()
				   .forEach(System.out::println);
		    
		    int g =2;
		  System.out.println("Joydeep "+numbers.stream(). 
		    filter(i->i%g==0).count());
		    
		    
		    
		    /*
		     * Infinite streams.
		     */
		    Stream.iterate(100, i->i+1);
		    
		    /*
		     * Usage of infinite stream -
		     * Given a number k, and a count int, find the double of
		     * n even numbers starting with k where sqrt of each number is 
		     * greater than 20
		     */
		    int k =151;
		    int n= 51;
		    Stream.iterate(100, i->i+1)
		    	 .filter(i->i%2==0)
		    	 .filter(i->Math.sqrt(i)>20)
		    	 .mapToInt(i->i*2)
		    	 .limit(n)
		    	 .sum();
		  
		
	}

}
