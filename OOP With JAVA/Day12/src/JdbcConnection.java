import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;



public class JdbcConnection {

	public static void main(String [] args) {

		

		

		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "root");

				Statement stSelect1 = connection.createStatement();

				ResultSet result1 = stSelect1.executeQuery("select * from cards");

				

				Statement stSelect2 = connection.createStatement();

				ResultSet result2 = stSelect2.executeQuery("select * from user");

				

				Statement stSelect3 = connection.createStatement();

				ResultSet result3 = stSelect3.executeQuery("select * from transactions");) {

			//Class.forName("com.mysql.cj.jdbc.Driver");

			

			System.out.println("User Table::");

			while(result2.next()) {

				System.out.println(result2.getString("username"));

				System.out.println(result2.getString("name"));

				System.out.println(result2.getString("email"));

				System.out.println(result2.getString("password"));

				System.out.println(result2.getString("mobno"));

				System.out.println("-----------------------------------------");

			}

			

			System.out.println("Card Table::");

			while(result1.next()) {

				System.out.println(result1.getString("cardNumber"));

				System.out.println(result1.getString("expiry"));

				System.out.println(result1.getString("balance"));

				System.out.println(result1.getString("status"));

				System.out.println("-----------------------------------------");

			}

				

			System.out.println("Transaction Table::");

			while(result3.next()) {

				System.out.println(result3.getString("transactionID"));

				System.out.println(result3.getString("cardNumber"));

				System.out.println(result3.getString("username"));

				System.out.println(result3.getString("transactionDate"));

				System.out.println(result3.getString("transactionAmount"));

				System.out.println(result3.getString("transactionStatus"));

				System.out.println("-----------------------------------------");

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		

	}

}