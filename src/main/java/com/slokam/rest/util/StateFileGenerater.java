package com.slokam.rest.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.slokam.rest.pojo.State_M;


@Component
public  class StateFileGenerater implements IStateFileGenerater{

	@Value(value="${stateFileGens}")
	private String stateFileGens; 
	
	@Override
	public void generateFile(State_M state, String fileName) {
		List<IStateFileGenerater> gens  = new ArrayList<>();
	   
		String[] classes = stateFileGens.split(",");
		
	    for (String className : classes) {
			try {
				Class cls = Class.forName(className);
				IStateFileGenerater file = (IStateFileGenerater)cls.newInstance();
				gens.add(file);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				
			}
		}
	   
	   for (IStateFileGenerater fileGen : gens) {
		   fileGen.generateFile(state, fileName);
	   }
		
	   // zip and mail.
	}
	
}
