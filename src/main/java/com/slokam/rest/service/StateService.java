package com.slokam.rest.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mysema.query.types.expr.BooleanExpression;
import com.slokam.rest.dao.StateDAO;
//import com.slokam.rest.pojo.QState_M;
import com.slokam.rest.pojo.State_M;
import com.slokam.rest.util.IStateFileGenerater;

@Service
public class StateService {

	 @Autowired
	 private JavaMailSender javaMailSender;
	 
	 @Autowired
	 @Qualifier(value="stateFileGenerater")
	 private IStateFileGenerater fileGen ;
	 
	 @Autowired
	 private StateDAO stateDao;
	 
/*	 public Iterable<State_M> searchStatesByName(String name,Integer id){
			 QState_M state2 = QState_M.state_M;
			 BooleanExpression stateName = state2.name.eq(name);
			 BooleanExpression stateId = state2.id.eq(id);
			 Iterable<State_M> list = stateDao.findAll(stateName.or(stateId));
		 return list;
	 }*/
	 public void saveState(State_M state) {
		 stateDao.save(state);
	 
		 long timeStamp = System.currentTimeMillis();
		 String fileName = "E:\\stateFile"+timeStamp;
		 
		 fileGen.generateFile(state, fileName);
		 
	 }
	 public void saveState123(State_M state) {
	/*	 Specification<State_M> states =  where(
	                (root, query, cb) ->
                    cb.lessThan(root.get(Employee_.dateOfBirth), olderThanDate)
    );*/
		 /*long  timeStamp = System.currentTimeMillis();
		 stateDao.save(state);
		 
		 //Word 
		 String wordFileName = "E:\\file1"+timeStamp+".docx";
		 XWPFDocument wordDocument = new XWPFDocument();
		 try {
			FileOutputStream wordFos = new FileOutputStream(wordFileName);
			
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
		 
		 
		 //PDF
		 
		 String pdfFileName = "E:\\file1"+timeStamp+".pdf";
		 Document document = new Document();
		 FileOutputStream fos;
		try {
			 fos = new FileOutputStream(pdfFileName);
			 PdfWriter.getInstance(document, fos);
			 document.open();
			   document.add(new Paragraph(" Created state called "+state.getName()));
			 document.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		 
		 // Excel
		 HSSFWorkbook workbook = new HSSFWorkbook();
		 HSSFSheet sheet = workbook.createSheet("STATE DATA");
		 HSSFRow row = sheet.createRow(0);
		 row.createCell(0).setCellValue(state.getName());
		 row.createCell(1).setCellValue("Our value");
		
		 String filename = "E:\\file1"+timeStamp+".xlsx";
		 try {
			FileOutputStream ExcelFos = new FileOutputStream(filename);
			workbook.write(ExcelFos);
			ExcelFos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 
		 
		  
		// sendMail(filename,pdfFileName,wordFileName);
		 
		/* SimpleMailMessage mailMessage = new SimpleMailMessage();
		 mailMessage.setTo("upendra.j2ee@gmail.com");
		 mailMessage.setSubject("State Created.");
		 mailMessage.setText("Hello a state called "+state.getName() + "has created .. ");
		 javaMailSender.send(mailMessage);*/
		 
	 }
	 
	 public List<State_M> getStatesByName(String name){
		  List<State_M> states = new ArrayList<State_M>();
		  List<Object[]> records = stateDao.getStates(name);
		  for (Object[] objects : records) {
			  State_M state = new State_M();
			  state.setName(objects[0].toString());
			  state.setId(Integer.parseInt(objects[1].toString()));
			  states.add(state);
		  }
		 return states;
	 }
	 //getStatesById

	 public List<Object[]> getStatesById(Integer  id){
		 return stateDao.getStatesById(id);
		 
		 
	 }
	 
	 public List<State_M> getStates(){
		 
		 List<State_M> states = new ArrayList<State_M>();
		  List<Object[]> records = stateDao.getStates();
		  for (Object[] objects : records) {
			  State_M state = new State_M();
			  state.setName(objects[0].toString());
			  state.setId(Integer.parseInt(objects[1].toString()));
			  states.add(state);
		  }
		 return states;
		 
		// return stateDao.getStates();
	 }
	 public String getCountryNameByStateName(String stateName){
		 String countryName =null;
		 List<String>  countryNameList = stateDao.getCountryNameByStateName(stateName);
	     if(countryNameList!=null && countryNameList.size()>0){
	    	 countryName = countryNameList.get(0);
	     }
	     return countryName;
	 }
	 


public void sendMail(String filename, String pdfFileName, String wordFileName) {

	   MimeMessage message = javaMailSender.createMimeMessage();
	    
	   
	   try{
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		//helper.setFrom("upendra.j2ee@gmail.com");
		helper.setTo("upendra.j2ee@gmail.com");
		helper.setSubject("hellooo");
		helper.setText(String.format(
			"Hi hello... THis is from Slokam attachment test."));

		/*FileSystemResource file = new FileSystemResource(filename);
		helper.addAttachment(file.getFilename(), file);
		FileSystemResource pdffile = new FileSystemResource(pdfFileName);
		helper.addAttachment(pdffile.getFilename(), pdffile);
		FileSystemResource wordfile = new FileSystemResource(wordFileName);
		helper.addAttachment(wordfile.getFilename(), wordfile);*/
		
		FileOutputStream fos = new FileOutputStream("E:\\allFiles.zip");
		ZipOutputStream zos = new ZipOutputStream(fos);
		ZipEntry wordzip = new ZipEntry("wordFile.docx");
		zos.putNextEntry(wordzip);
        FileInputStream fis = new FileInputStream(wordFileName);		
		
          int data = fis.read();
          while(data!=-1){
        	  zos.write(data);
        	  data = fis.read();
          }
          fis.close();
          
          ZipEntry pdfzip = new  ZipEntry("pdfFile.pdf");   
          zos.putNextEntry(pdfzip);
          FileInputStream pdffis = new FileInputStream(pdfFileName);
          int pdfData = pdffis.read();
          while(pdfData!=-1){
        	  zos.write(pdfData);
        	  pdfData = pdffis.read();
          }
          pdffis.close();
          zos.closeEntry();
          zos.close(); 
		
          FileSystemResource wordfile = new FileSystemResource("E:\\allFiles.zip");
  		  helper.addAttachment(wordfile.getFilename(), wordfile);
          
	     }catch (MessagingException e) {
		throw new MailParseException(e);
	     } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
	   
	     javaMailSender.send(message);
      }
}


/*class CustomerSpecifications {
	
	public static Specification<State_M> stateHasName() {
	   return null;
	}
	
}*/






