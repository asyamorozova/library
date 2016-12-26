<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="by.bsu.extask.to.ReaderList"%>
<%@ page import="by.bsu.extask.to.ReaderData"%>

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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
 //Функция показа
    function show(state, nameClass){
            /*document.getElementById('window').style.display = state;*/
            document.getElementById('wrap').style.display = state;
            var windowClassElements = document.querySelector(nameClass);
            //var windowClassElements = document.querySelector('.y');
            windowClassElements.classList.toggle('block');
    }
     
</script>

<style>
   <%@include file='/WEB-INF/css/cabinet_style.css' %>
   <%@include file='/WEB-INF/css/media_screen_admin.css' %>
</style>

<body>

<div id="wrap"></div>
	

	<div class="header">
		<p class="sirius">Сириус</p>
		<p class="library">Библиотека</p>
	</div>
	
	<ul>
		<li><form name="link-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="admin_edition_show"/>
 				<input style="cursor: pointer;" class = "change" type="submit" value="Издания /"/>
			</form></li>
		<li style="cursor: pointer;" class="selected"><button class="change"><button class="change">Читатели</button></li>
	</ul>

	<!--<jsp:include page="/WEB-INF/jsp/example.html" />-->
	
	<!--<div class="content">
		<div class="nav">
			<button class = "button" onclick="show('block','.add_edition')">Add new edition</button>
			<button class = "button" onclick="show('block','.add_new_house')">Add new publishing house</button>
			<button class = "button" onclick="show('block','.add_new_author')">Add new author</button>
		</div>-->
		
		<br/>
	<form name="search-form" method="post" action="mmm">
		<input type="hidden" name="command" value="search_login_reader" />
		<!--Number reader:<br/>-->
		<input pattern="[0-9]{0,3}" id = "search_number" placeholder="Введите номер читателя..." type="text" name="idreader" value=""/><br/>
		<input class = "search_num" type="submit" value="Искать"/>
	</form>
		
		<button style="cursor: pointer;"  class = "button" onclick="show('block','.window')">+ Добавить нового читателя</button>
	
		<div class="list">
			<%
				//ReaderData reader = (ReaderData)request.getAttribute("searchReaderList");
			%>
			<p class="name">В списках нет читателя с таким номером билета.</p>
			<!--<div class="reader">
				<p class="id"><%//=reader.idreader%></p>
				<p class="name"><%//=reader.surname%> <%//=reader.name%> <%//=reader.patronymic%></p>
				<p class="info">Адрес: <%//=reader.adress%></p>
				<p class="info" style="margin-top:-18px;">Телефон: <%//=reader.phone%></p>
				<form name="delete-form" method="post" action="mmm">
						<input type="hidden" name="idreader" value="<%//=reader.idreader%>">
 						<input type="hidden" name="command" value="delete_reader"/>
 						<input class = "close" type="submit" value="Удалить"/>
					</form>
					
					<form name="info-form" method="post" action="mmm">
						<input type="hidden" name="login" value="<%//=reader.login%>">
 						<input type="hidden" name="command" value="info_about_reader_edition"/>
 						<input class = "more" type="submit" value="Смотреть больше..."/>
					</form>
					
					<hr noshade>
			</div>-->
		</div>
	</div>


	<div class="window">
	<button class = "btnClose" onclick="show('none','.window')"></button>
		<form name="reader-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="reader"/>
 		<!--<p class="twindow">Number ticket:</p><br/>
 		<input class="fwindow" type="text" name="numberTicket" value=""/> <br/>-->
 		<p class="twindow">Фамилия:</p><br/>
 		<input class="fwindow" type="text" name="surname" value="">
		<br/>
		<p class="twindow">Имя:</p><br/>
 		<input class="fwindow" type="text" name="name" value="">
		<br/>
		<p class="twindow">Отчество:</p><br/>
 		<input class="fwindow" type="text" name="patronymic" value="">
		<br/>
		<p class="twindow">Адрес:</p><br/>
 		<input class="fwindow" type="text" name="adress" value="">
		<br/>
		<p class="twindow">Телефон:</p><br/>
 		<input class="fwindow" type="text" name="phone" value="">
		<br/>
		<input class = "subm" type="submit" value="Добавить"/>
	</form>
	</div>


	<div class="add_new_house">
		<button class = "btnClose" onclick="show('none','.add_new_house')"></button>
		<form name="add-form" method="post" action="mmm">
 			<input type="hidden" name="command" value="add_publishing_house"/>
			Name Publishing House:<br/>
			<input type="text" name="houseName" value=""/><br/>
			City's publishing house:<br/>
			<input type="text" name="city" value=""><br/>
 			<input type="submit" value="Add Publishing House"/>
		</form>
	</div>

	<div class="add_new_author">
		<button class = "btnClose" onclick="show('none','.add_new_author')"></button>
		<form name="add-form" method="post" action="mmm">
 			<input type="hidden" name="command" value="add_author"/>
			Name Author:<br/>
			<input type="text" name="authorName" value=""/><br/>
			Country's author:<br/>
			<input type="text" name="country" value=""><br/>
 			<input type="submit" value="Add Author"/>
		</form>
	</div>
	

		<div class="add_edition">
			<%out.println("Ky"); %>
			<button class = "btnClose" onclick="show('none','.add_edition')"></button>
			<form name="add-edition-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="admin_add_edition"/>
 		Date Edition:<br/>
 		<input type="text" name="dateEdition" value="">
		<br/>
		<select size="3" multiple name="idlanguage">
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
 		<br/>
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
			<!--<include page="/WEB-INF/jsp/add_edition.jsp" />-->
		</div>

</body>
</html>