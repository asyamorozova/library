package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.LoginDAO;
import by.bsu.extask.dao.ReaderListDAO;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;
import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;

import by.bsu.extask.dao.SearchEditionDAO;

import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.to.LanguageData;
import by.bsu.extask.to.LanguageList;
import by.bsu.extask.dao.AuthorListDAO;
import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.BindingData;
import by.bsu.extask.to.BindingList;

import by.bsu.extask.dao.CharacterListDAO;
import by.bsu.extask.to.CharacterData;
import by.bsu.extask.to.CharacterList;

import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;

public class SearchEditionCommand implements Command{
	
private static String ideditionParam = "idedition";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		AuthorList authorList;
		
		String idedition;
		idedition = inData.getRequestParametr(ideditionParam).toString();
		
		//ReaderList searchReaderList;
		EditionData searchEditionList;
		
		try {
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			//characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
			characterList = CharacterListDAO.characterList();
			authorList = AuthorListDAO.authorList();
			
			
			searchEditionList = SearchEditionDAO.searchEdition(idedition);
		}
		catch (DAOException e) {
			throw new DataException("Ошибка в SearchEditionCommand.");
		}
		
		
		inData.setRequestAttribute("languageList", languageList);
		inData.setRequestAttribute("bindingList", bindingList);
		//inData.setRequestAttribute("characterList", characterList);
		inData.setRequestAttribute("publishingHouseList", publishingHouseList);
		
		inData.setRequestAttribute("characterList", characterList);
		inData.setRequestAttribute("authorList", authorList);
		
		inData.setRequestAttribute("searchEditionList", searchEditionList);
		
		if(searchEditionList == null){
			return "/WEB-INF/jsp/no_search_edition.jsp";
		}
		else{
			return "/WEB-INF/jsp/search_edition.jsp";
		}
	}
	
}
