package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program1 {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DB.getConnection();
			
			st = con.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?,?,?,?,?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Vinicius Carvalho");
			st.setString(2, "vinicius@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("02/01/2000").getTime()));
			st.setDouble(4, 3000.00);
			st.setInt(5, 4);
			
			/*
			st = con.prepareStatement("insert into department (name) values ('D1'),('D2')",
					Statement.RETURN_GENERATED_KEYS);
			*/
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			}
			else {
				System.out.println("No rown affected!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
	}

}
