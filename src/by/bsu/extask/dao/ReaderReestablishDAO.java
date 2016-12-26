package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.EditionData;

public class ReaderReestablishDAO {

public static int reestablishReader(String idreader) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData readerData = null;
		EditionData editionData = null;
		int result = 0;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	
	    	System.out.println(idreader);
	    	
	    	result = st.executeUpdate("UPDATE reader SET deleteR = '" + 0 +"' WHERE idreader = '"+ idreader + "'");
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Errors in DeleteReaderDAO.");
	    }
		catch (SQLException e) {
	    	//System.out.println("66");
	    	System.out.println(e.toString());
	    	throw new DAOException("SQL Errors in DeleteReaderDAO.");
	    }
		finally {
	    	try {
	    		if (rs != null) rs.close();
	    		if (st != null) st.close();
	    		if (con != null) con.close();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    } 
		
		return result;
		
	}
	
}
