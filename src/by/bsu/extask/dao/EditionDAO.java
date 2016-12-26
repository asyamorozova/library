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
import by.bsu.extask.to.LanguageData;
import by.bsu.extask.to.LanguageList;
import by.bsu.extask.to.BindingData;
import by.bsu.extask.to.BindingList;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;
import by.bsu.extask.to.AuthorData;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.CharacterData;
import by.bsu.extask.to.CharacterList;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;
import by.bsu.extask.to.PlaceData;
import by.bsu.extask.to.PlaceList;

public class EditionDAO {

public static EditionList oneEdition(/*String language, String binding, String series, String publishingHouse, String author, String character, String languageName, String languageString*/) throws DAOException{
	//public static EditionData oneEdition(int language, int binding, int series, int publishingHouse, int author, int character, String languageName, String languageString) throws DAOException{		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		EditionList editionList = null;
		EditionList editionListNew = null;
		
		String languageName;
		String bindingName;
		String seriesName;
		String houseName;
		String authorName;
		String characterName;
		
		String place;
		String numRack;
		String numRackLittle;
		
		//EditionData editionList = null;
		//LanguageData languageList = null;
		
		LanguageData lanData = null;
		List<LanguageData> languages = new ArrayList<LanguageData>();
		LanguageList languageList = null;
    	BindingData binData = null;
    	List<BindingData> bindings = new ArrayList<BindingData>();
    	BindingList bindingList = null;
    	PublishingHouseData houseData = null;
    	List<PublishingHouseData> houses = new ArrayList<PublishingHouseData>();
    	PublishingHouseList houseList = null;
    	AuthorData authorData = null;
    	List<AuthorData> authors = new ArrayList<AuthorData>();
    	AuthorList authorList = null;
    	CharacterData characterData = null;
    	List<CharacterData> characters = new ArrayList<CharacterData>();
    	
    	PlaceData placeData = null;
    	List<PlaceData> places = new ArrayList<PlaceData>();
		
		//���� ��� ������� �����
		int idLanguage;
		
		//int result = 0;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba", "root", "");
	    	st = con.createStatement();
	    	
	    	List<EditionData> editions = new ArrayList<EditionData>();
	    	List<EditionData> editionsNew = new ArrayList<EditionData>();
	    	EditionData data = null;
	    	
	    	rs = st.executeQuery("SELECT idedition, idlanguage, idbinding, idseries, idhouse, idauthor, idcharacter, img FROM edition");
	    	
	    	while (rs.next()){
	    		//editionList = new EditionData(rs.getString("language"), rs.getString("binding"), rs.getString("series"), rs.getString("publishingHouse"), rs.getString("author"), rs.getString("character"));
	    		data = new EditionData(rs.getString("idedition"), rs.getString("idlanguage"), rs.getString("idbinding"), rs.getString("idseries"), rs.getString("idhouse"), rs.getString("idauthor"), rs.getString("idcharacter"), rs.getString("img"));
	    		editions.add(data);
	    	}
	    	editionList = new EditionList(editions);
	    	
	    	//System.out.println("FUCK");
	    	for(int i = 0; i < editions.size(); ++i){
	    		languageName = editions.get(i).language;
	    		/*System.out.println("FUCK");
	    		System.out.println(editions.get(i).language);*/
	    		rs = st.executeQuery("SELECT idlanguage, languageName FROM language WHERE idlanguage = '" + languageName +"'");
	    		if (rs.next()){
	    			lanData = new LanguageData(rs.getString("idlanguage"), rs.getString("languageName"));
	    		}
	    		languages.add(lanData);
	    		
	    		bindingName = editions.get(i).binding;
	    		rs = st.executeQuery("SELECT idbinding, bindingName FROM binding WHERE idbinding = '" + bindingName +"'");
	    		if (rs.next()){
	    			binData = new BindingData(rs.getString("idbinding"), rs.getString("bindingName"));
	    		}
	    		bindings.add(binData);
	    		
	    		houseName = editions.get(i).publishingHouse;
	    		rs = st.executeQuery("SELECT idhouse, houseName FROM publishinghouse WHERE idhouse = '" + houseName +"'");
	    		if (rs.next()){
	    			houseData = new PublishingHouseData(rs.getString("idhouse"), rs.getString("houseName"));
	    		}
	    		houses.add(houseData);
	    		
	    		characterName = editions.get(i).character;
	    		rs = st.executeQuery("SELECT idcharacter, characterName FROM proba.`character` WHERE idcharacter = '" + characterName +"'");
	    		if (rs.next()){
	    			characterData = new CharacterData(rs.getString("idcharacter"), rs.getString("characterName"));
	    		}
	    		characters.add(characterData);
	    		
	    		//place = editions.get(i).character;
	    		rs = st.executeQuery("SELECT idplace, numRack, numRackLittle FROM place WHERE idedition = '" + editions.get(i).idedition +"'");
	    		if (rs.next()){
	    			placeData = new PlaceData(rs.getString("idplace"), rs.getString("numRack"), rs.getString("numRackLittle"));
	    		}
	    		places.add(placeData);
	    		
	    		authorName = editions.get(i).author;
	    		rs = st.executeQuery("SELECT idauthor, authorName FROM author WHERE idauthor = '" + authorName +"'");
	    		if (rs.next()){
	    			authorData = new AuthorData(rs.getString("idauthor"), rs.getString("authorName"));
	    		}
	    		authors.add(authorData);
	    		System.out.println(authorData.authorName);
	    	}
	    	
	    	languageList = new LanguageList(languages);
	    	bindingList = new BindingList(bindings);
	    	houseList = new PublishingHouseList(houses);
	    	authorList = new AuthorList(authors);
	    	int i = 0;
	    	
	    	rs = st.executeQuery("SELECT idedition, dateEdition, idlanguage, idbinding, idseries, idhouse, idauthor, idcharacter, nameEdition FROM edition");
	    	while (rs.next()){
	    		if(i<languages.size()){
	    			//data = new EditionData(rs.getString("idedition"), rs.getString("idlanguage"), lanData.getLanguageName() ,rs.getString("idbinding"), binData.nameBinding, rs.getString("idseries"), rs.getString("idhouse"), houseData.nameHouse, rs.getString("idauthor"), authorData.authorName, rs.getString("idcharacter"), "FUCK", rs.getString("img"));
	    			data = new EditionData(rs.getString("idedition"), rs.getString("dateEdition"), rs.getString("idlanguage"), languages.get(i).getLanguageName() ,rs.getString("idbinding"),bindings.get(i).nameBinding , rs.getString("idseries"), rs.getString("idhouse"), houses.get(i).nameHouse, rs.getString("idauthor"), authors.get(i).authorName, rs.getString("idcharacter"), characters.get(i).characterName,rs.getString("nameEdition"), places.get(i).idplace, places.get(i).numRack, places.get(i).numRackLittle );
	    			//data = new EditionData(rs.getString("idedition"), rs.getString("dateEdition"), rs.getString("idlanguage"), languages.get(i).getLanguageName() ,rs.getString("idbinding"),bindings.get(i).nameBinding , rs.getString("idseries"), rs.getString("idhouse"), houses.get(i).nameHouse, rs.getString("idauthor"), authors.get(i).authorName, rs.getString("idcharacter"), characters.get(i).characterName, rs.getString("nameEdition"));
		    		editionsNew.add(data);
		    		//System.out.println(editionsNew.get(i).idedition);
		    		//System.out.println(authors.get(i).authorName);
	    		}
	    		i++;
	    	}
	    	
	    	editionListNew = new EditionList(editionsNew);
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55 in EditionDAO");
	    	throw new DAOException("Ошибка в EditionDAO.");
	    }
		catch (SQLException e) {
	    	System.out.println("66 in EditionDAO");
	    	System.out.println(e.toString());
	    	throw new DAOException("Ошибка в EditionDAO.");
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
		
		return editionListNew;
		
	}
	
}


