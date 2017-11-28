package com.joydeep.streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



public class Java8StringManipulation {

	public static boolean isNotNullOrEmpty(String str) {
		return str != null && !str.isEmpty() && !str.equalsIgnoreCase("null");
	}
	
	private static Map<String, String>  processFieldsFromQuery(String qry){
		//Map<String, String> qryMap = new LinkedHashMap<>();
		Map<String, String> qryMap = Pattern .compile("§")
											 .splitAsStream(qry)
											 .map(s->s.split(":"))
											 .filter(a->a.length>1)
											 .collect(Collectors.toMap(
													 					a->a[0],
													 					a->a[1],
													 					(e1,e2)->e1,
													 					LinkedHashMap::new));
		qryMap.keySet().stream().forEach(System.out::println);	  
		qryMap.values().stream().forEach(System.out::println);	
	
		return qryMap;
	}
	
	public static void main(String[] args) {
		processFieldsFromQuery("nam_comp_name:HUDGENS, TOM § add_country:US § ent_typeTree:ENTITY_GENERAL/ENTITY_ENTITY/ENTITY_COMPANY#Company");
		processFieldsFromQuery("nam_comp_name:Joydeep §");
	}

}
