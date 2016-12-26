<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="by.bsu.extask.to.ReaderData"%>
<%@ page import="by.bsu.extask.to.DeliveryList"%>
<%@ page import="by.bsu.extask.to.DeliveryData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
   <%@include file='/WEB-INF/css/info_about_reader.css' %>
   <%@include file='/WEB-INF/css/meadia_scree_reader.css' %>
</style>

<body>
	<div class="header">
		<p class="sirius">Сириус</p>
		<p class="library">Библиотека</p>
	</div>

	<%
		//ReaderData reader = (ReaderData) session.getAttribute("login");
	%>
	<p class="reader"><%=session.getAttribute("login")%></p>
	
<!--<form name="edition-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="list_books"/>
 		<input type="hidden" name="login" value="<%=session.getAttribute("login")%>">
 		<input type="submit" value="List books"/>
</form>-->
<div class="arrears">
<p class="title">Задолженности:</p>
<table>
	<tr class="border_bottom">
					<!--<td class="width">Ваш номер</td>-->
					<td class="width">Номер издания</td>
					<td class="width">Дата выдачи</td>
					<td class="width">Количество дней</td>
					<td class="width">Прошедшая дата возврата</td>
	</tr>
		<%
			DeliveryList deliveryArrears = (DeliveryList)request.getAttribute("deliveryListArrears");
			for(DeliveryData delivery : deliveryArrears.deliveryList){
		%>
		<tr class="text_table">
			<!--<td><%//=delivery.idreader%></td>-->
			<td><%=delivery.idedition%></td>
			<td><%=delivery.dateDelivery%></td>
			<td><%=delivery.timeReturn%></td>
			<td><%=delivery.dateReturn%></td>
		</tr>
		<%
			}
		%>		
	</table>
</div>


</br>
<div class="arrears">
<p class="title">Список книг на руках:</p>
<table>
	<tr class="border_bottom">
			<!--<td>Ваш номер</td>-->
			<td>Номер издания</td>
			<td>Дата выдачи</td>
			<td>Количество дней</td>
			<td>Дата возврата</td>
		</tr>
		<%
			DeliveryList deliverys = (DeliveryList)request.getAttribute("deliveryList");
			for(DeliveryData delivery : deliverys.deliveryList){
		%>
		<tr>
			<!--<td><%//=delivery.idreader%></td>-->
			<td><%=delivery.idedition%></td>
			<td><%=delivery.dateDelivery%></td>
			<td><%=delivery.timeReturn%></td>
			<td><%=delivery.dateReturn%></td>
			<!--<td>
				<form name="pass-form" method="post" action="mmm">
						<input type="hidden" name="idreader" value="<%//=delivery.idreader%>">
						<input type="hidden" name="idedition" value="<%//=delivery.idedition%>">
						<input type="hidden" name="command" value="pass_edition"/>
 						<input type="submit" value="Pass"/>
				</form>
			</td>-->
		</tr>
		<%
			}
		%>		
	</table>
</div>

</br>
<div class="arrears">
<p class="title">Прочитанные книги:</p>
<table>
	<tr class="border_bottom">
			<!--<td class="width">Ваш номер</td>-->
			<td class="width">Номер издания</td>
			<td class="width">Дата выдачи</td>
			<td class="width">Количество дней</td>
			<td class="width">Дата возврата</td>
	</tr>
		<%
			DeliveryList deliveryPass = (DeliveryList)request.getAttribute("deliveryListPass");
			for(DeliveryData delivery : deliveryPass.deliveryList){
		%>
		<tr>
			<!--<td><%=delivery.idreader%></td>-->
			<td><%=delivery.idedition%></td>
			<td><%=delivery.dateDelivery%></td>
			<td><%=delivery.timeReturn%></td>
			<td><%=delivery.dateReturn%></td>
		</tr>
		<%
			}
		%>		
	</table>	
</div>

</body>
</html>