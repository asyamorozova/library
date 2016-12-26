<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="reader-form" method="post" action="mmm">
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
	</form>

</body>
</html>