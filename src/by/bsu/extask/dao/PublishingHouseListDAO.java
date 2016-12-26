package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;

public class PublishingHouseListDAO {

public static PublishingHouseList publishingHouseList() throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PublishingHouseList publishingHouseList = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	rs = st.executeQuery("SELECT idhouse, houseName, city FROM publishinghouse");
	    	
	    	List<PublishingHouseData> publishingHouses = new ArrayList<PublishingHouseData>();
	    	PublishingHouseData data = null;
	    	while (rs.next()){
	    		data = new PublishingHouseData(rs.getString("idhouse"), rs.getString("houseName"), rs.getString("city"));
	    		publishingHouses.add(data);
	    	}
	    	
	    	publishingHouseList = new PublishingHouseList(publishingHouses);
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка загрузки драйвера в PublishingHouseListDAO");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка работы с источником данных в PublishingHouseListDAO");
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

		return publishingHouseList;
		
	}
	
}
