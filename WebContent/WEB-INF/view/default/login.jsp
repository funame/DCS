<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form method="get">
<spring:message code="label.login" />
<input type="text" name="login" value="admin"/>
<spring:message code="label.password" />
<input type="text" name="pass" value="123"/>
<input type="submit" name="ok" value='<spring:message code="button.login" />'/>
</form>

<%--  <spring:message code="${ErrorKey}" arguments="${ErrorArg}"/> --%>
