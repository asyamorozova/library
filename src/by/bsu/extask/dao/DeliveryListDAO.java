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
import by.bsu.extask.to.EditionData;

public class DeliveryListDAO {
	
public static DeliveryList deliveryList(String login) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData readerData = null;
		DeliveryList deliveryList = null;
		EditionData editionData = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	
	    	rs = st.executeQuery("SELECT idreader, login FROM reader WHERE login = '"+ login + "'");
	    	if (rs.next()){
	    		//readerData = new ReaderData(rs.getString("idreader"));
	    		readerData = new ReaderData(rs.getString("idreader"),rs.getString("login"));
	    	}
	    	
	    	String loginReader = readerData.getLogin();
	    	
	    	rs = st.executeQuery("SELECT idreader, idedition, dateDelivery, timeReturn, dateReturn, deliveryTF FROM delivery WHERE idreader = "+ readerData.getIdReader() + " AND deliveryTF = 0");
	    	
	    	List<DeliveryData> deliverys = new ArrayList<DeliveryData>();
	    	DeliveryData data = null;
	    	while (rs.next()){
	    		//data = new DeliveryData(rs.getString("idreader"), rs.getString("idedition"), rs.getString("dateDelivery"), rs.getString("timeReturn"), rs.getString("dateReturn"));
	    		data = new DeliveryData(rs.getString("idreader"), rs.getString("idedition"), rs.getString("dateDelivery"), rs.getString("timeReturn"), rs.getString("dateReturn"), loginReader);
	    		deliverys.add(data);
	    	}
	    	
	    	deliveryList = new DeliveryList(deliverys);
	    	
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Вот тут ошибка in DeliveryListDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Вот тут ошибкаin DeliveryListDAO.");
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
