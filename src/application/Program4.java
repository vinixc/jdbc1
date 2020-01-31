package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program4 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		
		try {
			con = DB.getConnection();
			
			con.setAutoCommit(false);
			
			st = con.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
//			int x = 1;
//			if(x < 2) {
//				throw new SQLException("Fake error");
//			}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			con.commit();
			
			System.out.println("rows1: " + rows1);
			
			System.out.println("rows2: " + rows2);
		}
		catch(SQLException e) {
			try {
				con.rollback();
				throw new DbException("Transaction rolled back! Caused By: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused By: " + e.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
