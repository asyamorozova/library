package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;
import by.bsu.extask.to.DeliveryData;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.to.LanguageData;

public class ShowAllDebtorDAO {

public static ReaderList readerList() throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderList readerList = null;
		DeliveryData delData = null;
		DeliveryList deliveryList = null;
	 	
		int error = 0;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	rs = st.executeQuery("SELECT idreader, surname, name, patronymic, adress, phone, login, password FROM reader WHERE status = 'user'");
	    	
	    	List<ReaderData> readers = new ArrayList<ReaderData>();
	    	ReaderData data = null;
	    	while (rs.next()){
	    		data = new ReaderData(rs.getInt("idreader"), rs.getString("name"), rs.getString("surname"), rs.getString("patronymic"), rs.getString("adress"), rs.getString("phone"), rs.getString("login"), rs.getString("password"));
	    		readers.add(data);
	    	}
	    	readerList = new ReaderList(readers);
	    	
	    	for(int i = 0; i < readers.size(); ++i){
	    		String id = readers.get(i).Idreader;
	    		//rs = st.executeQuery("SELECT idreader, idedition, dateDelivery, timeReturn, dateReturn, deliveryTF FROM delivery WHERE idreader = '" + id +"'");
	    		//delData = new DeliveryData(rs.getString("idreader"), rs.getString("idedition"), rs.getString("dateDelivery"), rs.getString("timeReturn"), rs.getString("dateReturn"));
	    		
	    		rs = st.executeQuery("SELECT idreader, idedition, dateDelivery, timeReturn, dateReturn, deliveryTF FROM delivery WHERE idreader = "+ id + " AND deliveryTF = 1");
	    		
	    		List<DeliveryData> deliverys = new ArrayList<DeliveryData>();
		    	DeliveryData dataD = null;
		    	while (rs.next()){
		    		//data = new DeliveryData(rs.getString("idreader"), rs.getString("idedition"), rs.getString("dateDelivery"), rs.getString("timeReturn"), rs.getString("dateReturn"));
		    		dataD = new DeliveryData(rs.getString("idreader"), rs.getString("idedition"), rs.getString("dateDelivery"), rs.getString("timeReturn"), rs.getString("dateReturn"));
		    		deliverys.add(dataD);
		    	}
		    	
		    	deliveryList = new DeliveryList(deliverys);
		    	if(deliveryList == null){
		    		continue;
		    	}
		    	else{
		    		//error = 1;
		    		rs = st.executeQuery("SELECT idreader, surname, name, patronymic, adress, phone, login, password FROM reader WHERE idreader = '" + id + "'");
		    		data = new ReaderData(rs.getInt("idreader"), rs.getString("name"), rs.getString("surname"), rs.getString("patronymic"), rs.getString("adress"), rs.getString("phone"), rs.getString("login"), rs.getString("password"));
		    		readers.add(data);
		    	}
	    	}
	    	
	    	/*if(error !=0){
	    		rs = st.executeQuery("SELECT idreader, surname, name, patronymic, adress, phone, login, password FROM reader WHERE status = 'user'");
	    		while (rs.next()){
	    			data = new ReaderData(rs.getInt("idreader"), rs.getString("name"), rs.getString("surname"), rs.getString("patronymic"), rs.getString("adress"), rs.getString("phone"), rs.getString("login"), rs.getString("password"));
		    		readers.add(data);
	    		}
	    		readerList = new ReaderList(readers);
	    	}*/
	    	
	    	readerList = new ReaderList(readers);
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в ShowAllDebtor.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в ShowAllDebtor.");
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

		return readerList;
		
	}
	
}
	

