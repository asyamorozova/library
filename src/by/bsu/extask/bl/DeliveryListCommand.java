package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeliveryListDAO;
import by.bsu.extask.dao.DeliveryListPassDAO;
import by.bsu.extask.to.DeliveryData;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.dao.YourOverdueBooksDAO;

public class DeliveryListCommand implements Command{

	private static String loginParam = "login";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		//int number;
		String login;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		login = inData.getRequestParametr(loginParam).toString();
		
		int result = 0;
		String page = null;
		DeliveryList deliveryList;
		DeliveryList deliveryListPass;
		DeliveryList deliveryListArrears;
		ReaderData reader;
		
		try{
			
			//result = ReaderDAO.oneReader(number, name, surname, patronymic, adress, phone);
			deliveryList = DeliveryListDAO.deliveryList(login);
			deliveryListPass = DeliveryListPassDAO.deliveryListPass(login);
			deliveryListArrears = YourOverdueBooksDAO. yourOverdueBooks(login);
			
			/*if(result != 0){
				page = "/WEB-INF/jsp/true.jsp";
				return page;
			}
			else{
				page = "/WEB-INF/jsp/false.jsp";
				return page;
			}*/
			if (deliveryList == null){
				throw new DataException("������ ������ � ���������� ������. ��� ����.");
			}
			
			inData.setRequestAttribute("deliveryList", deliveryList);
			inData.setRequestAttribute("deliveryListPass", deliveryListPass);
			inData.setRequestAttribute("deliveryListArrears", deliveryListArrears);
	
			String example = "true";
			inData.setSessionAttribute("example", example);
		}
		catch(DAOException e) {
			throw new DataException("Вот тут ошибка in DeliveryListCommand");
			
		}
		
		//return "/WEB-INF/jsp/your_books.jsp";
		return "/WEB-INF/jsp/info_about_edition_reader.jsp";
		
	}
	
}
