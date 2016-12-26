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

import by.bsu.extask.dao.ShowAllDebtorDAO;

import by.bsu.extask.dao.ReaderListDeleteDAO;

public class LoginCommand implements Command{
	
	private static String loginParam = "login";
	private static String passwordParam = "password";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		
		String login;
		String password;
		
		login = inData.getRequestParametr(loginParam).toString();
		password = inData.getRequestParametr(passwordParam).toString();

		ReaderList readerList;
		ReaderData readerData = null;
		//ReaderList debtor = null;
		EditionList editionList = null;
		String page = null;
		
		DeliveryList deliveryList;
		DeliveryList deliveryListPass;
		DeliveryList deliveryListArrears;
		
		ReaderList readerListDelete;
		
		try {
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			//characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
			
			readerData = LoginDAO.checkUser(login, password);
			
			editionList = EditionDAO.oneEdition();
			
			readerList = ReaderListDAO.readerList();
			
			deliveryList = DeliveryListDAO.deliveryList(login);
			deliveryListPass = DeliveryListPassDAO.deliveryListPass(login);
			deliveryListArrears = YourOverdueBooksDAO. yourOverdueBooks(login);
			
			readerListDelete = ReaderListDeleteDAO.readerListDelete();
			
			//debtor = ShowAllDebtorDAO.readerList();
			
			if (readerData == null){
				page = "/WEB-INF/jsp/false.jsp";
				return page;
			}
			
			inData.setRequestAttribute("languageList", languageList);
			inData.setRequestAttribute("bindingList", bindingList);
			//inData.setRequestAttribute("characterList", characterList);
			inData.setRequestAttribute("publishingHouseList", publishingHouseList);
			
			inData.setSessionAttribute("login", login);
			
			inData.setRequestAttribute("readerData", readerData);
			inData.setRequestAttribute("editionList", editionList);
			inData.setRequestAttribute("readerList", readerList);
			
			inData.setRequestAttribute("deliveryList", deliveryList);
			inData.setRequestAttribute("deliveryListPass", deliveryListPass);
			inData.setRequestAttribute("deliveryListArrears", deliveryListArrears);
			
			inData.setRequestAttribute("readerListDelete", readerListDelete);
			
			//inData.setRequestAttribute("debtor", debtor);
			
			String add = "true";
			inData.setSessionAttribute("add", add);
			
			String delete = "true";
			inData.setSessionAttribute("delete", delete);
			
			switch(readerData.status){
			case "user":
				page = "/WEB-INF/jsp/cabinet_reader.jsp";//��� ���� edition.jsp
				break;
			case "admin":
				page = "/WEB-INF/jsp/admin_page.jsp";
				break;
			}
			/*if(readerData.status == "user"){
				page = "/WEB-INF/jsp/cabinet_reader.jsp";
			}
			if(readerData.status == "admin"){
				page = "/WEB-INF/jsp/admin_page.jsp";
			}*/
		} catch (DAOException e) {
			throw new DataException("Ошибка в LoginCommand.");
		}
				
		return page;
	}
	
}
