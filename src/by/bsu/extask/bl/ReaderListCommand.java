package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.ReaderListDAO;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;

public class ReaderListCommand implements Command{

	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		ReaderList readerList;
		try {
			readerList = ReaderListDAO.readerList();
		}
		catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных в ReaderListCommand");
		}
		
		if (readerList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("readerList", readerList);
		
		return "/WEB-INF/jsp/all_reader.jsp";
		
	}
	
}
