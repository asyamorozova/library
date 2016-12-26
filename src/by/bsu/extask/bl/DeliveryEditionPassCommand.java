package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.AddEditionToReaderDAO;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeliveryEditionPassDAO;
import by.bsu.extask.dao.DeliveryListDAO;
import by.bsu.extask.dao.DeliveryListPassDAO;
import by.bsu.extask.dao.YourOverdueBooksDAO;
import by.bsu.extask.to.DeliveryList;


public class DeliveryEditionPassCommand implements Command{

private static String idreaderParam = "idreader";
private static String ideditionParam = "idedition";

private static String loginParam = "login";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		//int number;
		String idreader;
		String idedition;
		
		String login;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		idreader = inData.getRequestParametr(idreaderParam).toString();
		idedition = inData.getRequestParametr(ideditionParam).toString();
		
		login = inData.getRequestParametr(loginParam).toString();
		
		int result = 0;
		String page = null;
		
		DeliveryList deliveryList;
		DeliveryList deliveryListPass;
		DeliveryList deliveryListArrears;
		
		try{
			result = DeliveryEditionPassDAO.deliveryEditionPass(idreader, idedition);
			
			deliveryList = DeliveryListDAO.deliveryList(login);
			deliveryListPass = DeliveryListPassDAO.deliveryListPass(login);
			deliveryListArrears = YourOverdueBooksDAO. yourOverdueBooks(login);
			
			inData.setRequestAttribute("deliveryList", deliveryList);
			inData.setRequestAttribute("deliveryListPass", deliveryListPass);
			inData.setRequestAttribute("deliveryListArrears", deliveryListArrears);
			
			if(result != 0){
				page = "/WEB-INF/jsp/info_about_edition_reader.jsp";
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
