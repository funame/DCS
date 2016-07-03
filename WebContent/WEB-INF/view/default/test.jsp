<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">


<%@ page isELIgnored="false"%>
	<head>
		<title>Hello World with Spring 3 MVC</title>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
	</head>
	<body>

	
	Balance: ${UserCard.balance}<br/>
    Card code:${UserCard.card.code}<br/>
    Card type name:${UserCard.card.cardType.name}<br/>
   

    <c:forEach items="${Report}" var="data">

       userCard.balance-----${data[0].balance}<br>
       order.date---------${data[1].odate}"<br>
       orderDetail.gcount---------${data[2].gcount}<br>
       good.name---------${data[3].name}<br>
       card.code---------${data[4].code}<br>
       cardType.name---------${data[5].name}<br>

</c:forEach>



	</body>
</html>