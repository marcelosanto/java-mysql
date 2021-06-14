package program;

import java.sql.*;


import db.DB;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
        	conn = DB.getConnection();
        	
        	st = conn.createStatement();
        	
        	rs = st.executeQuery("select * from department");
        	
        	while (rs.next()) {
        		System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
        	}
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

    }
}