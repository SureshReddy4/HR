package com.Programs;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	
	 @Test(priority = 1, dataProvider = "dp")
	 public void test(String URL, String Username, String Password)
	 {
		 System.out.println(URL);
		 System.out.println(Username);
		 System.out.println(Password);
	 }
	 
	 @Test(priority = 2)
	 public void test2()
	 {
		 System.out.println("Working");
	 }
	
	
	
	 @DataProvider
	  public Object[][] dp() throws IOException 
	  {
		  
			Object[][] SED = new Object[1][3];		
			

			for(int rw = 0; rw<1;rw++)
				{
					List<String> arr = com.templates.Read_Excel1.readexceldata("C:\\Users\\sekhar.ch\\Desktop\\Login_Cases.xlsx",rw,3);
					{
						SED[rw][0] = arr.get(0);
						SED[rw][1] = arr.get(1);
						SED[rw][2] = arr.get(2);
					}	
						
				}
			return SED;

	  }
}
