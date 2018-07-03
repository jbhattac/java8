# Java 8

Java 8 features and how to use the new features . Is java 8 less painful for the poor eyes .... Lets see how the new thing taste 
or is it just a new wine in old bottle!

## Default Methods

The experiments are contained in the package java8.defaultmethods

Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the default keyword. This feature is also known as Extension Methods.

The main purpose of declaring this method is for the backward compatibility of lambda, so that it can be used with Iterators,Thread,...

## Functional Interfaces

Each lambda expression basically implements a abstract method form an interface. If there are more than one abstract method defined in the interface , it will not be possible to define a lambda on that interface since lambdas are anonymously called. 

Like the Marker Interface there existed the so called Functional Interfaces already, since by definition F.I. are interface with single abstract method e.g. Runnable, Callable, Comparable ..., but this was not defined formally.

In java 8 single abstract method interface was described formally with @FunctionalInterface were formed and compiler will complain if contract is not maintained.

In Java 8 java.util.function defines a host of functional interfaces for supporting a host of lambdas. 
### Predicate
	 Predicates are boolean-valued functions of one argument, they accept one argument and returns boolean.
### Function
	 Represents a function that accepts one argument and produces a result.  
### Supplier
	Do not  accept any argument but instead returns newly generated values.
### Consumer
	 Accepts a input and performs some operation on that input .


## Lambdas

Lambdas are anonymous function it may or may not have parameters or results. This block of code is executed on demand or can be passed around. 

### Anatomy of Lambdas

If we take the anonymous class as the starting point , then firstly we remove the inner class declaration stuff. 

	Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("From another thread ");
			}

		});
		
		Thread t = new Thread(

			@Override
			public void run() {
				System.out.println("From another thread ");
			}

		);
		
Now let us analyse a function. Functions typically has 4 things 

1. Name  -> This can be inferred with SAM interfaces being the definitions of lambdas so no need of the method name. 

2. Body -> It is the most important part of the function as it describes purpose of the function .

3. parameter list -> This is the operators on which the function acts . This is important and cannot be removed .

4. return Type -> Need not be declared explicitly , can be inferred from the body of the function.

If we keep the bare minimum part of this i.e. body and parameter list it is called the lambda expression.Lambda expression have a name and a parameter list.

	Thread t = new Thread(
		() -> System.out.println("From another thread ");
		);
		
Are lambdas backward compatable.

Lambda in java 8 are backward compatible i.e. we can use lambda even with old api.
That is why they are backed by single abstract method interfaces which are named as Functional Interfaces. So lambda can be used with any old code like Runnable or callable etc , basically where there is a interface with a single abstract method.

Is lambda a syntactical sugar i.e. the compiler changes the lambda to anonymous inner classes as in other languages.

In java that is not true, lambda is implementated as invokedynamic in java which are function pointers. This can be found by using javap. So it consumes much less space in 
memory and it is much faster.

Java can predict the type of the elements passed by the collection types, so it allows 
type inference, but only for lambda.

() is optional in lambda expression but only for one parameter lambdas.

lambdas should be of one lines,ogic should not be written in lambdas.

How is the lambdas scope defined.

Accessing outer scope variables from lambda expressions is  similar to anonymous classes. Access for final local variables and  instance and static variables from the  are allowed.

Access for final variable in the local scope with read access. Implicit final variables are acceptable however the values should not alter.
In constrast to local variables we have both read and write access to instance
fields and static variables from within lambda expressions. 
Default methods cannot be accessed from within lambda expressions.

## Method References

Method references are short hand notation for lambdas that executes just ONE method and can replace lambdas in certain situations. So they can be called a subset of lambdas.

The general syntax is System.out::println

In a method reference, that contains the method before the :: operator and the name of the method after it without arguments.

There are 4 types of method references

1.  Static method reference , we can turn the following lambda to method reference

		(args) -> Class.staticMethod(args)
		
		Class::staticMethod
Instead of the . operator, we use the :: operator, and that we don't pass arguments to the method reference. In this case, any arguments (if any) taken by the method are passed automatically.Where ever we can pass a lambda expression that just calls a static method, we can use a method reference.

2. Reference to an Instance Method of a Particular Object

In this case, we have a lambda expression like 

		(obj, args) -> obj.instanceMethod(args)
		
An instance of an object is passed, and one of its methods is executed with some optional(s) parameter(s).

