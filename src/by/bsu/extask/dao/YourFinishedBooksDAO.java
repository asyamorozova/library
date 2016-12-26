package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.DeliveryData;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.to.ReaderData;

public class YourFinishedBooksDAO {

public static DeliveryList yourFinishedBooks(String login) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData readerData = null;
		DeliveryList deliveryList = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	
	    	rs = st.executeQuery("SELECT idreader FROM reader WHERE login = '"+ login + "'");
	    	if (rs.next()){
	    		readerData = new ReaderData(rs.getString("idreader"));
	    	}
	    	
	    	//rs = st.executeQuery("SELECT idreader, idedition, dateDelivery, timeReturn, dateReturn, deliveryTF FROM delivery WHERE idreader = "+ readerData.getIdReader() + " AND deliveryTF = 1;");
	    	
	    	//rs = st.executeQuery("SELECT idreader, idedition, dateDelivery, timeReturn, dateReturn, deliveryTF FROM delivery WHERE idreader = "+ readerData.getIdReader() + " ");
	    	
	    	List<DeliveryData> deliverys = new ArrayList<DeliveryData>();
	    	DeliveryData data = null;
	    	while (rs.next()){
	    		data = new DeliveryData(rs.getString("idreader"), rs.getString("idedition"), rs.getString("dateDelivery"), rs.getString("timeReturn"), rs.getString("dateReturn"));
	    		deliverys.add(data);
	    	}
	    	
	    	deliveryList = new DeliveryList(deliverys);
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("������ �������� �������� in DeliveryListDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("������ ������ � ���������� ������ in DeliveryListDAO.");
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

		return deliveryList;
		
	}
	
}
