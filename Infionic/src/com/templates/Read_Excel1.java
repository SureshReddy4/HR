package com.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel1 {

public static List<String> readexceldata(String Path, int row, int col) throws IOException
	
	{
	
	List<String> LS = new ArrayList<String>();
		
		File f = new File(Path);
		
		FileInputStream fis = new FileInputStream(f);
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet s = wb.getSheetAt(0);
		
		for(int j=0;j<col;j++)
			{
				
			String value = s.getRow(row).getCell(j).getStringCellValue();
			System.out.println(value);
			LS.add(value);
			}
		
		return LS;
	}		

public static void main(String[] args) throws IOException {
	List<String> r = Read_Excel1.readexceldata(".//Data.xlsx",0,3);
	
	for(String name : r)
	{
//		System.out.println(name);
	}
}
}
