package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program3 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
		con = DB.getConnection();
		
		st = con.prepareStatement(
				"DELETE FROM department "
				+ "WHERE "
				+ "Id = ?" );
		
		st.setInt(1, 2);
			
		int rowsAffected = st.executeUpdate();
		System.out.println("Done! Rows affected: " + rowsAffected);
		
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
