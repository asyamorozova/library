package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.AddEditionToReaderDAO;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeleteReaderDAO;
import by.bsu.extask.dao.ReaderListDAO;
import by.bsu.extask.to.ReaderData;
import by.bsu.extask.to.ReaderList;

public class DeleteReaderCommand implements Command{

	private static String idreaderParam = "idreader";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		//int number;
		String idreader;
		
		ReaderList readerList;
		ReaderData readerData = null;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		idreader = inData.getRequestParametr(idreaderParam).toString();
		
		int result = 0;
		String page = null;
		
		try{
			result = DeleteReaderDAO.DeleteReader(idreader);
			
			readerList = ReaderListDAO.readerList();
			
			inData.setRequestAttribute("readerData", readerData);
			inData.setRequestAttribute("readerList", readerList);
			
			String delete = "true";
			inData.setSessionAttribute("delete", delete);
			
			if(result != 0){
				page = "/WEB-INF/jsp/admin_page.jsp";
				return page;
			}
			else{
				delete = "false";
				inData.setSessionAttribute("delete", delete);
				page = "/WEB-INF/jsp/admin_page.jsp";
				return page;
			}
					}
		catch(DAOException e) {
			throw new DataException("DAO Errors in DeleteReaderCommand");
			
		}
		
	}
	
}
