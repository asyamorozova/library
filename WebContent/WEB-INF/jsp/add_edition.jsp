<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="by.bsu.extask.to.LanguageList"%>
<%@ page import="by.bsu.extask.to.LanguageData"%>
<%@ page import="by.bsu.extask.to.BindingList"%>
<%@ page import="by.bsu.extask.to.BindingData"%>
<%@ page import="by.bsu.extask.to.CharacterList"%>
<%@ page import="by.bsu.extask.to.CharacterData"%>
<%@ page import="by.bsu.extask.to.PublishingHouseList"%>
<%@ page import="by.bsu.extask.to.PublishingHouseData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form name="add-edition-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="admin_add_edition"/>
 		Date Edition:<br/>
 		<input type="text" name="dateEdition" value="">
		<br/>
		<select size="1" multiple name="idlanguage">
    		<option disabled>Language</option>
    		<%
				LanguageList languages = (LanguageList)request.getAttribute("languageList");
				for(LanguageData language : languages.languageList){
			%>
    		<option value="<%=language.idlanguage%>" name = "<%=language.idlanguage%>"><%=language.languageName%></option>
    		<%
			}
			%>
   		</select>
 		
 		<select size="4" multiple name="idbinding">
    		<option disabled>Binding</option>
    		<%
				BindingList bindings = (BindingList)request.getAttribute("bindingList");
				for(BindingData binding : bindings.bindingList){
			%>
    		<option value="<%=binding.idbinding%>"><%=binding.nameBinding%></option>
    		<%
			}
			%>
   		</select>
 		<!--Binding:<br/>
 		<input type="text" name="idbinding" value="">
		<br/>-->
		Name Series:<br/>
 		<input type="text" name="idseries" value="">
		<br/>
		
		
		<select size="3" multiple name="idhouse">
    		<option disabled>Name Publishing House</option>
    		<%
    			PublishingHouseList publishingHouses = (PublishingHouseList)request.getAttribute("publishingHouseList");
				for(PublishingHouseData publishingHouse : publishingHouses.publishingHouseList){
			%>
    		<option value="<%=publishingHouse.idhouse%>"><%=publishingHouse.nameHouse%></option>
    		<%
			}
			%>
   		</select>
   		
		Author:<br/>
 		<input type="text" name="idauthor" value="">
		<br/>
		Character:<br/>
 		<input type="text" name="idcharacter" value="">
		<br/>
		
		Image:<br/>
 		<input type="text" name="img" value="">
		<br/>
		<input type="submit" value="Enter"/>
	</form>
	
	

   		<!-- Tolko poka zakomentila -->
		<!--Count book in Series:<br/>
 		<input type="text" name="countBookInSeries" value="">
		<br/>-->
		
   		
   		<!--<select size="3" multiple name="Character[]">
    		<option disabled>Character</option>
    		<option value="fantastik">1</option>
    		<option value="biography">2</option>
    		<option value="horrors">3</option>
   		</select>-->
</body>
</html>