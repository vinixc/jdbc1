package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program2 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			
			con = DB.getConnection();
			
			st = con.prepareStatement(
						"UPDATE seller "
						+ "SET BaseSalary = BaseSalary + ? "
						+ "WHERE "
						+ "(DepartmentId = ?)");
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
