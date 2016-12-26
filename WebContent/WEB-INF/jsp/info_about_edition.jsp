<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="by.bsu.extask.to.EditionData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>
   <%@include file='/WEB-INF/css/info_about_edition.css' %>
</style>

<body>

<div class="header">
		<p class="sirius">Сириус</p>
		<p class="library">Библиотека</p>
	</div>

<%
				EditionData edition = (EditionData)request.getAttribute("infoAboutEdition");
				//for(ReaderData reader : readers.readerList){
			%>

<p class="edition">Издание: </p>
<p class="edition" style="margin-top:-15px;">Номер места: <%=edition.idPlace%>, номер полки: <%=edition.numRack%>, номер стеллажа: <%=edition.numRackLittle%></p>
<div class="img">
	<img src="<%=edition.wayIMG%>" width = "400px" height = "400px" />
</div>	
	
	<table>
		<tr>
			<td class="rotstyp">Название</td>
			<td class="otstyp">Имя</td>
		</tr>
		<tr>
			<td class="rotstyp">Номер издания</td>
			<td class="otstyp"><%=edition.idedition%></td>
		</tr>
		<tr>
			<td class="rotstyp">Автор</td>
			<td class="otstyp"><%=edition.authorName%></td>
		</tr>
		<tr>
			<td class="rotstyp">Жанр</td>
			<td class="otstyp"><%=edition.characterName%></td>
		</tr>
		<!--<tr>
			<td class="rotstyp">Annotation</td>
			<td class="otstyp"><//=edition.annotation%></td>
		</tr>-->
		<tr>
			<td class="rotstyp">Язык</td>
			<td class="otstyp"><%=edition.languageName%></td>
		</tr>
		<tr>
			<td class="rotstyp">Издательство</td>
			<td class="otstyp"><%=edition.houseName%></td>
		</tr>
		<tr>
			<td class="rotstyp">Переплет</td>
			<td class="otstyp"><%=edition.bindingName%></td>
		</tr>
	</table>
		<p><%//=edition.idedition%> <%//=edition.language%> <%//=edition.binding%> <%//=edition.series%> <%//=edition.author%> <%//=edition.character%></p>
		
		<p>   <%//=edition.series%>  </p>
		
		<%
			//}
		%>
<div class="annotation">
	<p style="font-weight:bold;">Аннотация</p>
	<p style="margin-top:-10px;"><%=edition.annotation%></p>
</div>

</body>
</html>