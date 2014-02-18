<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h2>Simple CRUD using Spring MVC and MongoDB.</h2>

		<form action="car/save" method="post">
			<input type="hidden" name="id">
			<label for="name">Car Name</label>
			<input type="text" id="name" name="name"/>
			<input type="submit" value="Submit"/>
		</form>

	<table border="1">
		<c:forEach var="car" items="${carList}">
			<tr>
				<td>${car.name}</td><td><input type="button" value="delete" onclick="window.location='car/delete?id=${car.id}'"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>