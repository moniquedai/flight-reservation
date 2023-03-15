package minDai2295244;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightController {
	private Flight model;
	private ViewFlight view;
	public static Connection connect= ConnectTo_Datebase.getConnect();
	public static Scanner input= new Scanner(System.in);

	public FlightController () {
	}

	
	public List<Flight> getFlightBoard() {
		List<Flight> list = new ArrayList<>();
		try {
			String ready="select Flight_Number, Flight_Name,Flight_Origin,Flight_Destination,"
					+ "Flight_Duration from flight order by Flight_Number asc;";
			PreparedStatement stat=connect.prepareStatement(ready);
			ResultSet results = stat.executeQuery();
			while(results.next()) {
				list.add(new Flight(results.getInt("Flight_Number"),results.getString("Flight_Name"),
						results.getString("Flight_Origin"),results.getString("Flight_Destination"),
						results.getInt("Flight_Duration")
						));
			}
		}catch(Exception e) {
		}
		return list;
	}

	public void removeFlight() {
		try {
			System.out.println("\nPlease enter flight number of the flight you want to remove:");
			int flightNumber=input.nextInt();
			String ready="DELETE FROM flight WHERE Flight_Number= ?";
			PreparedStatement stat=connect.prepareStatement(ready);
			stat.setInt(1,flightNumber);
			stat.executeUpdate();

		}catch(Exception e) {
		}
	}

	
	public void editFlight() {
		try {
			String ready="UPDATE flight set ";
			System.out.println("\nPlease enter the flight number you would like to edit:");
			int change=input.nextInt();
			System.out.println("please enter the new flight number: (if no need to change, enter 0)");
			int flightNumber=input.nextInt();
			if(flightNumber!=0) {
				PreparedStatement stat=connect.prepareStatement(ready+"Flight_Number=? "+"where Flight_Number=?");
				stat.setInt(1,flightNumber);
				stat.setInt(2, change);
				stat.executeUpdate();
			}
			System.out.println("Please enter flight name:(if no need to change, enter 0)");
			input.nextLine();
			String flightName=input.nextLine();
			if(!flightName.equals("0")) {
				PreparedStatement stat=connect.prepareStatement(ready+"Flight_Name=? "+"where Flight_Number=?");
				stat.setString(1,flightName);
				stat.setInt(2, flightNumber);
				stat.executeUpdate();
			}
			System.out.println("Please enter flight origin:(if no need to change, enter 0)");
			String flightOrigin=input.nextLine();
			if(!flightOrigin.equals("0")) {
				PreparedStatement stat=connect.prepareStatement(ready+"Flight_Origin=? "+"where Flight_Number=?");
				stat.setString(1, flightOrigin);
				stat.setInt(2, flightNumber);
				stat.executeUpdate();
			}
			System.out.println("Please enter flight destination:(if no need to change, enter 0)");
			String flightDestination=input.nextLine();
			if(!flightDestination.equals("0")) {
				PreparedStatement stat=connect.prepareStatement(ready+"Flight_Destination=? "+"where Flight_Number=?");
				stat.setString(1, flightDestination);
				stat.setInt(2, flightNumber);
				stat.executeUpdate();
			}
			System.out.println("please enter the flight duration: (if no need to change, enter 0)");
			int flightDuration=input.nextInt();
			if(flightDuration!=0) {
				PreparedStatement stat=connect.prepareStatement(ready+"Flight_Duration=? "+"where Flight_Number=?");
				stat.setInt(1, flightDuration);
				stat.setInt(2, flightNumber);
				stat.executeUpdate();
			}
			System.out.println("please enter the total seats: (if no need to change, enter 0)");
			int totalSeats=input.nextInt();
			if(totalSeats!=0) {
				PreparedStatement stat=connect.prepareStatement(ready+"Total_Seats=? "+"where Flight_Number=?");
				stat.setInt(1, totalSeats);
				stat.setInt(2, flightNumber);
				stat.executeUpdate();
			}
			System.out.println("please enter the flight cost: (if no need to change, enter 0)");
			double flightCost=input.nextDouble();
			input.nextLine();
			if(flightCost!=0) {
				PreparedStatement stat=connect.prepareStatement(ready+"Flight_Cost=? "+"where Flight_Number=?");
				stat.setDouble(1,flightCost);
				stat.setInt(2, flightNumber);
				stat.executeUpdate();
			}
		}catch(Exception e) {
		}
	}
	
	
	public void addFlight(){	
		try {
			String ready="insert into flight(Flight_Number,Flight_Name,Flight_Origin,Flight_Destination,"
					+ "Flight_Duration,Total_Seats,Flight_Cost) values(?,?,?,?,?,?,?)";
			PreparedStatement pstat=connect.prepareStatement(ready);
			System.out.println("\nplease enter the flight number you want to add");
			int flightNumber=input.nextInt();
			System.out.println("Please enter the flight name");
			input.nextLine();
			String flightName=input.nextLine();
			System.out.println("Please enter flight origin");
			String flightOrigin=input.nextLine();
			System.out.println("Please enter flight destination");
			String flightDestination=input.nextLine();
			System.out.println("please enter the  flight duration");
		    int flightDuration=input.nextInt();
			System.out.println("please enter the  total seats");
			int totalSeats=input.nextInt();
			System.out.println("please enter the  flight cost");
		    double flightCost=input.nextDouble();
			input.nextLine();
			pstat.setInt(1,flightNumber);
			pstat.setString(2,flightName);
			pstat.setString(3,flightOrigin);
			pstat.setString(4,flightDestination);
			pstat.setInt(5,flightDuration);
			pstat.setInt(6,totalSeats);
			pstat.setDouble(7,flightCost);
			pstat.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public  void readFromDatabase() {

		try {	
			String sql="select * from flight order by Flight_Number asc;";
			Statement statement=connect.createStatement();
			ResultSet result= statement.executeQuery(sql);
			while(result.next()){

				int flightNumber=result.getInt("Flight_Number");
				String flightName=result.getString("Flight_Name");
				String flightorigin=result.getString("Flight_Origin");
				String flightDestination=result.getString("Flight_Destination");
				int flightDuration=result.getInt("Flight_Duration");
				int totalSeats=result.getInt("Total_Seats");
				Double flightCost=result.getDouble("Flight_Cost");
				System.out.println(flightNumber+"|"+flightName+"|"+flightorigin+"|"+flightDestination
						+"|"+flightDuration+"|"+totalSeats+"|"+flightCost);
			}	
		}catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public FlightController(Flight model, ViewFlight view){
		this.model=model;
		this.view=view;
	}

	public void setFlightNumber(int number) {
		model.setFlightNumber(number);
	}

	public void getFlightNumber() {
		model.getFlightNumber();
	}

	public void setFlightName(String name) {
		model.setFlightName(name);
	}

	public void getFlightName() {
		model.getFlightName();
	}

	public void setFlightOrigin(String origin) {
		model.setFlightOrigin(origin);
	}

	public void getFlightOrigin() {
		model.getFlightOrigin();
	}

	public void setFlightDestination(String destination) {
		model.setFlightDestination(destination);
	}

	public void getFlightDestination() {
		model.getFlightDestination();
	}

	public void setFlightDuration(int duration) {
		model.setFlightDuration(duration);
	}

	public void getFlightDuration() {
		model.getFlightDuration();
	}

	public void setFlightTotalSeats(int totalSeats) {
		model.setTotalSeats(totalSeats);
	}

	public void getFlightTotalSeats() {
		model.getTotalSeats();
	}

	public void setFlightCost(double cost) {
		model.setFlightCost(cost);
	}

	public void getFlightCost() {
		model.getFlightCost();
	}

	public void updateView() {
		view.printFlightDetails(model.getFlightNumber(), model.getFlightName(), model.getFlightOrigin(), 
				model.getFlightDestination(),model.getFlightDuration(),model.getTotalSeats(),
				model.getFlightCost());
	}

	
}