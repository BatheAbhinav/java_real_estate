package realEstate_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class GetConnection
{
	Connection con;
	GetConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/project_of_realestate";
		String userName = "root";
		String password = "<password>";
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(url, userName, password);

	}
}

public class Main extends Thread{

	public static void main(String[] args) throws InterruptedException {
		
		new RealEstatePortal();
		
	}

}
