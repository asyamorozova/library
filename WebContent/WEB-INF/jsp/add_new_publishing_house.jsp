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
 		<input type="hidden" name="command" value="add_publishing_house"/>
		Name Publishing House:<br/>
		<input type="text" name="houseName" value=""/><br/>
		City's publishing house:<br/>
		<input type="text" name="city" value=""><br/>
 		<input type="submit" value="Add Publishing House"/>
	</form>

</body>
</html>