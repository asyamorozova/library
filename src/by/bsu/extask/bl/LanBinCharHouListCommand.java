package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;

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

public class LanBinCharHouListCommand implements Command{

	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		try {
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			//characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
		}
		catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных в LanBinCharHouListCommand");
		}
		
		if (languageList == null){
			throw new DataException("Ошибка работы с источником данных. Нет языков.");
		}
		
		if (bindingList == null){
			throw new DataException("Ошибка работы с источником данных. Нет переплетов.");
		}
		
		/*if (characterList == null){
			throw new DataException("Ошибка работы с источником данных. Нет переплетов.");
		}*/
		
		if (publishingHouseList == null){
			throw new DataException("Ошибка работы с источником данных. Нет переплетов.");
		}
		
		inData.setRequestAttribute("languageList", languageList);
		inData.setRequestAttribute("bindingList", bindingList);
		//inData.setRequestAttribute("characterList", characterList);
		inData.setRequestAttribute("publishingHouseList", publishingHouseList);
		
		return "/WEB-INF/jsp/add_edition.jsp";
		
	}
	
}
