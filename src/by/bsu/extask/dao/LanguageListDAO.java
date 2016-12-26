package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.LanguageData;
import by.bsu.extask.to.LanguageList;

public class LanguageListDAO {

public static LanguageList languageList() throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		LanguageList languageList = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	rs = st.executeQuery("SELECT idlanguage, languageName FROM language");
	    	
	    	List<LanguageData> languages = new ArrayList<LanguageData>();
	    	LanguageData data = null;
	    	while (rs.next()){
	    		data = new LanguageData(rs.getString("idlanguage"), rs.getString("languageName"));
	    		languages.add(data);
	    	}
	    	
	    	languageList = new LanguageList(languages);
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка загрузки драйвера в LanguageListDAO");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка работы с источником данных в LanguageListDAO");
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

		return languageList;
		
	}
	
}
