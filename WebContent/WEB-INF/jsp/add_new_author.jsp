<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="add-form" method="post" action="mmm">
 		<input type="hidden" name="command" value="add_author"/>
		Name Author:<br/>
		<input type="text" name="authorName" value=""/><br/>
		Country's author:<br/>
		<input type="text" name="country" value=""><br/>
 		<input type="submit" value="Add Author"/>
	</form>

</body>
</html>