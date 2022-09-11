<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Employee Reg</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<form:form method="POST" action="/addEmployee"
		modelAttribute="employee">

		<table>
			<tr>
				<td><form:input path="name" placeholder="name" /></td>
			</tr>
			<tr>
				<td><form:input path="email" placeholder="email" type="email" /></td>
			</tr>
			<tr>
				<td>
					<div class="g-recaptcha" data-sitekey="${recaptchaSitekey}"></div>
				</td>
			</tr>
			<c:if test="${message ne null}">
				<p style="color: red">${message}</p>
			</c:if>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>