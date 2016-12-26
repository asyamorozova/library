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
import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;
import by.bsu.extask.to.PlaceData;
import by.bsu.extask.to.PlaceList;

public class AddEditionDAO {
	
public static int oneEdition(String dateEdition, String idlanguage, String idbinding, /*String idseries,*/ String idhouse, String idauthor, String idcharacter, String nameEdition) throws DAOException{
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		EditionData editionData = null;
		EditionData data = null;
		EditionList editionList = null;
		
		PlaceData placeData = null;
		PlaceList placeList = null;
		int placeMax;
		String placeMaxS;
		int numRack;
		String numRackS;
		int numRackLittle;
		String numRackLittleS;
		
		int max;
		String maxS;
		//int newIdhouse = max+1;
		int sizeList = 0;
		int result = 0;
		
		//EditionData readerList = null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proba?useUnicode=true&characterEncoding=utf8", "root", "");
	    	st = con.createStatement();
	    	
	    	/*int dateEdition1 = new Integer(dateEdition);
	    	int idlanguage1 = new Integer(idlanguage);
	    	int idbinding1 = new Integer(idbinding);
	    	int idseries1 = new Integer(idseries);
	    	int idhouse1 = new Integer(idhouse);
	    	int idauthor1 = new Integer(idauthor);
	    	int idcharacter1 = new Integer(idcharacter);*/
	    	
	    	//result = st.executeUpdate("INSERT INTO reader ([idreader], [surname], [name], [patronymic], [adress], [phone]) VALUES ("+ 1 + ",'" + surname + "','" + name +"','" + patronymic + "','" + adress + "','" + phone + "' ) ");
	    	
	    	rs = st.executeQuery("SELECT idedition FROM edition");
	    	List<EditionData> editions = new ArrayList<EditionData>();

	    	while (rs.next()){
	    		data = new EditionData(rs.getString("idedition"));
	    		editions.add(data);
	    	}
	    	editionList = new EditionList(editions);
	    	data = editions.get(editions.size()-1);
	    	maxS = data.getIdedition();
	    	max = Integer.parseInt(maxS);
	    	
	    	rs = st.executeQuery("SELECT idplace, numRack, numRackLittle FROM place");
	    	List<PlaceData> places = new ArrayList<PlaceData>();
	    	while (rs.next()){
	    		placeData = new PlaceData(rs.getString("idplace"),rs.getString("numRack"),rs.getString("numRackLittle"));
	    		places.add(placeData);
	    	}
	    	placeList = new PlaceList(places);
	    	placeData = places.get(places.size()-1);
	    	placeMaxS = placeData.idplace;
	    	placeMax = Integer.parseInt(placeMaxS);
	    	placeData = places.get(places.size()-1);
	    	numRackS = placeData.numRack;
	    	numRack = Integer.parseInt(numRackS);
	    	placeData = places.get(places.size()-1);
	    	numRackLittleS = placeData.numRackLittle;
	    	numRackLittle = Integer.parseInt(numRackLittleS);
	    	
	    	
	    	result = st.executeUpdate("INSERT INTO edition VALUES ("+ (max + 1) + ",'" + dateEdition + "','" + idlanguage +"','" + idbinding + "'," + 0 + ",'" + idhouse + "','" + idauthor + "','" + idcharacter + "','" + null + "','" + nameEdition + "' ) ");

	    	
	    	result = st.executeUpdate("INSERT INTO place VALUES ("+ (placeMax + 1) + ",'" + (numRack + 1) + "','" + (numRackLittle + 1) +"','" + (max + 1) + "' ) ");
	    	//result = st.executeUpdate("INSERT INTO edition VALUES ("+ 5 + "," + dateEdition1 + "," + idlanguage1 +"," + idbinding1 + "," + idseries1 + "," + idhouse1 + "," + idauthor1 + "," + idcharacter1 + ",'" + img + "' ) ");
	    	
	    	//result = st.executeUpdate("INSERT INTO edition VALUES ("+ 5 + "," + 2000 + "," + 1 +"," + 1 + "," + 2 + "," + 2 + "," + 1 + "," + 2 + ", 'img' ) ");
	    	
	    }
		catch (ClassNotFoundException e) {
	    	System.out.println("55");
	    	throw new DAOException("Ошибка в AddEditionDAO.");
	    }
		catch (SQLException e) {
	    	//System.out.println("66");
	    	System.out.println(e.toString());
	    	throw new DAOException("������ ������ � ���������� ������.");
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
