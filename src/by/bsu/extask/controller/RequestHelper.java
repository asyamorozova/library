package by.bsu.extask.controller;

import java.util.HashMap;

import by.bsu.extask.bl.Command;
import by.bsu.extask.bl.ReaderCommand;
import by.bsu.extask.bl.ReaderListCommand;
import by.bsu.extask.bl.LoginCommand;
import by.bsu.extask.bl.EditionCommand;
import by.bsu.extask.bl.LanBinCharHouListCommand;
import by.bsu.extask.bl.AddEditionCommand;
import by.bsu.extask.bl.AddEditionToReaderCommand;
import by.bsu.extask.bl.DeliveryListCommand;
import by.bsu.extask.bl.YourOverdueBooksCommand;
import by.bsu.extask.bl.YourFinishedBooksCommand;
import by.bsu.extask.bl.AddPublishingHouseCommand;
import by.bsu.extask.bl.AddAuthorCommand;
import by.bsu.extask.bl.LinkCommand;
import by.bsu.extask.bl.LinkAddNewReaderCommand;
import by.bsu.extask.bl.LinkAddNewPublishingHouse;
import by.bsu.extask.bl.DeleteReaderCommand;
import by.bsu.extask.bl.BtnDeleteCommand;
import by.bsu.extask.bl.DeliveryEditionPassCommand;
import by.bsu.extask.bl.AdminAddEditionToReaderCommand;
import by.bsu.extask.bl.SearchReaderCommand;
import by.bsu.extask.bl.SearchEditionCommand;
import by.bsu.extask.bl.LinkAdminEditionShowCommand;
import by.bsu.extask.bl.InfoAboutEditionCommand;
import by.bsu.extask.bl.CheckInCommand;
import by.bsu.extask.bl.LinkAdminReaderShowCommand;
import by.bsu.extask.bl.ReaderReestablishCommand;

class RequestHelper {

	private static RequestHelper instance = null;
	
	private HashMap<String, Command> commands;
	
	private RequestHelper(){
		commands = new HashMap<String, Command>();
		commands.put("reader", new ReaderCommand());
		commands.put("reader_list", new ReaderListCommand());
		commands.put("login", new LoginCommand());
		commands.put("edition", new EditionCommand());
		commands.put("add_edition", new LanBinCharHouListCommand());
		commands.put("admin_add_edition", new AddEditionCommand());
		commands.put("add_edition_to_reader_one", new AddEditionToReaderCommand());
		//commands.put("your_books", new DeliveryListCommand());
		commands.put("info_about_reader_edition", new DeliveryListCommand());
		//commands.put("your_overdue_books", new DeliveryListCommand());
		commands.put("your_finished_books", new YourFinishedBooksCommand());
		commands.put("add_publishing_house", new AddPublishingHouseCommand());
		commands.put("add_author", new AddAuthorCommand());
		commands.put("link", new LinkCommand());
		commands.put("add_new_reader", new LinkAddNewReaderCommand());
		commands.put("add_new_house", new LinkAddNewPublishingHouse());
		commands.put("delete_reader", new DeleteReaderCommand());
		commands.put("btn_delete_command", new BtnDeleteCommand());
		commands.put("pass_edition", new DeliveryEditionPassCommand());
		commands.put("admin_add_edition_to_reader", new AdminAddEditionToReaderCommand());
		commands.put("search_login_reader", new SearchReaderCommand());
		commands.put("search_id_edition", new SearchEditionCommand());
		commands.put("admin_edition_show", new LinkAdminEditionShowCommand());
		commands.put("info_about_edition", new InfoAboutEditionCommand());
		commands.put("check_in", new CheckInCommand());
		commands.put("admin_reader_show", new LinkAdminReaderShowCommand());
		commands.put("reader_reestablish", new ReaderReestablishCommand());
	}
	
	public Command getCommand(String action){
		Command command = commands.get(action);
		return command;
	}
	
	public static RequestHelper getInstance(){
		if (instance == null){
			instance = new RequestHelper();
		}
		return instance;
	}
	
}
