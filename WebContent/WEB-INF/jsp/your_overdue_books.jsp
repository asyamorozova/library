<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="by.bsu.extask.to.DeliveryList"%>
<%@ page import="by.bsu.extask.to.DeliveryData"%>
<%@ page import="by.bsu.extask.controller.RequestHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 OVERDUE BOOKS
 
 <table border='1'>
		<%
			DeliveryList deliverys = (DeliveryList)request.getAttribute("yourOverdueBooks");
			for(DeliveryData delivery : deliverys.deliveryList){
		%>
		<tr>
			<td><%=delivery.idedition%></td>
			<td><%=delivery.idreader%></td>
			<td><%=delivery.dateDelivery%></td>
			<td><%=delivery.timeReturn%></td>
			<td><%=delivery.dateReturn%></td>
		</tr>
		<%
			}
		%>
	</table>
 
</body>
</html>