import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrepareSQLInjection {

	
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
				  PreparedStatement preparedStatement = null;
			        
			        try {
			        	
			        	 connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			           ///  statement = connection.createStatement();
			             String query = "SELECT * FROM user WHERE username = ? AND password = ?";
			             // Execute the query
			             // Create a prepared statement
			             preparedStatement = connection.prepareStatement(query);
			             
			            
			             preparedStatement.setString(1, username);
			             preparedStatement.setString(2, password);
			             // Execute the query
			             ResultSet resultSet = preparedStatement.executeQuery();
			             if (resultSet.next()) {
			                 System.out.println("Login successful");
			             } else {
			                 System.out.println("Invalid username or password");
			             }
			        }catch (SQLException e) {
			            e.printStackTrace();
			        } finally {
			        	try {
			                if (preparedStatement != null) {
			                	preparedStatement.close();
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
