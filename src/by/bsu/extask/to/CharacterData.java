package by.bsu.extask.to;

public class CharacterData extends ActionData{

	//public int idcharacter;
	public String idcharacter;
	public String characterName;
	
	public CharacterData(String characterName){
		this.characterName = characterName;
	}
	
	public CharacterData(String idcharacter, String characterName){
		this.idcharacter = idcharacter;
		this.characterName = characterName;
	}
	
}
