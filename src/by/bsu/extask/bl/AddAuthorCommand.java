package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.dao.AddAuthorDAO;
import by.bsu.extask.dao.AuthorListDAO;
import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.dao.CharacterListDAO;
import by.bsu.extask.to.AuthorData;
import by.bsu.extask.to.AuthorList;
import by.bsu.extask.to.BindingList;
import by.bsu.extask.to.CharacterList;
import by.bsu.extask.to.EditionList;
import by.bsu.extask.to.LanguageList;
import by.bsu.extask.to.PublishingHouseList;

public class AddAuthorCommand implements Command{

	private static String authorNameParam = "authorName";
	private static String countryParam = "country";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		LanguageList languageList;
		BindingList bindingList;
		CharacterList characterList;
		PublishingHouseList publishingHouseList;
		AuthorList authorList;
		EditionList editionList = null;
		
		//int number;
		String authorName;
		String country;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		
		authorName = inData.getRequestParametr(authorNameParam).toString();
		country = inData.getRequestParametr(countryParam).toString();
		
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
			result = AddAuthorDAO.addAuthor(authorName, country);
			
			inData.setRequestAttribute("languageList", languageList);
			inData.setRequestAttribute("bindingList", bindingList);
			inData.setRequestAttribute("characterList", characterList);
			inData.setRequestAttribute("publishingHouseList", publishingHouseList);
			inData.setRequestAttribute("authorList", authorList);
			
			inData.setRequestAttribute("editionList", editionList);
			
			String add_author = "true";
			inData.setSessionAttribute("add_author", add_author);
			
			String no_add_author = "true";
			inData.setSessionAttribute("no_add_author", no_add_author);
			
			if(result != 0){
				add_author = "false";
				inData.setSessionAttribute("add_author", add_author);
				page = "/WEB-INF/jsp/edition.jsp";
				return page;
			}
			else{
				no_add_author = "false";
				inData.setSessionAttribute("no_add_author", no_add_author);
				page = "/WEB-INF/jsp/edition.jsp";
				return page;
			}
		}
		catch(DAOException e) {
			System.out.println(e.toString());
			throw new DataException("Ошибка в AddAuthorCommand.");
			
		}
		
	}
	
}
