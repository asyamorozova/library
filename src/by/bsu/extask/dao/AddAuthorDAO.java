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
import by.bsu.extask.to.ReaderData;

public class AddAuthorDAO {

public static int addAuthor(String authorName, String country) throws DAOException{
		
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	AuthorData authorData = null;
	AuthorData data = null;
	AuthorList authorList = null;
	int max;
	String maxS;
	//int newIdhouse = max+1;
	int sizeList = 0;
	int result = 0;
	
	try {
		//rs = st.executeQuery("SET NAMES 'utf8'");
		//rs = st.executeQuery("SET CHARACTER SET 'utf8'");
		
		Class.forName("org.gjt.mm.mysql.Driver");
    	//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
		//con = DriverManager.getConnection("jdbc:mysql://localhost:/127.0.0.1/proba?useUnicode=true&characterEncoding=utf8");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba?useUnicode=true&characterEncoding=utf8", "root", "");
		st = con.createStatement();
    	
    	/*Statement stat = con.createStatement(); 
		stat.execute("SET CHARACTER SET utf8"); 
		stat.execute("SET NAMES utf8");*/
    	
    	rs = st.executeQuery("SELECT idauthor FROM author");
    	/*if (rs.next()){
    		publishingHouseData = new PublishingHouseData(rs.getString("idreader"));
    	}*/
    	
    	List<AuthorData> authors = new ArrayList<AuthorData>();

    	while (rs.next()){
    		data = new AuthorData(rs.getString("idauthor"));
    		authors.add(data);
    	}
    	
    	rs = st.executeQuery("SELECT idauthor, authorName  FROM author WHERE authorName = '" + authorName + "' ");
    	if (rs.next()){
    		authorData = new AuthorData(rs.getString("idauthor"), rs.getString("authorName"));
    	}
    	
    	if(authorData == null){
    		//System.out.println("WTF?");
    		authorList = new AuthorList(authors);
    		//System.out.println("WTF?");
    		//sizeList = houses.size();
    		data = authors.get(authors.size()-1);
    		maxS = data.getIDAuthor();
    		max = Integer.parseInt(maxS);
    		
    		result = st.executeUpdate("INSERT INTO author VALUES ("+ (max +1) + ",'" + authorName + "','" + country + "' ) ");
    	}
    	else{
    		result = 0;
    	}
    	
    	rs = st.executeQuery("SELECT idauthor, authorName  FROM author WHERE authorName = '" + authorName + "' ");
    	if (rs.next()){
    		authorData = new AuthorData(rs.getString("idauthor"), rs.getString("authorName"));
    	}
    	System.out.println(authorData.authorName);
    	
    }
	catch (ClassNotFoundException e) {
    	System.out.println("55");
    	throw new DAOException("Ошибка in AddAuthorDAO.");
    }
	catch (SQLException e) {
    	//System.out.println("66");
    	System.out.println(e.toString());
    	throw new DAOException("Ошибка in AddAuthorDAO.");
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
