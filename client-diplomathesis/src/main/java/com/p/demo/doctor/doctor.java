package com.p.demo.doctor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class doctor {
	private BufferedReader reader;
	private String line,response;
	//private StringBuffer responseContent = new StringBuffer();
	
	public void getAllDoctors() throws IOException {
		URL url = new URL("http://localhost:9091/doctor/all");
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
	
	public void getDoctor(String doctorId) throws IOException {
		URL url = new URL("http://localhost:9091/doctor/"+doctorId);
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
