package by.bsu.extask.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import by.bsu.extask.bl.Command;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/mmm")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private RequestHelper requestHelper = RequestHelper.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
    	super();
        // TODO Auto-generated constructor stub
    }
    
    //Vot eto dlya kartinki fig znaet budet li on rabotat
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    response.setContentType("image/jpg");
    	    OutputStream out = response.getOutputStream();
    	    try {
    	    URL imageURL = Controller.class.getResource("space_header.jpg");
    	    BufferedImage bi = ImageIO.read(imageURL);
    	    ImageIO.setUseCache(false);
    	    ImageIO.write(bi, "jpg", out);
    	    } finally {
    	    out.close();
    	    }
    	  }*/
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=windows-1251");
		response.setContentType("text/html;charset=UTF-8");
		/*request.setCharacterEncoding("UTF-8");*/
		
		String action = request.getParameter("command");
		Command command = requestHelper.getCommand(action);
		InDataWrapper inData = new InDataWrapper(request);
		
		String page;
		try {
			page = command.execute(inData);		
			
		} catch (Exception e) {
			page = "/WEB-INF/jsp/error_page.jsp";
			System.out.println(e.toString());
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
		dispatch.forward(request, response);
	}

}
