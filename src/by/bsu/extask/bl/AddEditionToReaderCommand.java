package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.AddEditionToReaderDAO;

public class AddEditionToReaderCommand  implements Command{

	//session.getAttribute("login")
	
	private static String loginParam = "login";
	private static String ideditionParam = "idedition";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		//int number;
		String login;
		String idedition;
		
		//number = inData.getRequestParametr(numberParam).toString();//посмотреть что для числа нужно
		login = inData.getRequestParametr(loginParam).toString();
		idedition = inData.getRequestParametr(ideditionParam).toString();
		
		int result = 0;
		String page = null;
		
		try{
			
			//result = ReaderDAO.oneReader(number, name, surname, patronymic, adress, phone);
			result = AddEditionToReaderDAO.addEditToReader(login,idedition);
			
			if(result != 0){
				page = "/WEB-INF/jsp/true.jsp";
				return page;
			}
			else{
				page = "/WEB-INF/jsp/false.jsp";
				return page;
			}
		}
		catch(DAOException e) {
			throw new DataException("Ошибка работы с источником данных in AddEditionToReaderCommand");
			
		}
		
	}
	
}
