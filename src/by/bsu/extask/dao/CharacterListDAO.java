package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.CharacterData;
import by.bsu.extask.to.CharacterList;

public class CharacterListDAO {
	
public static CharacterList characterList() throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		CharacterList characterList = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	//rs = st.executeQuery("SELECT * FROM reader");
	    	rs = st.executeQuery("SELECT * FROM proba.`character`");
	    	
	    	List<CharacterData> characters = new ArrayList<CharacterData>();
	    	CharacterData data = null;
	    	while (rs.next()){
	    		data = new CharacterData(rs.getString("idcharacter"), rs.getString("characterName"));
	    		characters.add(data);
	    	}
	    	
	    	characterList = new CharacterList(characters);
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в CharacterListDAO");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в CharacterListDAO");
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

		return characterList;
		
	}
	
}
