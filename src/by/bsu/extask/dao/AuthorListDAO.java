package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.AuthorData;
import by.bsu.extask.to.AuthorList;

public class AuthorListDAO {

public static AuthorList authorList() throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		AuthorList authorList = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	rs = st.executeQuery("SELECT idauthor, authorName FROM author");
	    	
	    	List<AuthorData> authors = new ArrayList<AuthorData>();
	    	AuthorData data = null;
	    	while (rs.next()){
	    		data = new AuthorData(rs.getString("idauthor"), rs.getString("authorName"));
	    		authors.add(data);
	    	}
	    	
	    	authorList = new AuthorList(authors);
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в AuthorListDAO");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в AuthorListDAO");
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

		return authorList;
		
	}
	
}
