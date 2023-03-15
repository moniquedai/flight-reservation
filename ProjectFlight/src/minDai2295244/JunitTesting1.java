package minDai2295244;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class JunitTesting1 {
	FlightController test=new FlightController();
	Flight model=new Flight();
	ViewFlight view=new ViewFlight();
	FinalProject project=new FinalProject();
	@Test
	void getOnBoardTest() {
		List<Flight> list= test.getFlightBoard();
		Flight flight=new Flight(13477,"Boeing 737","Montreal","Rome",480);
		assertTrue(list.contains(flight));
	}

	@Test
	void retrieveFromDatabaseTest() {
		Flight flight=new Flight(13477,"Boeing 737","Montreal","Rome",480,200,740);
		assertEquals(flight,FinalProject.retrieveFlightFromDatabase());
	}
	
		
	}


