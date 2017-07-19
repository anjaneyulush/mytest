package com.slokam.rest.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.slokam.rest.pojo.State_M;

public class PdfFileGenerater implements IStateFileGenerater{

	@Override
	public void generateFile(State_M state,String fileName) {
		//PDF
		
		 Document document = new Document();
		 FileOutputStream fos;
		try {
			 fos = new FileOutputStream(fileName+".pdf");
			 PdfWriter.getInstance(document, fos);
			 document.open();
			   document.add(new Paragraph(" Created state called "+state.getName()));
			 document.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
}
