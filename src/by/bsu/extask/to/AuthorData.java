package by.bsu.extask.to;

public class AuthorData extends ActionData{

	public String idauthor;
	public String authorName;
	public String country;
	
	public AuthorData(String idauthor, String authorName, String country){
		this.idauthor = idauthor;
		this.authorName = authorName;
		this.country = country;
	}
	
	public AuthorData(String idauthor, String authorName){
		this.idauthor = idauthor;
		this.authorName = authorName;
	}
	
	public AuthorData(String idauthor){
		this.idauthor = idauthor;
	}
	
	public String getIDAuthor(){
		return idauthor;
	}
	
}
