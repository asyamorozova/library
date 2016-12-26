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
import by.bsu.extask.to.BindingData;
import by.bsu.extask.to.BindingList;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;
import by.bsu.extask.to.AuthorData;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.AnnotationData;
import by.bsu.extask.to.AnnotationList;
import by.bsu.extask.to.PlaceData;
import by.bsu.extask.to.PlaceList;
import by.bsu.extask.to.CharacterData;

public class InfoAboutEditionDAO {
	
public static EditionData infoAboutEdition(String idedition) throws DAOException{
		
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
		String annotationName;
		String placeName;
		String characterName;

		LanguageData lanData = null;
    	BindingData binData = null;
    	PublishingHouseData houseData = null;
    	AuthorData authorData = null;
    	AnnotationData annotationData = null;
    	PlaceData placeData = null;
    	CharacterData characterData = null;
	
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	
	    	rs = st.executeQuery("SELECT idedition, idlanguage, idbinding, idseries, idhouse, idauthor, idcharacter, img FROM edition WHERE idedition = '"+ idedition + "'");
	   
	    	
	    	
	    	if (rs.next()){
	    		data = new EditionData(rs.getString("idedition"), rs.getString("idlanguage"), rs.getString("idbinding"), rs.getString("idseries"), rs.getString("idhouse"), rs.getString("idauthor"), rs.getString("idcharacter"), rs.getString("img"));
	    	}
	    	
	    	languageName = data.language;
    		rs = st.executeQuery("SELECT idlanguage, languageName FROM language WHERE idlanguage = '" + languageName +"'");
    		if (rs.next()){
    			lanData = new LanguageData(rs.getString("idlanguage"), rs.getString("languageName"));
    		}
    		
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
    		
    		authorName = data.author;
    		rs = st.executeQuery("SELECT idauthor, authorName FROM author WHERE idauthor = '" + authorName +"'");
    		if (rs.next()){
    			authorData = new AuthorData(rs.getString("idauthor"), rs.getString("authorName"));
    		}
    		
    		//annotationName = data.an
    		rs = st.executeQuery("SELECT idedition, annotation FROM annotation WHERE idedition = '"+ idedition + "'");
    		if (rs.next()){
    			annotationData = new AnnotationData(rs.getString("idedition"), rs.getString("annotation"));
    		}
    		
    		rs = st.executeQuery("SELECT idplace, numRack, numRackLittle, idedition FROM place WHERE idedition = '"+ idedition + "'");
    		if (rs.next()){
    			placeData = new PlaceData(rs.getString("idplace"), rs.getString("numRack"), rs.getString("numRackLittle"));
    		}
    		
    		rs = st.executeQuery("SELECT idedition, idlanguage, idbinding, idseries, idhouse, idauthor, idcharacter, img FROM edition");
    		if (rs.next()){
    			data = new EditionData(rs.getString("idedition"), rs.getString("idlanguage"), lanData.getLanguageName() ,rs.getString("idbinding"),binData.nameBinding , rs.getString("idseries"), rs.getString("idhouse"), houseData.nameHouse, rs.getString("idauthor"), authorData.authorName, rs.getString("idcharacter"), "FUCK", annotationData.annotation, placeData.idplace, placeData.numRack, placeData.numRackLittle, rs.getString("img"));
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
		return data;
		
	}
	
}
