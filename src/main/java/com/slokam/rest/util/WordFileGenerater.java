package com.slokam.rest.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.slokam.rest.pojo.State_M;

public class WordFileGenerater implements IStateFileGenerater {

	@Override
	public void generateFile(State_M state,String fileName) {
		
		 XWPFDocument wordDocument = new XWPFDocument();
		 try {
			FileOutputStream wordFos = new FileOutputStream(fileName+".docx");
			
			XWPFParagraph para = wordDocument.createParagraph();
			XWPFRun run = para.createRun();
			run.setText(" NEW STATE HAS BEEN CREATED, CALLED :: "+ state.getName());
			wordDocument.write(wordFos);
			wordFos.close();
			
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
