package by.bsu.extask.to;

public class EditionData extends ActionData{
	
	public String language;
	public String languageString;
	
	public String idedition;
	public String binding;
	public String series;
	public String publishingHouse;
	public String author;
	public String character;
	public String nameedition;
	public String dateEdition;
	
	public String annotation;
	public String idPlace;
	public String numRack;
	public String numRackLittle;
	
	public String nameEdition;
	
	public String languageName;
	public String houseName;
	public String bindingName;
	public String seriesName;
	public String authorName;
	public String characterName;
	
	/*public EditionData(int language, int binding, int series, int publishingHouse, int author, int character, String wayIMG){
		this.language = language;
		this.binding = binding;
		this.series = series;
		this.publishingHouse = publishingHouse;
		this.author = author;
		this.character = character;
		this.wayIMG = wayIMG;
	}
	
	public EditionData(int language, int binding, int series, int publishingHouse, int author, int character){
		this.language = language;
		this.binding = binding;
		this.series = series;
		this.publishingHouse = publishingHouse;
		this.author = author;
		this.character = character;
	}*/
	
	public EditionData(String idedition, String language, String binding, String series, String publishingHouse, String author, String character, String nameEdition){
		this.idedition = idedition;
		this.language = language;
		this.binding = binding;
		this.series = series;
		this.publishingHouse = publishingHouse;
		this.author = author;
		this.character = character;
		this.nameEdition = nameEdition;
	}
	
	public EditionData(String idedition, String language, String binding, String series, String publishingHouse, String author, String character, String nameEdition, String nameedition){
		this.idedition = idedition;
		this.language = language;
		this.binding = binding;
		this.series = series;
		this.publishingHouse = publishingHouse;
		this.author = author;
		this.character = character;
		this.nameEdition = nameEdition;
		this.nameedition = nameedition;
	}
	
	public EditionData(String idedition, String dateEdition, String language, String languageName, String binding, String bindingName, String series, /*String seriesName,*/ String publishingHouse, String houseName, String author, String authorName, String character, String characterName, String nameEdition){
		this.idedition = idedition;
		this.dateEdition = dateEdition;
		this.language = language;
		this.languageName = languageName;
		this.binding = binding;
		this.bindingName = bindingName;
		this.series = series;
		//this.seriesName = seriesName;
		this.publishingHouse = publishingHouse;
		this.houseName = houseName;
		this.author = author;
		this.authorName = authorName;
		this.character = character;
		this.characterName = characterName;
		this.nameEdition = nameEdition;
	}
	
	public EditionData(String idedition, String dateEdition, String language, String languageName, String binding, String bindingName, String series, /*String seriesName,*/ String publishingHouse, String houseName, String author, String authorName, String character, String characterName, String nameEdition, String idPlace, String numRack, String numRackLittle){
		this.idedition = idedition;
		this.dateEdition = dateEdition;
		this.language = language;
		this.languageName = languageName;
		this.binding = binding;
		this.bindingName = bindingName;
		this.series = series;
		//this.seriesName = seriesName;
		this.publishingHouse = publishingHouse;
		this.houseName = houseName;
		this.author = author;
		this.authorName = authorName;
		this.character = character;
		this.characterName = characterName;
		this.nameEdition = nameEdition;
		this.idPlace = idPlace;
		this.numRack = numRack;
		this.numRackLittle = numRackLittle;
	}
	
	/*public EditionData(String idedition, String language, String languageName, String binding, String bindingName, String series, /*String seriesName,*/ //String publishingHouse, String houseName, String author, String authorName, String character, String characterName, String nameEdition, String nameedition){
		/*this.idedition = idedition;
		this.language = language;
		this.languageName = languageName;
		this.binding = binding;
		this.bindingName = bindingName;
		this.series = series;
		//this.seriesName = seriesName;
		this.publishingHouse = publishingHouse;
		this.houseName = houseName;
		this.author = author;
		this.authorName = authorName;
		this.character = character;
		this.characterName = characterName;
		this.nameEdition = nameEdition;
		this.nameedition = nameedition;
	}*/
	
	
	//Vot eto bilo ne zakomancheno
	/*public EditionData(String idedition, String language, String languageName, String binding, String bindingName, String series, /*String seriesName,*/ //String publishingHouse, String houseName, String author, String authorName, String character, String characterName, String annotation, String idPlace, String numRack, String numRackLittle, String nameEdition){
		/*this.idedition = idedition;
		this.language = language;
		this.languageName = languageName;
		this.binding = binding;
		this.bindingName = bindingName;
		this.series = series;
		//this.seriesName = seriesName;
		this.publishingHouse = publishingHouse;
		this.houseName = houseName;
		this.author = author;
		this.authorName = authorName;
		this.character = character;
		this.characterName = characterName;
		this.annotation = annotation;
		this.idPlace = idPlace;
		this.numRack = numRack;
		this.numRackLittle = numRackLittle;
		this.nameEdition = nameEdition;
	}*/
	
	/*public EditionData(String idedition, String dateEdition, String language, String languageName, String binding, String bindingName, String series, /*String seriesName,*/ //String publishingHouse, String houseName, String author, String authorName, String character, String characterName, String annotation, String idPlace, String numRack, String numRackLittle, String nameEdition){
		/*this.idedition = idedition;
		this.dateEdition = dateEdition;
		this.language = language;
		this.languageName = languageName;
		this.binding = binding;
		this.bindingName = bindingName;
		this.series = series;
		//this.seriesName = seriesName;
		this.publishingHouse = publishingHouse;
		this.houseName = houseName;
		this.author = author;
		this.authorName = authorName;
		this.character = character;
		this.characterName = characterName;
		this.annotation = annotation;
		this.idPlace = idPlace;
		this.numRack = numRack;
		this.numRackLittle = numRackLittle;
		this.nameEdition = nameEdition;
	}*/
	
	public EditionData(String idedition){
		this.idedition = idedition;
	}
	
	public String getIdedition(){
		return idedition;
	}
	
	/*public EditionData(String languageString, int binding, int series, int publishingHouse, int author, int character){
		this.languageString = languageString;
		this.binding = binding;
		this.series = series;
		this.publishingHouse = publishingHouse;
		this.author = author;
		this.character = character;
	}
	
	public int getLanguage(){
		return language;
	}
	
	public int getBinding(){
		return binding;
	}
	
	public int getSeries(){
		return series;
	}
	
	public int getPublishingHouse(){
		return publishingHouse;
	}
	
	public int getAuthor(){
		return author;
	}
	
	public int getCharacter(){
		return character;
	}*/
	
}
