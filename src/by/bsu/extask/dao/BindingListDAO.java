package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.BindingData;
import by.bsu.extask.to.BindingList;

public class BindingListDAO {

public static BindingList bindingList() throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BindingList bindingList = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	rs = st.executeQuery("SELECT idbinding, bindingName FROM binding");
	    	
	    	List<BindingData> bindings = new ArrayList<BindingData>();
	    	BindingData data = null;
	    	while (rs.next()){
	    		data = new BindingData(rs.getString("idbinding"), rs.getString("bindingName"));
	    		bindings.add(data);
	    	}
	    	
	    	bindingList = new BindingList(bindings);
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка загрузки драйвера в BindingListDAO");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка работы с источником данных в BindingListDAO");
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

		return bindingList;
		
	}
	
}
