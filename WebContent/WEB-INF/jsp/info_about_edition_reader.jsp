<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="by.bsu.extask.to.DeliveryList"%>
<%@ page import="by.bsu.extask.to.DeliveryData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
 function butClick(){
    	document.getElementById('good').style.display = 'none';
    }
</script>

<style>
   <%@include file='/WEB-INF/css/info_about_reader.css' %>
   <%@include file='/WEB-INF/css/media_screen_info.css' %>
</style>

<body>

<div class="header">
		<p class="sirius">Сириус</p>
		<p class="library">Библиотека</p>
	</div>

<%	DeliveryList deliverysS = (DeliveryList)request.getAttribute("deliveryList");
	String login = null;
	for(DeliveryData delivery : deliverysS.deliveryList){
		login = delivery.loginReader;
	}%>
<!--<p class="reader">Список книг читателя <%=login%></p>-->
<form name="link-form" method="post" action="mmm">
 				<input type="hidden" name="command" value="admin_reader_show"/>
 				<input class = "change" type="submit" style="cursor: pointer;" value="Читатели"/>
			</form>

<%int x = 0;
	if(x!=0){
	out.println("Такое издание уже есть у читателя!");%>
		
<% }%>

<p class="please" syle="display:none;"></p>

</br>
<form class = "up" name="add-form" method="post" action="mmm">
	<input id="tform" pattern="[0-9]{0,3}" placeholder="Введите номер издания..." type="text" name="idedition" value=""/><br/>
	<input class = "t" id="tform" pattern="[0-9]{0,2}"  style="margin-top:7px;margin-left:1.5%;" placeholder="Введите количество дней..." type="text" name="timeReturn" value=""/><br/>
	<input type="hidden" name="login" value="<%=login%>">
	<input type="hidden" name="command" value="admin_add_edition_to_reader"/>
 	<input class = "add" type="submit" value="Добавить издание"/>
</form>
</br>

<%
//String example = (String)session.getAttribute("example");
//out.println(example);
if(((String)session.getAttribute("example")).equals("false"))
{ //out.println("Такое издание уже есть у читателя!");}
%>
	<!--<p>Такая книга уже есть у пользователя!</p>-->
	<!--<jsp:include page="/WEB-INF/jsp/edition_false.jsp" />-->
	<div id="good" style="/*margin-top:10%;margin-left:50%; background:white; font-family:Verdana; font-size:20px;*/">
		<p>Данного издания нет в наличии!</p>
		<button onclick="butClick()" style="margin-left:20%; background:black; border:0px;padding-left:10px;padding-right:10px;font-family:Verdana; font-size:20px;color:white;">OK</button>
	</div>
<% 
	}
%>
	<div class="arrears">
		<p class="title">Задолженности:</p>
			<table>
			<tr class="border_bottom">
					<td class="width">Номер читателя</td>
					<td class="width">Номер издания</td>
					<td class="width">Дата выдачи</td>
					<td class="width" id="no">Количество дней</td>
					<td class="width">Дата возврата</td>
			</tr>
			<%
				DeliveryList deliveryArrears = (DeliveryList)request.getAttribute("deliveryListArrears");
				for(DeliveryData delivery : deliveryArrears.deliveryList){
			%>
				<tr class="text_table">
					<td><%=delivery.idreader%></td>
					<td><%=delivery.idedition%></td>
					<td><%=delivery.dateDelivery%></td>
					<td id="no"><%=delivery.timeReturn%></td>
					<td>-</td>
				</tr>
			<%
				}
			%>		
	</table>
</div>

<!--<hr noshade>-->


</br>
<div class="arrears">
	<p class="title">Список книг на руках:</p>
	<table>
		<tr class="border_bottom">
			<td>Номер читателя</td>
			<td>Номер издания</td>
			<td>Дата выдачи</td>
			<td id="no">Количество дней</td>
			<td>Дата возврата</td>
			<td>Сдать</td>
		</tr>
		<%
			DeliveryList deliverys = (DeliveryList)request.getAttribute("deliveryList");
			for(DeliveryData delivery : deliverys.deliveryList){
		%>
		<tr class="text_table">
			<td><%=delivery.idreader%></td>
			<td><%=delivery.idedition%></td>
			<td><%=delivery.dateDelivery%></td>
			<td id="no"><%=delivery.timeReturn%></td>
			<td><%=delivery.dateReturn%></td>
			<td style="background:black;border-bottom: 1px solid white;">
				<form name="pass-form" method="post" action="mmm">
						<input type="hidden" name="idreader" value="<%=delivery.idreader%>">
						<input type="hidden" name="idedition" value="<%=delivery.idedition%>">
						<input type="hidden" name="login" value="<%=login%>">
						<input type="hidden" name="command" value="pass_edition"/>
 						<input class="pass" type="submit" value="Сдать"/>
				</form>
			</td>
		</tr>
		<%
			}
		%>		
	</table>
</div>	

<!--<hr noshade>-->

</br>

<div class="arrears">
<p class="title">Прочитанные книги:</p>
<table>
	<tr class="border_bottom">
			<td class="width">Номер читателя</td>
			<td class="width">Номер издания</td>
			<td class="width">Дата выдачи</td>
			<td class="width" id="no">Количество дней</td>
			<td class="width">Дата возврата</td>
	</tr>
		<%
			DeliveryList deliveryPass = (DeliveryList)request.getAttribute("deliveryListPass");
			for(DeliveryData delivery : deliveryPass.deliveryList){
		%>
		<tr class="text_table">
			<td><%=delivery.idreader%></td>
			<td><%=delivery.idedition%></td>
			<td><%=delivery.dateDelivery%></td>
			<td id="no"><%=delivery.timeReturn%></td>
			<td><%=delivery.dateReturn%></td>
		</tr>
		<%
			}
		%>		
	</table>	
</div>

<!--<hr noshade>-->

</body>
</html>