//Prosto poputka zapisat esche i imena k nomeram
/*languageName = data.language;
rs1 = st.executeQuery("SELECT idlanguage, languageName FROM language WHERE idlanguage = '" + languageName +"'");
if (rs1.next()){
	lanData = new LanguageData(rs.getString("idlanguage"), rs.getString("languageName"));
}
bindingName = data.binding;
rs1 = st.executeQuery("SELECT idbinding, bindingName FROM binding WHERE idbinding = '" + bindingName +"'");
if (rs1.next()){
	binData = new BindingData(rs.getString("idbinding"), rs.getString("bindingName"));
}
houseName = data.publishingHouse;
rs1 = st.executeQuery("SELECT idhouse, houseName FROM publishinghouse WHERE idhouse = '" + houseName +"'");
if (rs1.next()){
	houseData = new PublishingHouseData(rs.getString("idhouse"), rs.getString("houseName"));
}
authorName = data.author;
rs1 = st.executeQuery("SELECT idauthor, authorName FROM author WHERE idauthor = '" + authorName +"'");
if (rs1.next()){
	authorData = new AuthorData(rs.getString("idauthor"), rs.getString("authorName"));
}
/*characterName = data.character;
rs = st.executeQuery("SELECT idcharacter, characterName FROM character WHERE idcharacter = '" + data.character +"'");
if (rs.next()){
	characterData = new CharacterData(rs.getString("idcharacter"), rs.getString("characterName"));
}*/

//data = new EditionData(rs.getString("idedition"), rs.getString("idlanguage"), lanData.getLanguageName() ,rs.getString("idbinding"), binData.nameBinding, rs.getString("idseries"), rs.getString("idhouse"), houseData.nameHouse, rs.getString("idauthor"), authorData.authorName, rs.getString("idcharacter"), "FUCK", rs.getString("img"));




//idLanguage = editionList.getLanguage();

/*rs = st.executeQuery("SELECT languageName FROM language WHERE idlanguage = " + idLanguage + " ");
if(rs.next()){
	languageList = new LanguageData(rs.getString(languageName));
}
editionList = new EditionData(rs.getString(languageString), rs.getInt(binding), rs.getInt(series), rs.getInt(publishingHouse), rs.getInt(author), rs.getInt(character));*/
