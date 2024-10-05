package com.p.demo.vaccine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class vaccine {
	
	private BufferedReader reader;
	private String line,response;
	
	public void getAllVaccines() throws IOException {
		URL url = new URL("http://localhost:9096/vaccine/all");
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
	
	public void getVaccine(String vaccineId) throws IOException {
		URL url = new URL("http://localhost:9096/vaccine/"+vaccineId);
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
