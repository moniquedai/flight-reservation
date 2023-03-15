package minDai2295244;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTo_Datebase {

	private Connection connect;
	private static final ConnectTo_Datebase INSTANCE = new ConnectTo_Datebase();
	private ConnectTo_Datebase(){
		try {
			String url="jdbc:sqlite:/"+ System.getProperty("user.dir")+ "\\database\\flightdb.db";
			connect=(Connection)DriverManager.getConnection(url);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		return INSTANCE.connect;
	}



}

		


	