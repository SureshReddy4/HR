package com.templates;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLStatus {

public boolean verifyurl(String URL)
{
	try
	{
		URL url = new URL(URL);
		
		HttpURLConnection h=(HttpURLConnection)url.openConnection();

		h.setConnectTimeout(3000);
		
		h.connect();
		
		if(h.getResponseCode()!=200)
	    
			{
				
			System.out.println(URL+"==="+h.getResponseMessage()+"==="+HttpURLConnection.HTTP_NOT_FOUND);
			}
		return false;
		
		
	}
		catch(Exception e)
		{

		}
	return true;

	}
}

	

	


