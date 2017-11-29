package org.jb.strings;

import java.util.Arrays;
import java.util.Comparator;

public class LargestWord {
	/*
	 * Find largest word in a sentence.
	 */
	public static void main(String[] args) {
		 String s ="Today is the saddest day of my life";
		    System.out.println(Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null));

	}

}
