package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.EditionDAO;
import by.bsu.extask.dao.LoginDAO;
import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.EditionList;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.dao.ReaderDAO;

public class EditionCommand implements Command{

	/*private static String languageNameParam = "languageName";
	private static String languageStringParam = "languageString";
	
	//private static int languageParam;
	private static String languageParam = "language";
	
	private static String bindingParam = "binding";
	private static String seriesParam = "series";
	private static String publishingHouseParam = "publishingHouse";
	private static String authorParam = "author";
	private static String characterParam = "character";*/
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		/*String languageName;
		String languageString;
		String language;
		String binding;
		String series;
		String publishingHouse;
		String author;
		String character;
		
		languageName = inData.getRequestParametr(languageNameParam).toString();
		languageString = inData.getRequestParametr(languageStringParam).toString();
		language = inData.getRequestParametr(languageParam).toString();
		binding = inData.getRequestParametr(bindingParam).toString();
		series = inData.getRequestParametr(seriesParam).toString();
		publishingHouse = inData.getRequestParametr(publishingHouseParam).toString();
		author = inData.getRequestParametr(authorParam).toString();
		character = inData.getRequestParametr(characterParam).toString();
		
		EditionData editionData = null;
		String page = null;*/
		
		EditionList editionList = null;
		//ReaderData readerData = null;
		
		try {
			/*editionData = EditionDAO.oneEdition(language, binding, series, publishingHouse, author, character, languageName, languageString);
			
			if (editionData == null){
				throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
			}
			
			inData.setRequestAttribute("editionData", editionData);
			
			return page = "/WEB-INF/jsp/edition.jsp";*/
			
			//readerData = ReaderDAO.oneReader(name, surname, patronymic, adress, phone);
			editionList = EditionDAO.oneEdition();
				
		} catch (DAOException e) {
			System.out.println(e.toString());
			throw new DataException("Ошибка работы с источником данных в EditionCommand.");
		}
		
		if (editionList == null){
			throw new DataException("Ошибка работы с источником данных. Нет изданий.");
		}
		
		
		inData.setSessionAttribute("login", "OK");
		inData.setRequestAttribute("editionList", editionList);
		//inData.setRequestAttribute("readerData", readerData);
		
		return "/WEB-INF/jsp/edition.jsp";
		
	}
	
}
