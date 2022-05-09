package com.project.springbootapp.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UKConstants {
public static final String UK="UK";
public final static Map<String,String> mapOfUKStates=new HashMap<String, String>() {
	{
		put("EN", "England");
		put("WL", "Wales");
		put("SC", "Scotland");
		put("NI", "North Ireland");
		
	}
	

};
public final static List<String> listOfUKStatesCode = new ArrayList<>(mapOfUKStates.keySet());
public final static List<String> listOfUKStatesName = new ArrayList<>(mapOfUKStates.values());

}