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

public class SearchReaderDAO {
		
//public static ReaderList searchReader(String idreader) throws DAOException{
public static ReaderData searchReader(String idreader) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData data = null;
		ReaderList readerList = null;
		
		int enterID;
		int dataID;
	
		try {
			
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    
	    	/*rs = st.executeQuery("SELECT idreader, surname, name, patronymic, adress, phone, login, password FROM reader WHERE idreader = '"+ idreader + "'");
	    	if (rs.next()){
	    		data = new ReaderData(rs.getInt("idreader"), rs.getString("surname"), rs.getString("name"), rs.getString("patronymic"), rs.getString("adress"), rs.getString("phone"), rs.getString("login"), rs.getString("password"));
	    	}*/
	    	System.out.println("WHY");
	    	rs = st.executeQuery("SELECT idreader, surname, name, patronymic, adress, phone, login, password FROM reader WHERE status = 'user' AND deleteR = 0 ");
	    	System.out.println("WHY");
	    	
	    	//List<ReaderData> readers = new ArrayList<ReaderData>();
	    	while (rs.next()){
	    		data = new ReaderData(rs.getInt("idreader"), rs.getString("name"), rs.getString("surname"), rs.getString("patronymic"), rs.getString("adress"), rs.getString("phone"), rs.getString("login"), rs.getString("password"));
	    		//readers.add(data);
	    	}
	    	//System.out.println("WHY");
	    	
	    	enterID = Integer.parseInt(idreader);
	    	//System.out.println("WTF");
	    	//dataID = Integer.parseInt(data.idreader);
	    	//System.out.println("WTF");
	    	
	    	//System.out.println("enterID");
	    	//System.out.println(dataID);
	    	
	    	if(enterID > data.idreader){
	    		return null;
	    	}
	    	else{
	    		rs = st.executeQuery("SELECT idreader, surname, name, patronymic, adress, phone, login, password FROM reader WHERE idreader = '"+ idreader + "'");
		    	if (rs.next()){
		    		data = new ReaderData(rs.getInt("idreader"), rs.getString("surname"), rs.getString("name"), rs.getString("patronymic"), rs.getString("adress"), rs.getString("phone"), rs.getString("login"), rs.getString("password"));
		    	}
		    	return data;
	    	}
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в SearchReaderDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в SearchReaderDAO.");
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

		//return readerList;
		//return data;
		
	}
	
}
