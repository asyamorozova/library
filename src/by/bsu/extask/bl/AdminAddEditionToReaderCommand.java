package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.AddEditionToReaderDAO;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeleteReaderDAO;
import by.bsu.extask.dao.DeliveryListDAO;
import by.bsu.extask.dao.DeliveryListPassDAO;
import by.bsu.extask.dao.YourOverdueBooksDAO;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.dao.AdminAddEditionToReaderDAO;

public class AdminAddEditionToReaderCommand implements Command{

private static String loginParam = "login";
private static String ideditionParam = "idedition";
private static String timeReturnParam = "timeReturn";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		String example = "false";
		
		//int number;
		String login;
		String idedition;
		String timeReturn;
		
		DeliveryList deliveryList;
		DeliveryList deliveryListPass;
		DeliveryList deliveryListArrears;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		login = inData.getRequestParametr(loginParam).toString();
		idedition = inData.getRequestParametr(ideditionParam).toString();
		timeReturn = inData.getRequestParametr(timeReturnParam).toString();
		
		int result = 0;
		String page = null;
		
		try{
			result = AdminAddEditionToReaderDAO.adminAddEditToReader(login, idedition, timeReturn);
			
			deliveryList = DeliveryListDAO.deliveryList(login);
			deliveryListPass = DeliveryListPassDAO.deliveryListPass(login);
			deliveryListArrears = YourOverdueBooksDAO.yourOverdueBooks(login);
			
			
			inData.setRequestAttribute("deliveryList", deliveryList);
			inData.setRequestAttribute("deliveryListPass", deliveryListPass);
			inData.setRequestAttribute("deliveryListArrears", deliveryListArrears);
			
			example = "true";
			inData.setSessionAttribute("example", example);
			System.out.println(example);
			
			if(result != 0){
				example = "true";
				inData.setSessionAttribute("example", example);
				page = "/WEB-INF/jsp/info_about_edition_reader.jsp";
				System.out.println(example);
				return page;
			}
			else{
				example = "false";
				inData.setSessionAttribute("example", example);
				//page = "/WEB-INF/jsp/false.jsp";
				page = "/WEB-INF/jsp/info_about_edition_reader.jsp";
				System.out.println(example);
				return page;
			}
					}
		catch(DAOException e) {
			throw new DataException("DAO Errors in AdminAddEditionTo ReaderCommand");
			
		}
		
	}
	
}
