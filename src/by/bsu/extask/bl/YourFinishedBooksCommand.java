package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeliveryListDAO;
import by.bsu.extask.dao.YourFinishedBooksDAO;
import by.bsu.extask.to.DeliveryData;
import by.bsu.extask.to.DeliveryList;

public class YourFinishedBooksCommand implements Command{

private static String loginParam = "login";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		//int number;
		String login;
		
		//number = inData.getRequestParametr(numberParam).toString();//посмотреть что для числа нужно
		login = inData.getRequestParametr(loginParam).toString();
		
		int result = 0;
		String page = null;
		DeliveryList yourFinishedBooks;
		
		try{
			
			//result = ReaderDAO.oneReader(number, name, surname, patronymic, adress, phone);
			yourFinishedBooks = YourFinishedBooksDAO.yourFinishedBooks(login);
			
			/*if(result != 0){
				page = "/WEB-INF/jsp/true.jsp";
				return page;
			}
			else{
				page = "/WEB-INF/jsp/false.jsp";
				return page;
			}*/
			if (yourFinishedBooks == null){
				throw new DataException("Ошибка работы с источником данных. Нет книг.");
			}
			
			inData.setRequestAttribute("yourFinishedBooks", yourFinishedBooks);
	
		}
		catch(DAOException e) {
			throw new DataException("Ошибка работы с источником данных in YourFinishedBooksCommand");
			
		}
		
		return "/WEB-INF/jsp/your_finished_books.jsp";
		
	}
	
}
