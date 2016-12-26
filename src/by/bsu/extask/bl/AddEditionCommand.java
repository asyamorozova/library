package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.dao.AddEditionDAO;
import by.bsu.extask.dao.AuthorListDAO;
import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.dao.CharacterListDAO;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.BindingList;
import by.bsu.extask.to.CharacterList;
import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;
import by.bsu.extask.to.LanguageList;
import by.bsu.extask.to.PublishingHouseList;

public class AddEditionCommand implements Command{

	private static String dateEditionParam = "dateEdition";
	private static String idlanguageParam = "idlanguage";
	private static String idbindingParam = "idbinding";
	//private static String idseriesParam = "idseries";
	private static String idhouseParam = "idhouse";
	private static String idauthorParam = "idauthor";
	private static String idcharacterParam = "idcharacter";
	private static String nameEditionParam = "nameEdition";
	//private static String imgParam = "img";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		//int number;
		String dateEdition;
		String idlanguage;
		String idbinding;
		String idseries;
		String idhouse;
		String idauthor;
		String idcharacter;
		String img;
		String nameEdition;
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		AuthorList authorList;
		EditionList editionList = null;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		
		dateEdition = inData.getRequestParametr(dateEditionParam).toString();
		idlanguage = inData.getRequestParametr(idlanguageParam).toString();
		idbinding = inData.getRequestParametr(idbindingParam).toString();
		//idseries = inData.getRequestParametr(idseriesParam).toString();
		idhouse = inData.getRequestParametr(idhouseParam).toString();
		idauthor = inData.getRequestParametr(idauthorParam).toString();
		idcharacter = inData.getRequestParametr(idcharacterParam).toString();
		nameEdition = inData.getRequestParametr(nameEditionParam).toString();
		//img = inData.getRequestParametr(imgParam).toString();
		
		int result = 0;
		String page = null;
		
		try{
			
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
			authorList = AuthorListDAO.authorList();
			
			editionList = EditionDAO.oneEdition();
			
			//result = ReaderDAO.oneReader(number, name, surname, patronymic, adress, phone);
			result = AddEditionDAO.oneEdition(dateEdition, idlanguage, idbinding, /*idseries,*/ idhouse, idauthor, idcharacter, nameEdition/*, img*/);
			
			String add_new_edition = "true";
			inData.setSessionAttribute("add_new_edition", add_new_edition);
			
			inData.setRequestAttribute("languageList", languageList);
			inData.setRequestAttribute("bindingList", bindingList);
			inData.setRequestAttribute("characterList", characterList);
			inData.setRequestAttribute("publishingHouseList", publishingHouseList);
			inData.setRequestAttribute("authorList", authorList);
			
			inData.setRequestAttribute("editionList", editionList);
			
			if(result != 0){
				add_new_edition = "false";
				inData.setSessionAttribute("add_new_edition", add_new_edition);
				page = "/WEB-INF/jsp/edition.jsp";
				return page;
			}
			else{
				page = "/WEB-INF/jsp/false.jsp";
				return page;
			}
		}
		catch(DAOException e) {
			throw new DataException("������ ������ � ���������� ������.");
			
		}
		
	}
	
}
