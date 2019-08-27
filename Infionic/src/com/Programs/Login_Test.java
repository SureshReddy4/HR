package com.Programs;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.templates.URLStatus;
import com.templates.screenshot;

public class Login_Test {
  
	static WebDriver driver;
	static int i=0;
	static WebDriverWait wait;
	
	screenshot s = new screenshot();
	
	 @Test(dataProvider = "dp")
  
  public void Login(String URL,String Username, String Password) throws Exception 
  {
		 FileInputStream fis = new FileInputStream(".//Data.xlsx");
		  
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		  
		 XSSFSheet sh = wb.getSheetAt(0);
		  
		 FileOutputStream fos = new FileOutputStream(".//Data.xlsx");
	  
	  //Open Browser
	  driver = new FirefoxDriver();
	  
	  //Maximize windows
	  driver.manage().window().maximize();
	  
	  //Navigate to URL
	  driver.navigate().to(URL);
	  
	 System.out.println("Working");

	    
	  //Provide Username and Password
	  driver.findElement(By.id("UserName")).sendKeys(Username);
	  driver.findElement(By.id("Password")).sendKeys(Password);
			
	  //Click on 'Login 
	  driver.findElement(By.id("btnLogIn")).click();
	
	  Thread.sleep(4000);
	  
	  
	 try
	 {
		 if(driver.findElement(By.id("divErrMsg")).isDisplayed())
		 {
			 sh.getRow(i).createCell(3).setCellValue("Invalid Username or Password");
			  i++;
			  wb.write(fos);
			  wb.close();
		 }
	 }
	 catch(Exception e)
	 {
		 try
		  {
			  Alert a = driver.switchTo().alert();
			  
			  String ErrorMessage = a.getText();
			  sh.getRow(i).createCell(3).setCellValue(ErrorMessage);
			  i++;
			  wb.write(fos);
			  wb.close();
		  }
		  catch(NoAlertPresentException e1)
		  {
			  s.takeSnapShot(driver, "E:\\" + i + ".jpg");
			  sh.getRow(i).createCell(3).setCellValue("Passed");
			  i++;
			  wb.write(fos);
			  wb.close();
		  }
	 }
		 
	 		  
		 
	 
	  Thread.sleep(5000);
	  driver.quit();
  }
  
 
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
  }

 
  
  
  @DataProvider
  public Object[][] dp() throws IOException 
  {
	  
		Object[][] SED = new Object[2][3];		
		

		for(int rw = 0; rw<2;rw++)
			{
				List<String> arr = com.templates.Read_Excel1.readexceldata(".//Data.xlsx",rw,3);
				{
					SED[rw][0] = arr.get(0);
					SED[rw][1] = arr.get(1);
					SED[rw][2] = arr.get(2);
				}	
					
			}
		return SED;

  }
  
  
  
  
  
  
  
  
  
}
