package com.templates;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class screenshot {

	
		// TODO Auto-generated method stub
		
		 public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		        //Convert web driver object to TakeScreenshot

		        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		            //Move image file to new destination

		                File DestFile=new File(fileWithPath);

		                //Copy file at destination

		                Files.copy(SrcFile, DestFile);

		    }
		
		
		 public static void main(String[] args) throws Exception {
			 
			 System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
			 
			 WebDriver driver = new ChromeDriver();
			 
			 driver.navigate().to("https://www.google.co.in");
			 
			
			 
			 Thread.sleep(5000);
			 
			 driver.quit();
	}

}
