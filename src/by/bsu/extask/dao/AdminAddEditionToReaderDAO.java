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
import by.bsu.extask.to.DeliveryData;

import java.util.Date;
import java.text.SimpleDateFormat;

public class AdminAddEditionToReaderDAO {

	public static int adminAddEditToReader(String login, String idedition, String timeReturn) throws DAOException{
		
		Date d = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData readerData = null;
		DeliveryData deliveryData = null;
		int result = 0;
		int be = 0;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//System.out.println("WTF");
	    	
	    	rs = st.executeQuery("SELECT idreader FROM reader WHERE login = '"+ login + "'");
	    	if (rs.next()){
	    		readerData = new ReaderData(rs.getString("idreader"));
	    	}
	    	
	    	/*rs = st.executeQuery("SELECT idreader, idedition FROM delivery WHERE idreader = '"+ readerData.getIdReader() + "' AND idedition = '" + idedition +"'");
	    	if (rs.next()){
	    		deliveryData = new DeliveryData(rs.getString("idreader"), rs.getString("idedition"));
	    	}*/
	    	
	    	rs = st.executeQuery("SELECT idedition, deliveryTF FROM delivery WHERE idedition = '" + idedition +"' AND deliveryTF = "+ 0 +" ");
	    	if (rs.next()){
	    		deliveryData = new DeliveryData(rs.getString("idedition"));
	    	}
	    	
	    	if(deliveryData == null){
	    		result = st.executeUpdate("INSERT INTO delivery VALUES ("+ readerData.getIdReader() + "," + idedition + ",'" + format1.format(d) + "'," + timeReturn + ", dateDelivery + INTERVAL timeReturn DAY ," + 0 + " ) ");
	    	}
	    	
	    	else{
	    		result = 0;
	    	}
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка тут in AdminAddEditionToReaderDAO.");
	    }
		catch (SQLException e) {
	    	//System.out.println("66");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка тут in AdminAddEditionToReaderDAO.");
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
