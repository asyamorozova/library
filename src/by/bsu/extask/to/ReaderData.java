package by.bsu.extask.to;
import java.awt.event.*;

//import java.awt.image.*;

//import java.awt.image;

public class ReaderData extends ActionData{
	
	public int idreader;
	public String name;
	public String surname;
	public String patronymic;//��������
	public String adress;
	public String phone;
	public String login;
	public String password;
	public String status;
	public String Idreader;
	
	public ReaderData(String name, String surname, String status){
		this.name = name;
		this.surname = surname;
		this.status = status;
	}
	
	//public ReaderData(int number, String name, String surname, String patronymic, String adress, String phone){
	public ReaderData(int idreader, String name, String surname, String patronymic, String adress, String phone, String login,String password){
		this.idreader = idreader;
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.adress = adress;
		this.phone = phone;
		this.login = login;
		this.password = password;
	}
	
	public ReaderData(String Idreader, String login){
		this.Idreader = Idreader;
		this.login = login;
	}
	
	public ReaderData(String Idreader){
		this.Idreader = Idreader;
	}
	
	public String getIdReader(){
		return Idreader;
	}
	
	public String getLogin(){
		return login;
	}
	
	
}
