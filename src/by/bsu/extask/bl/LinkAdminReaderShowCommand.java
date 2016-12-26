package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeliveryListDAO;
import by.bsu.extask.dao.DeliveryListPassDAO;
import by.bsu.extask.dao.LoginDAO;
import by.bsu.extask.dao.ReaderListDAO;
import by.bsu.extask.dao.YourOverdueBooksDAO;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;
import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;

import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.to.LanguageData;
import by.bsu.extask.to.LanguageList;

import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.to.BindingData;
import by.bsu.extask.to.BindingList;

import by.bsu.extask.dao.CharacterListDAO;
import by.bsu.extask.to.CharacterData;
import by.bsu.extask.to.CharacterList;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;

public class LinkAdminReaderShowCommand implements Command{

	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		
		ReaderList readerList;
		ReaderData readerData = null;
		EditionList editionList = null;
		
		try {
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			//characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
			
			/*readerData = LoginDAO.checkUser(login, password);*/
			
			readerList = ReaderListDAO.readerList();
			
			editionList = EditionDAO.oneEdition();
				
		}
		 catch (DAOException e) {
				System.out.println(e.toString());
				throw new DataException("Ошибка в LinkAdminReaderShowCommand.");
			}
		
		inData.setRequestAttribute("readerData", readerData);
		inData.setRequestAttribute("editionList", editionList);
		inData.setRequestAttribute("readerList", readerList);
		
		inData.setRequestAttribute("languageList", languageList);
		inData.setRequestAttribute("bindingList", bindingList);
		//inData.setRequestAttribute("characterList", characterList);
		inData.setRequestAttribute("publishingHouseList", publishingHouseList);
		
		inData.setRequestAttribute("editionList", editionList);
		
		return "/WEB-INF/jsp/admin_page.jsp";
	}
}
