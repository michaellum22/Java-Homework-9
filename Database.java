/* Program displays anybody with the last name Smith in the database I created */

import java.util.*; 
import java.sql.*;

public class Database {
public static void main(String[] args) throws Throwable{ // Main function
	Class.forName("com.mysql.jdbc.Driver"); // Loads driver
	System.out.println("Driver loaded");
	Enumeration<Driver> ed = DriverManager.getDrivers(); //Gets driver
	while(ed.hasMoreElements()){
		System.out.println((Driver)ed.nextElement());
		
	}
	Connection my_connection = DriverManager.getConnection("jdbc:mysql://localhost/Java", "mlum", "swiftie13"); //Connects to database
	System.out.println("Database connected");
	Statement statement = my_connection.createStatement();
	ResultSet my_results = statement.executeQuery("select * from my_table");
	ResultSet resultSet = statement.executeQuery("Select firstname, mi, lastname from Student where lastname" + "= 'Smith'");
	while (resultSet.next())
		System.out.println(resultSet.getString(1) + "/t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
	my_connection.close();
	
	
	
}
}
