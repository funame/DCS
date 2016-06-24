<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
  
<script>
function send(){
alert("sss");
$.ajax({
                        type: "GET",
                        url: "${contextURL}/GetName",
                        data: {name:"Fuad"},
                        cache: false,
                        success: function(responce){
                         alert(responce);
							}
		                      });
}
</script>	                 
		<h1>Welcome! Spring MVC is working well.</h1><br />
		${HelloMessage}
		
<button onclick="send()" value="Test Ajax">ff</button>
	</body>
</html>