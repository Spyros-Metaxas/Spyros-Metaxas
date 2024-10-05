package com.p.demo.medicine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class medicine {
	private BufferedReader reader;
	private String line,response;
	
	
	public void getMedicine(String medicineId) throws IOException {
		URL url = new URL("http://localhost:9092/medicine/"+medicineId);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		int status =conn.getResponseCode();
		
		StringBuffer responseContent = new StringBuffer();
		
		if(status>299) {
			reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			while((line=reader.readLine())!= null) {
				responseContent.append(line);
			}
			
			reader.close();
		}
		
		else {
		
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((line=reader.readLine())!= null) {
				responseContent.append(line);
			}
			
			reader.close();
		}
		response= responseContent.toString();
		System.out.println(responseContent.toString());
	}
}
