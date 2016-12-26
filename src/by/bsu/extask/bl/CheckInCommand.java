package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.CheckInDAO;

public class CheckInCommand implements Command{

	private static String idreaderParam = "idreader";
	private static String loginParam = "login";
	private static String passwordParam = "password";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		String idreader;
		String login;
		String password;
		
		idreader = inData.getRequestParametr(idreaderParam).toString();
		login = inData.getRequestParametr(loginParam).toString();
		password = inData.getRequestParametr(passwordParam).toString();
		
		int result = 0;
		String page = null;
		
		try{
			result = CheckInDAO.checkInReader(idreader, login, password);
			
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
			throw new DataException("DAO Errors in DeleteReaderCommand");
			
		}
		
	}
	
}
