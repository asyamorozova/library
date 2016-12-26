package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.BindingListDAO;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeliveryListDAO;
import by.bsu.extask.dao.DeliveryListPassDAO;
import by.bsu.extask.dao.LanguageListDAO;
import by.bsu.extask.dao.PublishingHouseListDAO;
import by.bsu.extask.dao.SearchEditionDAO;
import by.bsu.extask.dao.InfoAboutEditionDAO;
import by.bsu.extask.to.DeliveryData;
import by.bsu.extask.to.DeliveryList;
import by.bsu.extask.to.EditionData;
import by.bsu.extask.to.ReaderData;

public class InfoAboutEditionCommand implements Command{

	private static String ideditionParam = "idedition";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
	
		String idedition;
		
		idedition = inData.getRequestParametr(ideditionParam).toString();
		
		EditionData edition;
		
		try {
			edition = InfoAboutEditionDAO.infoAboutEdition(idedition);
		}
		catch (DAOException e) {
			throw new DataException("Ошибка в InfoAboutEditionCommand.");
		}
		
		/*if (readerList == null){
			throw new DataException("������ ������ � ���������� ������. ��� �������������.");
		}*/
		
		inData.setRequestAttribute("infoAboutEdition", edition);
		
		return "/WEB-INF/jsp/info_about_edition.jsp";
	}
		
	}
	
