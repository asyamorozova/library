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

public class CheckInDAO {
	
public static int checkInReader(String idreader, String login, String password) throws DAOException{
	
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData readerData = null;
		
		int result;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	
	    	/*rs = st.executeQuery("SELECT idreader FROM reader WHERE idreader='"+ idreader +"'");
	    	if (rs.next()){
	    		//readerData = new ReaderData(rs.getString("idreader"));
	    		readerData = new ReaderData(rs.getString("idreader"));
	    	}
	    	if(readerData.Idreader == ""){
	    		result = 0;
	    	}
	    	if(readerData.Idreader != ""){*/
	    		result = st.executeUpdate("UPDATE reader SET login ='" + login + "' , password = '" + password + "' WHERE idreader = '"+ idreader +"' ");
	    	//}
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Вот тут ошибка in CheckInDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Вот тут ошибкаin CheckInDAO.");
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
