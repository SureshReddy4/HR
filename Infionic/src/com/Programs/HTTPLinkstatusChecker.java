package com.Programs;

import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPLinkstatusChecker {
	
	public static String HTTPLinkstatusChecker(String linkUrl)
	{
		
		String s1 = null;
		String s2 = null;
		
	try
	{
		URL url = new URL(linkUrl);
		
		HttpURLConnection h=(HttpURLConnection)url.openConnection();
		
		h.setConnectTimeout(3000);
		
		h.connect();
		
		
		/*if(h.getResponseCode()==200)
		{
			//System.out.println(linkUrl+"==="+h.getResponseMessage());
			String s1=linkUrl+"==="+h.getResponseMessage();
			
			System.out.println(s1);
		}*/
		
		if(h.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			
		{
			//System.out.println(linkUrl+"==="+h.getResponseMessage()+"==="+HttpURLConnection.HTTP_NOT_FOUND);
		   s2=linkUrl+"==="+h.getResponseMessage()+"==="+HttpURLConnection.HTTP_NOT_FOUND;
			
			System.out.println("Server Error" + HttpURLConnection.HTTP_NOT_FOUND);
		}

		
		if(h.getResponseCode()==200)
		{
			//System.out.println(linkUrl+"==="+h.getResponseMessage());
			s1=linkUrl+"==="+h.getResponseMessage();
			
			return s1;
		}
		
		
	}
	catch(Exception e){
		

	}
	return s2;
	}

}
