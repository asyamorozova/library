package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.ReaderListDAO;
import by.bsu.extask.to.ReaderList;

public class LinkAddNewReaderCommand implements Command{

	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		return "/WEB-INF/jsp/add_new_reader.jsp";
		
	}
	
}
