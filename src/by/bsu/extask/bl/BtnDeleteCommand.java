package by.bsu.extask.bl;

import by.bsu.extask.controller.InDataWrapper;
import by.bsu.extask.dao.DAOException;
import by.bsu.extask.dao.DeleteReaderDAO;

public class BtnDeleteCommand implements Command{

	private static String idreaderParam = "idreader";
	
	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		//int number;
		String idreader;
		
		//number = inData.getRequestParametr(numberParam).toString();//���������� ��� ��� ����� �����
		idreader = inData.getRequestParametr(idreaderParam).toString();
		
		String page = null;
		
		/*int result = 0;
		String page = null;
		
		try{
			
			result = DeleteReaderDAO.DeleteReader(idreader);
			
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
			
		}*/
		page = "/WEB-INF/jsp/admin_page.jsp";
		return page;
	}
	
}
