package by.bsu.extask.to;

public class PlaceData extends ActionData{

	public String idplace;
	public String numRack;
	public String numRackLittle;
	public String idedition;
	
	public PlaceData(String idplace, String numRack, String numRackLittle, String idedition){
		this.idplace = idplace;
		this.numRack = numRack;
		this.numRackLittle = numRackLittle;
		this.idedition = idedition;
	}
	
	public PlaceData(String idplace, String numRack, String numRackLittle){
		this.idplace = idplace;
		this.numRack = numRack;
		this.numRackLittle = numRackLittle;
	}
	
}
