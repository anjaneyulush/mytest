package com.slokam.rest.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.slokam.rest.pojo.State_M;

public class ExcellFileGenerater implements IStateFileGenerater{

	@Override
	public void generateFile(State_M state,String fileName) {
		
		 HSSFWorkbook workbook = new HSSFWorkbook();
		 HSSFSheet sheet = workbook.createSheet("STATE DATA");
		 HSSFRow row = sheet.createRow(0);
		 row.createCell(0).setCellValue(state.getName());
		 row.createCell(1).setCellValue("Our value");
		
		 try {
			FileOutputStream ExcelFos = new FileOutputStream(fileName+".xlsx");
			workbook.write(ExcelFos);
			ExcelFos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
