<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr><td>ID</td><td>姓名</td><td>年龄</td><td>性别</td></tr>
	<c:forEach items="${students}" var="student" >
	<tr>
		<td>${student.id}</td> <td>${student.name}</td> <td>${student.age}</td> <td>${student.sex==1?'男':'女' }</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>