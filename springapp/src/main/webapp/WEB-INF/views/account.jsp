<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
<title><fmt:message key="title"/> </title>
</head>
<body>
	<h1><fmt:message key="heading"/> </h1> <i><c:out value="${model.now}"/></i>
	<hr>
	<h3>Account <c:out value="${model.account.id}"/> </h3>
	<p>Balance: <c:out value="${model.account.balance}"/> &#8364</p>
	<p>Overdraft: <c:out value="${model.account.maxOverdraft}"/> &#8364</p>
	<br>
	<a href="<c:url value="setoverdraft.htm"/>">New Overdraft</a>
	<br>
	<hr>
	<h3>Titulars:</h3>
	<table width="95%" bgcolor="f8f8ff" border="0" cellSpacing="0" cellpadding="5">
	<c:forEach items="${model.account.titulars}" var="titular">
			<tr>
				<td width="20%">
					<c:out value="${titular.dni}"/>	
				</td>
				<td width="60%">
					<i><c:out value="${titular.name}"/></i>
				</td>	
			</tr>
    </c:forEach>
    </table> 
    <br>
	<a href="<c:url value="addtitular.htm"/>">Add titular</a>
	<a href="<c:url value="deletetitular.htm"/>">Delete titular</a>
	<br>
    <hr>
	<h3>Authorizeds:</h3>
	<table width="95%" bgcolor="f8f8ff" border="0" cellSpacing="0" cellpadding="5">
	<c:forEach items="${model.account.authorizeds}" var="auth">
			<tr>
				<td width="20%">
					<c:out value="${auth.dni}"/>	
				</td>
				<td width="60%">
					<i><c:out value="${auth.name}"/></i>
				</td>	
			</tr>
    </c:forEach>
    </table>
    <br>
	<a href="<c:url value="addauthorized.htm"/>">Add authorized</a>
	<a href="<c:url value="deleteauthorized.htm"/>">Delete authorized</a>
	<br>
</body>
</html>