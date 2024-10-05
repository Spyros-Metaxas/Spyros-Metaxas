package com.p.demo.models;

public class Coordinates {
	
	private String latitude;
	private String longtitude;
	
	
	public Coordinates(String latitude, String longtitude) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
	}


	public Coordinates() {
		super();
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	
	

}
