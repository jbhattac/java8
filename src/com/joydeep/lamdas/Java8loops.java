package com.joydeep.lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Java8loops {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		/*Type 1 loop which loops as external loop spagitte code */
		
		System.out.print("Simple External loop\t");
		
		for (int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i)+"\t");
		}
		
		/*Type 2 loop which is also external, but it is a collections loop with type safety*/
		
		System.out.print("\nCollections External loop  ");
		
		for (Integer integer : numbers) {
			System.out.print(integer+"\t");
			
		}
		
		/*Type 3 loop which is  internal loop, meaning the collection itself has the loop method and 
		 * we can provide the needed implementation at runtime*/
		
		System.out.print("\nInternal  loop  for java-8 where we pass the lambda to define the operation.");
		/*
		 * Here we are passing lambda expression that will be executed for 
		 * each of the elements.
		 * 
		 *
		 * 
		 */
		numbers.forEach(i->System.out.print(i+"\t"));//Arrays.sort(input.toCharArray()
		
		
		System.out.print("\nInternal  loop  for java-8 where we pass method referance.");
		
		/*
		 *Here we are passing method referance .
		 *But method referance can only pass the values on
		 *We can not do any modifications 
		 *like the addition of \t.
		 *
		 *But then we can use the strams to actually add the \t for each element 
		 *and then print using method reference.
		 *
		 *
		 */
		
		numbers.stream()
			.map(i->i+"\t")
			.forEach(System.out::print);
		
		/*
		 * The other usage is to use it for 2 arguments
		 * We are to print the sum of all elements.
		 */
		
		System.out.println("\nUsing lambda to print sum "+numbers.stream()
														       .reduce(0,(sum,carry)->Integer.sum(sum, carry)));
		
		System.out.println("\nUsing Method Ref to print sum "+numbers.stream()
															.reduce(0,Integer::sum));
		
		/*
		 * The other usage is to use it for 2 arguments, where one arg becomes the target.
		 * This can't be done when there is a conflict between the instance method and static method.
		 * We are to print the concatination
		 */
		

		System.out.println("\nUsing lambda to print Concat String  "+numbers.stream()
																.map(i->String.valueOf(i))
														       	.reduce("",(conStr,carry)->conStr.concat(carry)));
		

		System.out.println("\nUsing Method Ref to print Concat String "+numbers.stream()
																.map(String::valueOf)
														       	.reduce("",String::concat));
		
		/*
		 * Given the values, double the values and total .
		 * This is called function composition, where we 
		 * are arranging functions according to requirment 
		 * and it is a single pass.
		 */
		
		numbers.stream()
				.filter(i->i%2==0)
				.map(i->i*2)
				.reduce(0,Integer::sum);
		//better way
		
		numbers.stream()
		.filter(i->i%2==0)
		.mapToInt(i->i*2)
		.sum();
		
	}

}
