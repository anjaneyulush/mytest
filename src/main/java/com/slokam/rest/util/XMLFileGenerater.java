package com.slokam.rest.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.slokam.rest.pojo.State_M;

public class XMLFileGenerater implements IStateFileGenerater {

	@Override
	public void generateFile(State_M state, String fileName) {
		try {
			XMLStateData data = new XMLStateData();
			data.setId(state.getId());
			data.setName(state.getName());
			JAXBContext context =  JAXBContext.newInstance(XMLStateData.class);
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(data, new File(fileName+".xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
