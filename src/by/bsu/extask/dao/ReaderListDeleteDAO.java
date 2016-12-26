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

public class ReaderListDeleteDAO {

public static ReaderList readerListDelete() throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderList readerList = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader"); 
	    	rs = st.executeQuery("SELECT idreader, surname, name, patronymic, adress, phone, login, password FROM reader WHERE status = 'user' AND deleteR = 1 ");
	    	
	    	List<ReaderData> readers = new ArrayList<ReaderData>();
	    	ReaderData data = null;
	    	while (rs.next()){
	    		data = new ReaderData(rs.getInt("idreader"), rs.getString("name"), rs.getString("surname"), rs.getString("patronymic"), rs.getString("adress"), rs.getString("phone"), rs.getString("login"), rs.getString("password"));
	    		readers.add(data);
	    	}
	    	
	    	readerList = new ReaderList(readers);
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в ReaderListDeleteDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в ReaderListDeleteDAO.");
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
