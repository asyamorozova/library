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

import by.bsu.extask.dao.SearchReaderDAO;

import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.to.LanguageData;
import by.bsu.extask.to.LanguageList;

import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.to.BindingData;
import by.bsu.extask.to.BindingList;

import by.bsu.extask.dao.CharacterListDAO;
import by.bsu.extask.to.CharacterData;
import by.bsu.extask.to.CharacterList;

import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.to.PublishingHouseData;
import by.bsu.extask.to.PublishingHouseList;

public class SearchReaderCommand implements Command{

	private static String idreaderParam = "idreader";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		
		String idreader;
		idreader = inData.getRequestParametr(idreaderParam).toString();
		
		//ReaderList searchReaderList;
		ReaderData searchReaderList;
		
		try {
			System.out.println("WTF");
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			//characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
			
			searchReaderList = SearchReaderDAO.searchReader(idreader);
		}
		catch (DAOException e) {
			throw new DataException("Ошибка в SearchReaderCommand.");
		}
		
		/*if (readerList == null){
			throw new DataException("������ ������ � ���������� ������. ��� �������������.");
		}*/
		
		inData.setRequestAttribute("languageList", languageList);
		inData.setRequestAttribute("bindingList", bindingList);
		//inData.setRequestAttribute("characterList", characterList);
		inData.setRequestAttribute("publishingHouseList", publishingHouseList);
		
		inData.setRequestAttribute("searchReaderList", searchReaderList);
		
		if(searchReaderList == null){
			return "/WEB-INF/jsp/no_search_reader.jsp";
		}
		else{
			return "/WEB-INF/jsp/search_reader.jsp";
		}
	}
	
}
