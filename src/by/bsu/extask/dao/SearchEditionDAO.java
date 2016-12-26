package by.bsu.extask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;

import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;
import by.bsu.extask.to.LanguageData;
import by.bsu.extask.to.LanguageList;
import by.bsu.extask.to.PlaceData;
import by.bsu.extask.to.BindingData;
import by.bsu.extask.to.BindingList;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;
import by.bsu.extask.to.AuthorData;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.CharacterData;
import by.bsu.extask.to.PlaceData;

public class SearchEditionDAO {

public static EditionData searchEdition(String idedition) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		EditionData data = null;
		EditionList editionList = null;
		
		String languageName;
		String bindingName;
		String seriesName;
		String houseName;
		String authorName;
		String characterName;
		
		LanguageData lanData = null;
    	BindingData binData = null;
    	PublishingHouseData houseData = null;
    	AuthorData authorData = null;
    	CharacterData characterData = null;
    	PlaceData placeData = null;
    	
    	int editionID;
    	int dataID;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	
	    	//System.out.println(idedition);
	    	rs = st.executeQuery("SELECT idedition FROM edition");
	    	while (rs.next()){
	    		//editionList = new EditionData(rs.getString("language"), rs.getString("binding"), rs.getString("series"), rs.getString("publishingHouse"), rs.getString("author"), rs.getString("character"));
	    		data = new EditionData(rs.getString("idedition"));
	    	}
	    	editionID = Integer.parseInt(idedition);
	    	dataID = Integer.parseInt(data.idedition);
	    	System.out.println(editionID);
	    	System.out.println(dataID);
	    	if(editionID > dataID){
	    		return null;
	    	}
	    	
	    	else{	
	    	rs = st.executeQuery("SELECT idedition, idlanguage, idbinding, idseries, idhouse, idauthor, idcharacter, nameEdition FROM edition WHERE idedition = '"+ idedition + "'");
	    	if (rs.next()){
	    		data = new EditionData(rs.getString("idedition"), rs.getString("idlanguage"), rs.getString("idbinding"), rs.getString("idseries"), rs.getString("idhouse"), rs.getString("idauthor"), rs.getString("idcharacter"), rs.getString("nameEdition"));
	    	}
	    	
	    	languageName = data.language;
    		rs = st.executeQuery("SELECT idlanguage, languageName FROM language WHERE idlanguage = '" + languageName +"'");
    		if (rs.next()){
    			lanData = new LanguageData(rs.getString("idlanguage"), rs.getString("languageName"));
    		}
    		System.out.println(lanData.languageName);
    		
    		bindingName = data.binding;
    		rs = st.executeQuery("SELECT idbinding, bindingName FROM binding WHERE idbinding = '" + bindingName +"'");
    		if (rs.next()){
    			binData = new BindingData(rs.getString("idbinding"), rs.getString("bindingName"));
    		}
    		
    		houseName = data.publishingHouse;
    		rs = st.executeQuery("SELECT idhouse, houseName FROM publishinghouse WHERE idhouse = '" + houseName +"'");
    		if (rs.next()){
    			houseData = new PublishingHouseData(rs.getString("idhouse"), rs.getString("houseName"));
    		}
    		
    		characterName = data.character;
    		rs = st.executeQuery("SELECT idcharacter, characterName FROM proba.`character` WHERE idcharacter = '" + characterName +"'");
    		if (rs.next()){
    			characterData = new CharacterData(rs.getString("idcharacter"), rs.getString("characterName"));
    		}

    		rs = st.executeQuery("SELECT idplace, numRack, numRackLittle FROM place WHERE idedition = '" + data.idedition +"'");
    		if (rs.next()){
    			placeData = new PlaceData(rs.getString("idplace"), rs.getString("numRack"), rs.getString("numRackLittle"));
    		}
    		
    		authorName = data.author;
    		rs = st.executeQuery("SELECT idauthor, authorName FROM author WHERE idauthor = '" + authorName +"'");
    		if (rs.next()){
    			authorData = new AuthorData(rs.getString("idauthor"), rs.getString("authorName"));
    		}
    		
    		rs = st.executeQuery("SELECT idedition, dateEdition, idlanguage, idbinding, idseries, idhouse, idauthor, idcharacter, nameEdition FROM edition");
    		if (rs.next()){
    			data = new EditionData(idedition, rs.getString("dateEdition"), rs.getString("idlanguage"), lanData.getLanguageName() ,rs.getString("idbinding"),binData.nameBinding , rs.getString("idseries"), rs.getString("idhouse"), houseData.nameHouse, rs.getString("idauthor"), authorData.authorName, rs.getString("idcharacter"), characterData.characterName,rs.getString("nameEdition"), placeData.idplace, placeData.numRack, placeData.numRackLittle );
    		}
    		
    		return data;
	    	}
    		
    	}
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в SearchEditionDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("77");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в SearchEditionDAO.");
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

		//return readerList;
		
		
	}
	
}
