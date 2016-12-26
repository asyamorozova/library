<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>

<%@ page import="java.awt.image.*" %>

<%@ page import="by.bsu.extask.to.ReaderList"%>
<%@ page import="by.bsu.extask.to.ReaderData"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>
   <%@include file='/WEB-INF/css/style_default.css' %>
   <%@include file='/WEB-INF/css/media_screen.css' %>
</style>

<script type="text/javascript">
 
            //Функция показа
    function show(id, tid){
    	 	var windowClassElements = document.querySelector(id);
    	 	var windowClassElementsTwo = document.querySelector(tid);
         	windowClassElements.classList.toggle('hidden');
         	windowClassElementsTwo.classList.toggle('hidden');
    }
     
</script>

<body>
	<div class="header">
		<div  style="text-align:center;">
			<!--<p style="color:white; font-size:28px; font-weight:bold; font-family:Tahoma;">Sirius</p>
			<p style="color:white; font-size:22px; font-weight:bold; font-family:Tahoma;">Library</p>-->
			<h1>Сириус</h1>
			<h2>Библиотека</h2>
		</div>
		
		<!--<div style="clear:both;">
			<a style="color:white; font-size:18px; font-family:Tahoma;" href="">Enter/Regestration</a>
		</div>-->
		<!--<img src="D:/IMG/space_header.jpg" width="100%" height="200" />-->
	</div>
	
	<div class="form">
		<ul>
			<li class="selected"><button class="change">Вход</button></li>
			<!--<li><button class="change" onclick="show('.form2','.form')">Регистрация</button></li>-->
		</ul>
		<div class="indent">
		<form style="margin-top:70px;" name="login-form" method="post" action="mmm">
			<input type="hidden" name="command" value="login" />
			<p class="enter" style="margin-top:40px;">Логин:</p><br/>
			<input class="enter_form" required type="text" name="login" value=""/><br/>
			<p class="enter" style="margin-top:30px;">Пароль:</p><br/>
			<input class="enter_form" required type="password" name="password" value=""><br/>
			<input id = "button" type="submit" value="Войти"/>
		</form>
		</div>
		</div>
		
		<div class="form2 hidden">
		<ul>
			<li><button class="change" onclick="show('.form','.form2')">Войти /</button></li>
			<li class="selected"><button class="change">Регистрация</button></li>
		</ul>
		<div class="indent">
		<form style="margin-top:70px;" name="login-form" method="post" action="mmm">
			<input type="hidden" name="command" value="check_in" />
			<p class="enter" style="margin-top:40px;">Number ticket:</p><br/>
			<input class="enter_form" type="text" name="idreader" value=""/><br/>
			<p class="enter" style="margin-top:40px;">Login:</p><br/>
			<input class="enter_form" type="text" name="login" value=""/><br/>
			<p class="enter" style="margin-top:30px;">Password:</p><br/>
			<input class="enter_form" type="password" name="password" value=""><br/>
			<input id = "button" type="submit" value="Enter"/>
		</form>
		</div>
		</div>
	
	<!--<form name="edition-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="edition"/>
 		<input type="submit" value="Read edition"/>
	</form>-->
	
	<!--<a href="/WEB-INF/jsp/add_edition.jsp">Click me</a>-->
	
	<!--<form action="/WEB-INF/jsp/true.jsp">
    	<button type="submit">Button-link</button>
	</form>-->
	
	<!--<form name="link-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="link"/>
 		<input type="submit" value="Go example"/>
	</form>-->
	
</body>

</html>