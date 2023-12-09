<%@ page language="java" isELIgnored='false' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<center>
		<h1 style="color: blue; align-content: center;">STUDENT RECORDS</h1>
	
		<c:choose>
		
			<c:when test="${studentVO ne null || !empty studentVO}">
				<table border="1" style="align-items: center;">
					<tr>
						<th>SID</th>
						<th>SNAME</th>
						<th>SAGE</th>
						<th>SADDRESS</th>
					</tr>
					
					<c:forEach items="${studentVO}" var="std">
						<tr>
							<td>${std.sid}</td>
							<td>${std.sname}</td>
							<td>${std.sage}</td>
							<td>${std.saddress}</td>
						</tr>
					</c:forEach>
					
				</table>
			</c:when>	
			
			<c:otherwise>
					<h1 style="color: red; align-items: center;">No Records To Display</h1>
			</c:otherwise>
		</c:choose>
	</center>
	
</body>
</html>