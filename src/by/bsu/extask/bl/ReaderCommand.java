package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.dao.ReaderDAO;
import by.bsu.extask.dao.ReaderListDAO;
import by.bsu.extask.to.ReaderData;


import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;
import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;

import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.dao.LoginDAO;
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

public class ReaderCommand implements Command{
	
	//private static int numberParam = 0;
	private static String nameParam = "name";
	private static String surnameParam = "surname";
	private static String patronymicParam = "patronymic";
	private static String adressParam = "adress";
	private static String phoneParam = "phone";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		String add = "false";
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		
		ReaderList readerList;
		ReaderData readerData = null;
		
		//int number;
		String name;
		String surname;
		String patronymic;
		String adress;
		String phone;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		name = inData.getRequestParametr(nameParam).toString();
		surname = inData.getRequestParametr(surnameParam).toString();
		patronymic = inData.getRequestParametr(patronymicParam).toString();
		adress = inData.getRequestParametr(adressParam).toString();
		phone = inData.getRequestParametr(phoneParam).toString();
		
		int result = 0;
		String page = null;
		
		try{
			
			//result = ReaderDAO.oneReader(number, name, surname, patronymic, adress, phone);
			result = ReaderDAO.oneReader(name, surname, patronymic, adress, phone);
			
			languageList = LanguageListDAO.languageList();
			bindingList = BindingListDAO.bindingList();
			//characterList = CharacterListDAO.characterList();
			publishingHouseList = PublishingHouseListDAO.publishingHouseList();
			
			readerList = ReaderListDAO.readerList();
			
			inData.setRequestAttribute("readerData", readerData);
			inData.setRequestAttribute("readerList", readerList);
			
			add = "true";
			inData.setSessionAttribute("add", add);
			
			if(result != 0){
				add = "false";
				inData.setSessionAttribute("add", add);
				page = "/WEB-INF/jsp/admin_page.jsp";
				return page;
			}
			else{
				add = "true";
				inData.setSessionAttribute("add", add);
				page = "/WEB-INF/jsp/admin_page.jsp";
				return page;
			}
		}
		catch(DAOException e) {
			throw new DataException("Ошибка в ReaderCommand.");
			
		}
		
	}
	
}
