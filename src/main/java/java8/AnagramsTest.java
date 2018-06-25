package java8;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramsTest {

	 public static String getSorted(String input){
	        return Stream.of(input.split(""))
	                     .sorted()
	                     .collect(Collectors.joining());
	    }
	    
	    public static int numberNeeded(String first, String second) {
	       StringBuilder sec = new StringBuilder(second);
	       StringBuilder fri = new StringBuilder(first);
	       first.chars()
	            .mapToObj(i -> String.valueOf((char)i))
	            .filter(p->-1 !=sec.indexOf(p))
	            .forEach(s->sec.deleteCharAt(sec.indexOf(s)));
	       System.out.println(second);
	       second.chars()
	                 .mapToObj(i -> String.valueOf((char)i))
	                 .filter(p->-1 !=fri.indexOf(p))
	                 .forEach(s->fri.deleteCharAt(fri.indexOf(s)));
	        //second.replace("c","");
	        System.out.println(sec.toString());
	        System.out.println(fri.toString());
	        return sec.toString().length()+ fri.toString().length();
	    }
	  
	    public static void main(String[] args) {
	       // Scanner in = new Scanner(System.in);
	        String a = "cde";
	        String b = "abc";
	        System.out.println(numberNeeded(a, b));
	    }

}
