package minDai2295244;

import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;

public class FinalProject {
	public static Connection connect= ConnectTo_Datebase.getConnect();

	public static Flight retrieveFlightFromDatabase(){
		Flight flight = new Flight();
		flight.setFlightNumber(13477);
		flight.setFlightName("Boeing737");
		flight.setFlightOrigin("Montreal");
		flight.setFlightDestination("Rome");
		flight.setFlightDuration(480);
		flight.setTotalSeats(200);
		flight.setFlightCost(740);
		return flight;
	}

	public static void main(String[] args) {
		Flight model  = retrieveFlightFromDatabase();
		ViewFlight view=new ViewFlight();
		FlightController controller1 = new FlightController(model, view);
		controller1.updateView();

		controller1.setFlightCost(890);
		System.out.println("\nNow the new Flight info will be:");
		controller1.updateView();

		Locale locale=Locale.getDefault();
		Locale frLocale=new Locale("fr","FR");
		Locale enLocale=new Locale("en","US");

		FlightController controller=new FlightController();
		Scanner input=new Scanner(System.in);
		
		//read the origin database
		System.out.println("\nThe origin database has 6 flights, below are the information:");
		controller.readFromDatabase();

		//edit flight
		controller.editFlight();
		System.out.println("\nAfter edit, the database will change to:");
		controller.readFromDatabase();

		//remove flight from database
		controller.removeFlight();
		System.out.println("\nAfter remove the flight, the database updated to:");
		controller.readFromDatabase();

		//add flight
		controller.addFlight();
		System.out.println("\nAfter add the new flight, the database updated to:");
		controller.readFromDatabase();

		//returning List<Flight> to get the boarding information using Lamda Expression 
		controller.getFlightBoard().forEach(s->
			System.out.println(s.getFlightNumber()+ " | "+s.getFlightName()+ " | "+s.getFlightOrigin()
			+ " | "+s.getFlightDestination()+ " | "+s.getFlightDuration()));
		

		input.close();



	}
}