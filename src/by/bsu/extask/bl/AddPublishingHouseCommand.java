package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.dao.AddPublishingHouseDAO;
import by.bsu.extask.dao.AuthorListDAO;
import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.dao.CharacterListDAO;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.BindingList;
import by.bsu.extask.to.CharacterList;
import by.bsu.extask.to.EditionList;
import by.bsu.extask.to.LanguageList;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;

public class AddPublishingHouseCommand implements Command{

	private static String houseNameParam = "houseName";
	private static String cityParam = "city";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		AuthorList authorList;
		EditionList editionList = null;
		
		//int number;
		String houseName;
		String city;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		
		houseName = inData.getRequestParametr(houseNameParam).toString();
		city = inData.getRequestParametr(cityParam).toString();
		
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
			result = AddPublishingHouseDAO.oneEdition(houseName, city);
			
			inData.setRequestAttribute("languageList", languageList);
			inData.setRequestAttribute("bindingList", bindingList);
			inData.setRequestAttribute("characterList", characterList);
			inData.setRequestAttribute("publishingHouseList", publishingHouseList);
			inData.setRequestAttribute("authorList", authorList);
			
			inData.setRequestAttribute("editionList", editionList);
			
			String add_house = "true";
			inData.setSessionAttribute("add_house", add_house);
			
			String no_add_house = "true";
			inData.setSessionAttribute("no_add_house", no_add_house);
			
			if(result != 0){
				add_house = "false";
				inData.setSessionAttribute("add_house", add_house);
				page = "/WEB-INF/jsp/edition.jsp";
				return page;
			}
			else{
				no_add_house = "false";
				inData.setSessionAttribute("no_add_house", no_add_house);
				page = "/WEB-INF/jsp/edition.jsp";
				return page;
			}
		}
		catch(DAOException e) {
			throw new DataException("Ошибка в AddPublishingHouseCommand.");
			
		}
		
	}
	
}
