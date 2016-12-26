<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="by.bsu.extask.to.ReaderList"%>
<%@ page import="by.bsu.extask.to.ReaderData"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript">
 
            //Функция показа
    function show(state){
            /*document.getElementById('window').style.display = state;*/
            document.getElementById('wrap').style.display = state;
            var windowClassElements = document.querySelector('.window');
            //var windowClassElements = document.querySelector('.y');
            windowClassElements.classList.toggle('block');
    }
     
</script>

<style>
   <%@include file='/WEB-INF/css/cabinet_style.css' %>
</style>

<body>
<div id="wrap"></div>

	<div class="header">
		<p class="sirius">Sirius</p>
		<ul>
			<li>Edition</li>
			<li>Reader</li>
		</ul>
	</div>

	<!--<jsp:include page="/WEB-INF/jsp/example.html" />-->
	
	<div class="content">
	
		<form name="search-form" method="post" action="mmm">
			<input type="hidden" name="command" value="search_reader" />
			Number reader:<br/>
			<input type="text" name="idreader" value=""/><br/>
			<input type="submit" value="Enter"/>
		</form>
	
		<div class="nav">
			<form name="link-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="add_new_reader"/>
 				<input class = "button" type="submit" value="Add new reader"/>
			</form>
			
			<form name="add-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="add_edition"/>
 				<input class = "button" type="submit" value="Add edition"/>
			</form>
			
			<form name="link-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="add_new_house"/>
 				<input class = "button" type="submit" value="Add new publishing house"/>
			</form>
			
			<form name="link-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="add_new_author"/>
 				<input class = "button" type="submit" value="Add new author"/>
			</form>
		</div>
	
		<div class="list">
			<%
				ReaderList readers = (ReaderList)request.getAttribute("readerList");
				int idreader;
				String name;
				String surname;
				String patronymic;
				String adress;
				String phone;
				String login;
				String password;
				String status;
				for(ReaderData reader : readers.readerList){
			%>
			<div class="reader">
			<%idreader = reader.idreader;
				name = reader.name;
				surname = reader.surname;
				patronymic = reader.patronymic;
				adress = reader.adress;
				phone = reader.phone;
				login = reader.login;
				password = reader.password;
				status = reader.status;
				%>
				<p><%=reader.name%> <%=reader.surname%></p>
				
				<!--<button class = "btnClose" onclick="show('block')"></button>
				<form name="delete-form" method="post" action="mmm">
						<input type="hidden" name="idreader" value="<%=reader.idreader%>">
						<input type="hidden" name="command" value="btn_delete_command"/>
 						<input class = "close_one" type="submit" value=""/>
				</form>-->
				
				<!--<div class="window">-->
					<!--<p>Are you sure want to delete <%=reader.idreader%></p>
					<button onclick="show('none')">Cancel</button>-->
					<form name="delete-form" method="post" action="mmm">
						<input type="hidden" name="idreader" value="<%=reader.idreader%>">
 						<input type="hidden" name="command" value="delete_reader"/>
 						<input class = "close" type="submit" value="Delete"/>
					</form>
				<!--</div>-->
			</div>
			<%
				}
				
			%>
		</div>
	</div>

<!--<form name="reader-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="reader"/>
 		NumberTicket:<br/>
 		<input type="text" name="numberTicket" value=""/> <br/>
 		Surname:<br/>
 		<input type="text" name="surname" value="">
		<br/>
		Name:<br/>
 		<input type="text" name="name" value="">
		<br/>
		Patronymic:<br/>
 		<input type="text" name="patronymic" value="">
		<br/>
		Adress:<br/>
 		<input type="text" name="adress" value="">
		<br/>
		Phone:<br/>
 		<input type="text" name="phone" value="">
		<br/>
		<input type="submit" value="Enter"/>
	</form>-->
	
	
	<!--<div class="all">
	<form name="reader-list-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="reader_list"/>
 		<input type="submit" value="Vuvesti vseh reader"/>
	</form>-->
	
	
	
	
	<!--<form name="add-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="add_edition"/>
 		<input type="submit" value="Add edition"/>
	</form>-->
	
	
	
	
	
	<!--<form name="add-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="add_publishing_house"/>
		Name Publishing House:<br/>
		<input type="text" name="houseName" value=""/><br/>
		City's publishing house:<br/>
		<input type="text" name="city" value=""><br/>
 		<input type="submit" value="Add Publishing House"/>
	</form>-->
	
	<!--<form name="add-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="add_author"/>
		Name Author:<br/>
		<input type="text" name="authorName" value=""/><br/>
		Country's author:<br/>
		<input type="text" name="country" value=""><br/>
 		<input type="submit" value="Add Author"/>
	</form>-->

	</div>

</body>
</html>