This can be turned into the following method reference

		ObjectType::instanceMethod

3. Instance method reference of an existing object

In this case, we have a lambda expression like 

	(args) -> obj.instanceMethod(args)

This can be turned into the following method reference

	obj::instanceMethod
	
an instance defined somewhere else is used, and the arguments (if any) are passed like static methods.

4. Constructor method reference

In this case, we have a lambda expression like the following

	(args) -> new ClassName(args)

That can be turned into the following method reference

	ClassName::new

The only thing this lambda expression does is to create a new object and we just reference a constructor of the class with the keyword new. Like in the other cases, arguments (if any) are not passed in the method reference.
Most of the time, we can use this syntax with two (or three) interfaces of the java.util.function package.
	
## Streams

Streams are pipelines of transformations. A stream pipeline can be defined as a place 
where several intermediate transformations takes place and at last there is this terminal operation that take place on data . But streams is in no way are place holders for data . Data is still stored in collections or arrays for example.Streams are lazy; computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed. 

In java 8 java.util.stream.Stream is the most interesting class that has been added to benefit streams. Let us have a peek into some of its features that it provides.


1. filter(Predicate<? super T> predicate) -> Blocks some data of the stream and let others flow through. It returns a stream consisting of the elements of this stream that match the given predicate . So number of elements in the  output <= number of elements in input stream.Also note this is type of intermediate transformations that takes place in the stream pipeline.

2.  map(Function<? super T,? extends R> mapper)-> Transforms values from one stream to other by applying the provided function , so the number of elements in the  output stream must match with the input. Also note this is type of intermediate transformations that takes place in the stream pipeline.

3. Flatmap Function<? super T,? extends Stream<? extends R>> -> Lets us work with complex set of data structures of type List<List<Integer>> and for example we want to multiply by 2 with all the elements from all the list. If we want to use map  then we have to use a nested map to achive that , however flatmap simplifies that and we can work directly with the elements from all the list the unwrapping is autometically taken care of. 

		List<List<Integer>> listNumbers = 		Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6,7));
		
		listNumbers.stream()
					.flatMap(List::stream)
					.map(p->p*2)
					.forEach(System.out::println);

4 Reduce (T identity, BinaryOperator<T> accumulator) - >  This is different from map or filter in the sense that it cuts across swim lanes, and looks for elements left or right. Thus this forms an accumulations of the elements of the stream, so it may transform a stream to a single value.This is a terminal operations.Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value. 
Sum, min, max, average, and string concatenation are all special cases of reduction. Summing a stream of numbers can be expressed as


		numbers.stream()
		.filter(i->i%2==0)
		.map(i->i*2)
		.reduce(0,Integer::sum);
		
     Integer sum = integers.reduce(0, (a, b) -> a+b);
 

or:


     Integer sum = integers.reduce(0, Integer::sum);
 


		 * 			Filter       Map		Reduce
		 * 												 								
		 * X1        |							
		 * -------------------------
		 * X2		 ->			  x2'		-> x2'+ 0
		 *------------------------- 										
		 * X3        |							|
		 * ------------------------								
		 * X4        ->	      x4'		->x4'+(x2'+0)	
		 * -------------------------
Shared mutability problem

		List<Integer> list = new ArrayList<>();
		
			numbers.stream()
			   .filter(i->i%2==0)
			   .map(i->i*2)
			   .forEach(i->list.add(i));
			   
This code is devil's work, Since we are changing the arraylist and we are doing this on a stream  which can be run in parallel and shared mutability is bad which may give rise to concurrency problems.

6. Collect -> Instead of shared mutability we could do something like this, the collect function will take care of threading automatically . The collect is also a reduce function . 

	List<Integer> list1 = numbers.stream()
				   .filter(i->i%2==0)
				   .map(i->i*2)
				   .collect(Collectors.toList());
7. toList,toSet,toMap -> transforms a stream to a list or to a set as needed.

	Map<String,Person> map = people.stream()
				       .collect(Collectors
				       .toMap(p->p.getFirstName(),p->p));
8. Mapping and Grouping
				       
We can also do groupings and mappings of object . For example we want to create a map where the key is the name  and the value is the person objects who has the name same as the key.

		Map<String, List<String>> groupMap = people.stream()
											.collect(
								Collectors.groupingBy(Person::getFirstName,
								Collectors.mapping(Person::getLastName,
								Collectors.toList())));
		
