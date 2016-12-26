package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.bsu.extask.to.DeliveryData;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.to.ReaderData;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DeliveryEditionPassDAO {

public static int deliveryEditionPass(String idreader, String idedition) throws DAOException{
		
		Date d = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		int result;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	
	    	result = st.executeUpdate("UPDATE delivery SET deliveryTF = 1, dateReturn = ('" +  format1.format(d) + "') WHERE idreader = '"+ idreader + "' AND idedition = '" + idedition + "'");
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Вот тут ошибка in DeliveryEditionPassDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Вот тут ошибкаin DeliveryEditionPassDAO.");
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
