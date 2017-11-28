package org.jb.strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.Test;

public class Java8Strings {

	/*
	 * join - any number of strings into a single string with the given delimiter.
	 */
	@Test
	public void testJoin() {
		assertThat("foobar:foo:bar", is(String.join(":", "foobar", "foo", "bar")));
	}
	
	/*
	 * chars - creates a stream for all characters of the string, so you can use stream operations upon those characters.
	 */
	
	@Test
	public void testChars() {
		assertThat(":abfor", is("foobar:foo:bar"
							    				.chars()
							    				.distinct()
							    				.mapToObj(c -> String.valueOf((char)c))
							    				.sorted()
							    				.collect(Collectors
							    									.joining())));
	}
	
	/*
	 * chars - Instead of splitting strings into streams for each character we can split strings for any pattern and create a stream to work upon.
	 */
	@Test
	public void testRegChars() {
		assertThat("bar:foobar", is(Pattern.compile(":")
				    					   .splitAsStream("foobar:foo:bar")
				                           .filter(s -> s.contains("bar"))
				                           .sorted()
				                           .collect(Collectors. 
			                        		                joining(":"))));
	}
	

}
