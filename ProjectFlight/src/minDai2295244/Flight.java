package minDai2295244;

import java.sql.Connection;

public class Flight {
	
	private int flightNumber;
	private String flightName;
	private String flightOrigin;
	private String flightDestination;
	private int flightDuration;
	private int totalSeats;
	private double flightCost;
	public static Connection connect= ConnectTo_Datebase.getConnect();
	public Flight() {
		
	}
	
	public Flight(int flightNumber, String flightName, String flightOrigin, String flightDestination,
			int flightDuration) {
		this.flightNumber=flightNumber;
		this.flightName=flightName;
		this.flightOrigin=flightOrigin;
		this.flightDestination=flightDestination;
		this.flightDuration=flightDuration;
	}
	
	public Flight(int flightNumber, String flightName, String flightOrigin, String flightDestination,
			int flightDuration, int totalSeats,double flightCost) {
		this.flightNumber=flightNumber;
		this.flightName=flightName;
		this.flightOrigin=flightOrigin;
		this.flightDestination=flightDestination;
		this.flightDuration=flightDuration;
		this.totalSeats=totalSeats;
		this.flightCost=flightCost;
		
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String getFlightName() {
		return flightName;
	}
	
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	
	public String getFlightOrigin() {
		return flightOrigin;
	}
	
	public void setFlightOrigin(String flightOrigin) {
		this.flightOrigin = flightOrigin;
	}
	
	public String getFlightDestination() {
		return flightDestination;
	}
	
	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}
	
	public int getFlightDuration() {
		return flightDuration;
	}
	
	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	public double getFlightCost() {
		return flightCost;
	}
	
	public void setFlightCost(double flightCost) {
		this.flightCost = flightCost;
	}

}

