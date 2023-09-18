import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Testing {

	public static void main(String[] args) throws Exception {
		
		 String dbUrl = "jdbc:mysql://localhost:3306/cybersecurity";
	        String dbUsername = "root";
	        String dbPassword = "root";
	        Scanner sc  =  new Scanner(System.in);
			System.out.println("Enter the Username ");
			String username = sc.next();
			System.out.println("Enter the Password ");
			String password = sc.next();
			 Connection connection = null;
		        Statement statement = null;
		        
		        try {
		        	
		        	 connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		             statement = connection.createStatement();
		             String query = "SELECT * FROM user WHERE username = ' ' or 1=1-- AND password = ' ' or 1=1--";
		             // Execute the query
		             ResultSet resultSet = statement.executeQuery(query);
		             if (resultSet.next()) {
		                 System.out.println("Login successful");
		             } else {
		                 System.out.println("Invalid username or password");
		             }
		        }catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		        	try {
		                if (statement != null) {
		                    statement.close();
		                }
		                if (connection != null) {
		                    connection.close();
		                }
		        }catch (SQLException e) {
	                e.printStackTrace();
	            }
		        }
	}
}
