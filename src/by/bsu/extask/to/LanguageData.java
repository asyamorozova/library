package by.bsu.extask.to;

public class LanguageData extends ActionData{

	public String idlanguage;
	public String languageName;
	
	public LanguageData(String idlanguage, String languageName){
		this.idlanguage = idlanguage;
		this.languageName = languageName;
	}
	
	/*public int getIdLanguage(){
		return idlanguage;
	}*/
	
	public String getLanguageName(){
		return languageName;
	}
	
}
