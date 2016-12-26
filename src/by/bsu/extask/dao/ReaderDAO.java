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

public class ReaderDAO {

	//public static int oneReader(int number, String name, String surname, String patronymic, String adress, String phone) throws DAOException{
	public static int oneReader(String name, String surname, String patronymic, String adress, String phone) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ReaderData data = null;
		ReaderData readerData = null;
		ReaderList readerList = null;
		int max;
		String maxS;
		//int newIdhouse = max+1;
		int sizeList = 0;
		int result = 0;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba?useUnicode=true&characterEncoding=utf8", "root", "");
	    	st = con.createStatement();
	    	
	    	rs = st.executeQuery("SELECT idreader FROM reader");
	    	
	    	List<ReaderData> readers = new ArrayList<ReaderData>();

	    	while (rs.next()){
	    		data = new ReaderData(rs.getString("idreader"));
	    		readers.add(data);
	    	}
	    	readerList = new ReaderList(readers);
	    	//sizeList = houses.size();
	    	data = readers.get(readers.size()-1);
	    	maxS = data.getIdReader();
	    	max = Integer.parseInt(maxS);
	    	
	    	//result = st.executeUpdate("INSERT INTO reader ([idreader], [surname], [name], [patronymic], [adress], [phone]) VALUES ("+ 1 + ",'" + surname + "','" + name +"','" + patronymic + "','" + adress + "','" + phone + "' ) ");
	    	result = st.executeUpdate("INSERT INTO reader VALUES ("+ (max + 1) + ",'" + surname + "','" + name +"','" + patronymic + "','" + adress + "','" + phone + "','" + phone + "','" + phone + "','" + "user" + "', '" + 0 + "') ");
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в ReaderDAO.");
	    }
		catch (SQLException e) {
	    	//System.out.println("66");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в ReaderDAO.");
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
