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

public class AddEditionToReaderDAO {

public static int addEditToReader(String login, String idedition) throws DAOException{
		
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
	    	
	    	if(login==""){
	    		System.out.println("Ну и почему ты пустая?");
	    	}
	    	
	    	rs = st.executeQuery("SELECT idreader FROM reader WHERE login = '"+ login + "'");
	    	if (rs.next()){
	    		readerData = new ReaderData(rs.getString("idreader"));
	    	}
	    	
	    	//result = st.executeUpdate("INSERT INTO reader ([idreader], [surname], [name], [patronymic], [adress], [phone]) VALUES ("+ 1 + ",'" + surname + "','" + name +"','" + patronymic + "','" + adress + "','" + phone + "' ) ");
	    	result = st.executeUpdate("INSERT INTO delivery VALUES ("+ readerData.getIdReader() + "," + idedition + "," + null + "," + null + "," + null + " ) ");
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка загрузки драйвера in AddEditionToReaderDAO.");
	    }
		catch (SQLException e) {
	    	//System.out.println("66");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка работы с источником данных in AddEditionToReaderDAO.");
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
