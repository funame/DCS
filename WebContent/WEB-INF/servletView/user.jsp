<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>that is index.jsp file in Web-INF/servletView</h1>
${Name}----data from servlet
<br/>
<c:out value="hello world"></c:out>---jstl is working

<hr/>
<table  border='1'>

<c:forEach items="${Users}" var="data">
<tr>
 <td><c:out value="${data.name}"></c:out></td>
 <td><c:out value="${data.phone}"></c:out></td>
 <td><c:out value="${data.id}"></c:out></td>
 </tr>
</c:forEach>
</table>
</body>
</html>