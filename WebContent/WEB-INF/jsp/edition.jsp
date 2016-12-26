<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="by.bsu.extask.to.EditionData"%>
 <%@ page import="by.bsu.extask.to.EditionList"%>
 <%@ page import="by.bsu.extask.to.ReaderData"%>
 <%@ page import="by.bsu.extask.to.ReaderList"%>
 
<%@ page import="by.bsu.extask.to.LanguageList"%>
<%@ page import="by.bsu.extask.to.LanguageData"%>
<%@ page import="by.bsu.extask.to.BindingList"%>
<%@ page import="by.bsu.extask.to.BindingData"%>
<%@ page import="by.bsu.extask.to.CharacterList"%>
<%@ page import="by.bsu.extask.to.CharacterData"%>
<%@ page import="by.bsu.extask.to.PublishingHouseList"%>
<%@ page import="by.bsu.extask.to.PublishingHouseData"%>
<%@ page import="by.bsu.extask.to.AuthorList"%>
<%@ page import="by.bsu.extask.to.AuthorData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
    
    function btnClick(){
       	document.getElementById('good').style.display = 'none';
       }   
    
    function btnNoClick(){
       	document.getElementById('no_house_good').style.display = 'none';
       }
    
    function btnbtnClick(){
       	document.getElementById('good_author').style.display = 'none';
       } 
    
    function btnbtnNoClick(){
       	document.getElementById('no_good_author').style.display = 'none';
       } 
    
    function btnEditClick(){
       	document.getElementById('add_good_edition').style.display = 'none';
       } 
            
    function AddPhoto()
    {
            var imagefile = document.getElementsByName('user_pic').item(0);
            
            document.getElementById("dowload").parentNode.removeChild(document.getElementById("dowload"));
            var imgDow = document.createElement("img");
            
            imgDow.setAttribute("id","dowload");
            document.getElementById("uploadphoto").appendChild(imgDow,document.getElementById("dow"));                    
            document.getElementById("dowload").style.paddingTop = "0"; 
            
            var image = document.getElementById('dowload');
            if(typeof(FileReader)!='undefined')
            {
                    var reader = new FileReader();
                    reader.onload = function(e){
                            image.src = e.target.result;
                    }
                    reader.readAsDataURL(imagefile.files.item(0));
            }
            
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
		<li  class="selected"><form name="link-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="admin_edition_show"/>
 				<input class = "change" type="submit" style="cursor: pointer;" value="Издания /"/>
			</form></li>
		<form name="link-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="admin_reader_show"/>
 				<input class = "change" type="submit" style="cursor: pointer;" value="Читатели"/>
			</form>
		<!--<li><button class="change">Reader</button></li>-->
	</ul>
	
	
	<br/>
	<form name="search-form" method="post" action="mmm">
		<input type="hidden" name="command" value="search_id_edition" />
		<input pattern="[0-9]{0,3}" id = "search_number" type="text" placeholder="Введите номер издания..." name="idedition" value=""/><br/>
		<input class = "search_num" type="submit" value="Искать"/>
	</form>
	

		
			<button style="cursor: pointer;" class = "button" onclick="show('block','.add_edition')">+ Добавить новое издание</button>
			<button style="cursor: pointer;" class = "button" style="margin-top:-5px;" onclick="show('block','.add_new_author')">+ Добавить нового автора</button>
			<button style="cursor: pointer;" class = "button" style="margin-top:-5px;" onclick="show('block','.add_new_house')">+ Добавить новое издательство</button>
	<%	
		if(((String)session.getAttribute("add_house")).equals("false"))
{ //out.println("Такое издание уже есть у читателя!");}
%>
	<!--<p>Такая книга уже есть у пользователя!</p>-->
	<!--<jsp:include page="/WEB-INF/jsp/edition_false.jsp" />-->
	<div id="good" style="/*margin-top:10%;margin-left:50%; background:white; font-family:Verdana; font-size:20px;*/">
		<p>Новое издательство добавлено!</p>
		<button onclick="btnClick()" style="margin-left:35%; background:black; border:0px;padding-left:10px;padding-right:10px;font-family:Verdana; font-size:20px;color:white;">OK</button>
	</div>
<% 
	}
%>

	<%	
		if(((String)session.getAttribute("no_add_house")).equals("false"))
{ //out.println("Такое издание уже есть у читателя!");}
%>
	<!--<p>Такая книга уже есть у пользователя!</p>-->
	<!--<jsp:include page="/WEB-INF/jsp/edition_false.jsp" />-->
	<div id="no_house_good" style="/*margin-top:10%;margin-left:50%; background:white; font-family:Verdana; font-size:20px;*/">
		<p>Издательство не добавлено, такое издательство уже есть в списке!</p>
		<button onclick="btnNoClick()" style="margin-left:35%; background:black; border:0px;padding-left:10px;padding-right:10px;font-family:Verdana; font-size:20px;color:white;">OK</button>
	</div>
<% 
	}
%>

	<%	
		if(((String)session.getAttribute("add_author")).equals("false"))
{ //out.println("Такое издание уже есть у читателя!");}
%>
	<!--<p>Такая книга уже есть у пользователя!</p>-->
	<!--<jsp:include page="/WEB-INF/jsp/edition_false.jsp" />-->
	<div id="good_author" style="/*margin-top:10%;margin-left:50%; background:white; font-family:Verdana; font-size:20px;*/">
		<p>Новый автор добавлен!</p>
		<button onclick="btnbtnClick()" style="margin-left:35%; background:black; border:0px;padding-left:10px;padding-right:10px;font-family:Verdana; font-size:20px;color:white;">OK</button>
	</div>
<% 
	}
%>

	<%	
		if(((String)session.getAttribute("no_add_author")).equals("false"))
{ //out.println("Такое издание уже есть у читателя!");}
%>
	<!--<p>Такая книга уже есть у пользователя!</p>-->
	<!--<jsp:include page="/WEB-INF/jsp/edition_false.jsp" />-->
	<div id="no_good_author" style="/*margin-top:10%;margin-left:50%; background:white; font-family:Verdana; font-size:20px;*/">
		<p>Автор не добавлен, такой автор уже есть в списке!</p>
		<button onclick="btnbtnNoClick()" style="margin-left:35%; background:black; border:0px;padding-left:10px;padding-right:10px;font-family:Verdana; font-size:20px;color:white;">OK</button>
	</div>
<% 
	}
%>

	<%	
		if(((String)session.getAttribute("add_new_edition")).equals("false"))
{ //out.println("Такое издание уже есть у читателя!");}
%>
	<!--<p>Такая книга уже есть у пользователя!</p>-->
	<!--<jsp:include page="/WEB-INF/jsp/edition_false.jsp" />-->
	<div id="add_good_edition" style="/*margin-top:10%;margin-left:50%; background:white; font-family:Verdana; font-size:20px;*/">
		<p>Новое издание добавлено!</p>
		<button onclick="btnEditClick()" style="margin-left:35%; background:black; border:0px;padding-left:10px;padding-right:10px;font-family:Verdana; font-size:20px;color:white;">OK</button>
	</div>
<% 
	}
%>
		
		<div class="list">
			<div class="reader">
				<%
		//ReaderData reader = (ReaderData) session.getAttribute("login");
	%>
	<p><%//=session.getAttribute("login")%></p>

		<% 	EditionList editions = (EditionList)request.getAttribute("editionList");
			for(EditionData edition : editions.editionList){
		%>
		<p class="id"><%=edition.idedition%></p>
		<p class="name">Название: <%=edition.nameEdition%></p>
		<p class="name" style="margin-top:-35px; font-size:17px;">Автор: <%=edition.authorName%></p>
		
		<p class="info">Язык: <%=edition.languageName%></p>
		<p class="info" style="margin-top:-18px;">Дата издания: <%=edition.dateEdition%></p>
		<p class="info" style="margin-top:-18px;">Издательство: <%=edition.houseName%></p>
		<p class="info" style="margin-top:-18px;">Жанр: <%=edition.characterName%></p>
		<p class="info" style="margin-top:-18px;">Переплет: <%=edition.bindingName%></p>
		
		<!--<div class="kkk">-->
			<p class="info" style="margin-top:-5px; font-size:18px; font-weight:bold;"><!--Номер места:--> <%//=edition.idPlace%> Номер стеллажа: <%=edition.numRack%> Номер полки: <%=edition.numRackLittle%></p>
			<!--<p class="place" style="margin-top:-18px;">Номер стеллажа: <%=edition.numRack%></p>
			<p class="place" style="margin-top:-18px;">Номер полки: <%=edition.numRackLittle%></p>-->
		<!--</div>-->
		
		<!--<form name="info-form" method="post" action="mmm">
			<input type="hidden" name="idedition" value="<%=edition.idedition%>">
 			<input type="hidden" name="command" value="info_about_edition"/>
 			<input class = "more" style="margin-top:-25px;" type="submit" value="Смотреть больше..."/>
		</form>-->
		<hr noshade>
		<%
			}
		%>
			</div>
		</div>

	<div class="add_new_author">
		<button class = "btnClose" onclick="show('none','.add_new_author')"></button>
		<form name="add-form" method="post" action="mmm" accept-charset="utf-8">
 			<input type="hidden" name="command" value="add_author"/>
			<p class="twindow">Имя автора:</p><br/>
			<input class="fwindow" type="text" name="authorName" value=""/><br/>
			<p class="twindow">Страна:</p><br/>
			<input class="fwindow" type="text" name="country" value=""><br/>
 			<input class = "subm" style ="margin-left:33%;" type="submit" value="Добавить"/>
		</form>
	</div>
	
	<div class="add_new_house">
		<button class = "btnClose" onclick="show('none','.add_new_house')"></button>
		<form name="add-form" method="post" action="mmm">
 			<input type="hidden" name="command" value="add_publishing_house"/>
			<p class="twindow">Издательство:</p><br/>
			<input class="fwindow" type="text" name="houseName" value=""/><br/>
			<p class="twindow">Город:</p><br/>
			<input class="fwindow" style type="text" name="city" value=""><br/>
 			<input class = "subm"  type="submit" value="Добавить"/>
		</form>
	</div>
	

		<div class="add_edition">
			<%//out.println("Ky"); %>
			<button class = "btnClose" onclick="show('none','.add_edition')"></button>
			<form name="add-edition-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="admin_add_edition"/>
 		<p class="twindow">Название:</p><br/>
 		<input class="fwindow" type="text" name="nameEdition" value="">
		<br/>
 		<p class="twindow">Дата издания:</p><br/>
 		<input pattern="[0-9]{0,4}" class="fwindow" type="text" name="dateEdition" value="">
		<br/>
		<p class="twindow">Язык:</p><br/>
		<select class="selwindow" size="1" name="idlanguage">
    		<!--<option disabled>Language</option>-->
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
 		<p class="twindow">Переплет:</p><br/>
 		<select class="selwindow" size="1" name="idbinding">
    		<!--<option disabled>Binding</option>-->
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
		<!--<p class="twindow">Название серии:</p><br/>
 		<input class="fwindow" type="text" name="idseries" value="">
		<br/>-->
		
		<p class="twindow">Издательство:</p><br/>
		<select class="selwindow" size="1" name="idhouse">
    		<!--<option disabled>Name Publishing House</option>-->
    		<%
    			PublishingHouseList publishingHouses = (PublishingHouseList)request.getAttribute("publishingHouseList");
				for(PublishingHouseData publishingHouse : publishingHouses.publishingHouseList){
			%>
    		<option value="<%=publishingHouse.idhouse%>"><%=publishingHouse.nameHouse%></option>
    		<%
			}
			%>
   		</select>
   		
		<p class="twindow">Автор:</p><br/>
 		<!--<input class="fwindow" type="text" name="idauthor" value="">-->
 		<select class="selwindow" size="1" name="idauthor">
    		<%
    			AuthorList authors = (AuthorList)request.getAttribute("authorList");
				for(AuthorData author : authors.authorList){
			%>
    		<option value="<%=author.idauthor%>"><%=author.authorName%></option>
    		<%
			}
			%>
   		</select>
		<br/>
		<br/>
		<p class="twindow" style="margin-top:-5px;">Жанр:</p><br/>
 		<!--<input class="fwindow" type="text" name="idcharacter" value="">-->
 		<select class="selwindow" size="1" name="idcharacter">
    		<%
    			CharacterList characters = (CharacterList)request.getAttribute("characterList");
				for(CharacterData character : characters.characterList){
			%>
    		<option value="<%=character.idcharacter%>"><%=character.characterName%></option>
    		<%
			}
			%>
   		</select>
		<br/>
		
		<!--<p class="twindow">Изображение:</p><br/>
 		<input class="fwindow" type="text" name="img" value="">
		<br/>-->
		<input class = "subm" style="margin-top:25px;" type="submit" value="Добавить"/>
	</form>
		</div>	
		
		
		<!-- enctype="multipart/form-data" -->
		<!--<form id="addphoto" name="add-form" action="../AddBird" method="post" enctype="multipart/form-data">
                    <section id="uploadphoto">
                        <div>
                            <p><input type="hidden" name="MAX_FILE_SIZE" value="4000000"/></p>
                            <p>
                                <label class="file_upload">
                                    Download photo<br><span>click on change</span>
                                    <input type="file" name="user_pic" onChange="AddPhoto();">
                                </label>
                            </p>
                        </div>
                        <div id="dowload"></div>
                    </section>
                    <input class = "subm" type="submit" value="Enter"/>
</form>-->
	
</body>
</html>



	<!--<select class="changes" size="1" name="change">
    		<option value="" name = "author">Author</option>
    		<option value="" name = "language">Language</option>
    		<option value="" name = "publishingHouse">Publishing house</option>
    		<option value="" name = "binding">Binding</option>
    		<option value="" name = "character">Character</option>
   	</select>
   	<select class="changesel" size="1" name="change">
    		<option value="" name = "author">Author</option>
    		<option value="" name = "language">Language</option>
    		<option value="" name = "publishingHouse">Publishing house</option>
    		<option value="" name = "binding">Binding</option>
    		<option value="" name = "character">Character</option>
   	</select>-->



<!--<form name="edition-form" method="post" action="mmm">
		<input type="hidden" name="login" value="<%=session.getAttribute("login")%>">
 		<input type="hidden" name="command" value="your_books"/>
 		<input type="submit" value="Your books"/>
	</form>
	
	<form name="your-overdue-form" method="post" action="mmm">
		<input type="hidden" name="login" value="<%=session.getAttribute("login")%>">
 		<input type="hidden" name="command" value="your_overdue_books"/>
 		<input type="submit" value="Your overdue books"/>
	</form>
	
	<form name="your-overdue-form" method="post" action="mmm">
		<input type="hidden" name="login" value="<%=session.getAttribute("login")%>">
 		<input type="hidden" name="command" value="your_finished_books"/>
 		<input type="submit" value="Your finished books"/>
	</form>-->