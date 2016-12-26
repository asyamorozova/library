package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeliveryListDAO;
import by.bsu.extask.dao.DeliveryListPassDAO;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.dao.LoginDAO;
import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.dao.ReaderDAO;
import by.bsu.extask.dao.ReaderListDAO;
import by.bsu.extask.dao.ReaderListDeleteDAO;
import by.bsu.extask.dao.YourOverdueBooksDAO;
import by.bsu.extask.dao.AddAuthorDAO;
import by.bsu.extask.dao.AuthorListDAO;
import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.dao.CharacterListDAO;
import by.bsu.extask.to.AuthorData;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.BindingList;
import by.bsu.extask.to.CharacterList;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.to.EditionList;
import by.bsu.extask.to.LanguageList;
import by.bsu.extask.to.PublishingHouseList;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;

import by.bsu.extask.dao.ReaderReestablishDAO;

public class ReaderReestablishCommand implements Command{

	private static String idreaderParam = "idreader";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		System.out.println("WTF");
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		
		ReaderList readerList;
		ReaderData readerData = null;
		
		String idreader;
		
		System.out.println("WTF");
		idreader = inData.getRequestParametr(idreaderParam).toString();
		
		int result = 0;
		String page = null;
		
		try{
			
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			//characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
			
			readerList = ReaderListDAO.readerList();
			
			inData.setRequestAttribute("readerData", readerData);
			inData.setRequestAttribute("readerList", readerList);
			
			result = ReaderReestablishDAO.reestablishReader(idreader);
			
			if(result != 0){
				page = "/WEB-INF/jsp/admin_page.jsp";
				return page;
			}
			else{
				page = "/WEB-INF/jsp/false.jsp";
				return page;
			}
		}
		catch(DAOException e) {
			throw new DataException("Ошибка в ReaderReestablishCommand.");
			
		}
		
	}
	
}
