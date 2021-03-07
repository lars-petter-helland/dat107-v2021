package no.hvl.dat107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1PlainOldJDBC {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/dat107v21";
	static final String USER = "postgres";
	static final String PASS = "postgres";
// 	static final String DB_URL = "jdbc:postgresql://data1.hib.no:5432/lars-petter";
//	static final String USER = "lars-petter";
//	static final String PASS = "passord";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT id, navn FROM hello_jpa.person";
			ResultSet rs = stmt.executeQuery(sql);

	        System.out.println("Hello!");
	        
			while (rs.next()) {
				int id = rs.getInt("id");
				String navn = rs.getString("navn");

				// Display values
				System.out.print("ID: " + id);
				System.out.println(", Navn: " + navn);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		
		System.out.println("Goodbye!");
	}

}
