<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><fmt:message key="title"/></title>
		<style>
			.error { color: red; }
		</style>
	</head>
	<body>
		<h1><fmt:message key="deletetitular.heading"/></h1>
		<hr>
		<form:form method="post" commandName="dniData">
			<table width="95%" bgcolor="f8f8ff" border="0" cellSpacing="0" cellpadding="5">
			<tr>
			<td align="right" width="20%">Introduce the DNI :</td>
				<td width="20%">
					<form:input path="dni"/>
				</td>
				<td width="60%">
					<form:errors path="dni" cssClass="error"/>
				</td>	
			</tr>
			</table> 
			<br>
			<input type="submit" value="Delete">
		</form:form>
	</body>
</html>