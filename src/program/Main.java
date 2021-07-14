package program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Main {
    public static void main(String[] args) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = DB.getConnection();
        PreparedStatement st = null;
        
        
        /*
    	consulta e recupera os dados vindo do banco
    	st = conn.createStatement();
    	rs = st.executeQuery("select * from department");
    	       	
    	while (rs.next()) {
    		System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
    	}*/
        
        try {
        	conn = DB.getConnection();  
        	
        	st = conn.prepareStatement(
        			"INSERT INTO seller"
        			+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
        			+ "VALUES "
        			+ "(?,?,?,?,?)");
        	
        	st.setString(1, "Marcelo Rocha");
        	st.setString(2, "marcelo@lols.com");
        	st.setDate(3, new java.sql.Date(sdf.parse("16/05/1991").getTime()));
        	st.setDouble(4, 3000.0);
        	st.setInt(5, 4);
        	
        	int rowsAffected = st.executeUpdate();
        	System.out.print("Done! Rows affected: " + rowsAffected);
        	
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

    }
}