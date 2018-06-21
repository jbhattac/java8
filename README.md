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

