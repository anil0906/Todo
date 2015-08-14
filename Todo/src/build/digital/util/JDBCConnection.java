package build.digital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getConnection(){
		
		Connection con = null;
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:port/dbname","username", "password");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			
		}
		catch(SQLException ae){
			ae.printStackTrace();
		}
	return con;	
	}
	
	public static void putConnection(Connection con){
		
		try{
			con.close();
		}
		catch(SQLException ae){
			ae.printStackTrace();
		}
			
	}
	
}
