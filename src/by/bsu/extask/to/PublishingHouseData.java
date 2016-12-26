package by.bsu.extask.to;

public class PublishingHouseData extends ActionData{

	public String idhouse;
	public String nameHouse;
	public String nameCity;
	
	public PublishingHouseData(String idhouse, String nameHouse, String nameCity){
		this.idhouse = idhouse;
		this.nameHouse = nameHouse;
		this.nameCity = nameCity;
	}
	
	public PublishingHouseData(String idhouse, String nameHouse){
		this.idhouse = idhouse;
		this.nameHouse = nameHouse;
	}
	
	public PublishingHouseData(String idhouse){
		this.idhouse = idhouse;
	}
	
	public String getIdHouse(){
		return idhouse;
	}
	
}
