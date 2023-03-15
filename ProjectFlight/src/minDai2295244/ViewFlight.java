package minDai2295244;

import java.util.Locale;

public class ViewFlight {
	 
	Locale engLocale=new Locale("en");
	Locale freLocale=new Locale("fr");
	
	

	public void printFlightDetails(int flightNumber,String flightName,String flightOrigin,
			 String flightDestination,int flightDuration,int totalSeats,double flightCost) {
		 System.out.println(" Flight Information:");
		 System.out.println(" Flight Number: "+flightNumber);
		 System.out.println(" Flight Name: "+flightName);
		 System.out.println(" Flight Origin: "+flightOrigin);
		 System.out.println(" Flight Destination: "+flightDestination);
		 System.out.println(" Flight Duration: "+flightDuration+ " minutes");
		 System.out.println(" Flight Total Seats: "+totalSeats);
		 System.out.println(" Flight Cost: $"+flightCost);
		 
	 }
	
	

}