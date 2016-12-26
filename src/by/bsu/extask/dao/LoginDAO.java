package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.bsu.extask.to.ReaderData;

public class LoginDAO {

	public static ReaderData checkUser(String login, String password) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData data = null;
	    
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
			//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Library", "root", "");
	    	st = con.createStatement();
	    	rs = st.executeQuery("SELECT name, surname, status FROM reader WHERE login='"+login+"'AND password='"+password+"'");
	    	if (rs.next()){
	    		data = new ReaderData(rs.getString("name"), rs.getString("surname"), rs.getString("status"));
	    	}
	    	
	    } catch (ClassNotFoundException e) {
	    	System.out.println("55 errors in LoginDAO");
	    	throw new DAOException("Ошибка в LoginDAO.");
	    } catch (SQLException e) {
	    	//System.out.println("66 errors in LoginDAO");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в LoginDAO.");
	    } finally {
	    	try {
	    		if (rs != null) rs.close();
	    		if (st != null) st.close();
	    		if (con != null) con.close();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    } 
		System.out.println(data.status);
		return data;
	}
	
}
