package by.bsu.extask.dao;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.AuthorData;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;

public class AddPublishingHouseDAO {
	
public static int oneEdition(String houseName, String city) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PublishingHouseData publishingHouseData = null;
		PublishingHouseData data = null;
		PublishingHouseList publishingHouseList = null;
		int max;
		String maxS;
		//int newIdhouse = max+1;
		int sizeList = 0;
		int result = 0;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:/127.0.0.1/proba?useUnicode=true&characterEncoding=utf8");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba?useUnicode=true&characterEncoding=utf8", "root", "");
			/*new com.mysql.jdbc.Driver(); 
			String url="jdbc:mysql://127.0.0.1/proba"; 
			Properties p=new Properties(); 
			//p.setProperty("user",user); 
			//p.setProperty("password",password); 
			p.setProperty("useUnicode","true"); 
			p.setProperty("characterEncoding","utf8"); 
			con=DriverManager.getConnection(url, p);
			
			Statement stat = con.createStatement(); 

			stat.execute("SET CHARACTER SET utf8"); 
			stat.execute("SET NAMES utf8");*/
			
			//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	
	    	rs = st.executeQuery("SELECT idhouse FROM publishingHouse");
	    	/*if (rs.next()){
	    		publishingHouseData = new PublishingHouseData(rs.getString("idreader"));
	    	}*/
	    	
	    	
	    	List<PublishingHouseData> houses = new ArrayList<PublishingHouseData>();

	    	while (rs.next()){
	    		data = new PublishingHouseData(rs.getString("idhouse"));
	    		houses.add(data);
	    	}
	    	
	    	rs = st.executeQuery("SELECT idhouse, houseName FROM publishingHouse WHERE houseName ='"+ houseName + "' ");
	    	if (rs.next()){
	    		publishingHouseData = new PublishingHouseData(rs.getString("idhouse"), rs.getString("houseName"));
	    	}
	    	
	    	if(publishingHouseData == null){
	    		publishingHouseList = new PublishingHouseList(houses);
	    		//sizeList = houses.size();
	    		data = houses.get(houses.size()-1);
	    		maxS = data.getIdHouse();
	    		max = Integer.parseInt(maxS);
	    	
	    		result = st.executeUpdate("INSERT INTO publishinghouse VALUES ("+ (max +1) + ",'" + houseName + "','" + city + "' ) ");
	    	}
	    	
	    	else{
	    		result = 0;
	    	}
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("������ �������� �������� in AddPublishingHouseDAO.");
	    }
		catch (SQLException e) {
	    	//System.out.println("66");
	    	System.out.println(e.toString());
	    	throw new DAOException("������ ������ � ���������� ������ in AddPublishingHouseDAO.");
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
