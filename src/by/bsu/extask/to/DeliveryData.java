package by.bsu.extask.to;

public class DeliveryData extends ActionData{

	public String idreader;
	public String idedition;
	public String dateDelivery;
	public String timeReturn;
	public String dateReturn;
	public String loginReader;
	public String deliveryTF;
	
	public DeliveryData(String idreader, String idedition, String dateDelivery, String timeReturn, String dateReturn){
		this.idreader = idreader;
		this.idedition = idedition;
		this.dateDelivery = dateDelivery;
		this.timeReturn = timeReturn;
		this.dateReturn = dateReturn;
	}
	
	public DeliveryData(String idreader, String idedition, String dateDelivery, String timeReturn, String dateReturn, String loginReader){
		this.idreader = idreader;
		this.idedition = idedition;
		this.dateDelivery = dateDelivery;
		this.timeReturn = timeReturn;
		this.dateReturn = dateReturn;
		this.loginReader = loginReader;
	}
	
	public DeliveryData(String idreader, String idedition){
		this.idreader = idreader;
		this.idedition = idedition;
	}
	
	public DeliveryData(String idedition){
		this.idedition = idedition;
	}
	
	public String getLoginReader(){
		return loginReader;
	}
	
}
