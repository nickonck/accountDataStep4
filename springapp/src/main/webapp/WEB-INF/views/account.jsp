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
	<p>Overdraft: <c:out value="${model.account.maxOverdraft}"/> </p>
	<br>
	<a href="<c:url value="setoverdraft.htm"/>">New Overdraft</a>
	<br>
	<hr>
	<h3>Titulars:</h3>
	<c:forEach items="${model.account.titulars}" var="titular">
      <c:out value="${titular.dni}"/> <i>name:<c:out value="${titular.name}"/></i><br><br>
    </c:forEach>
    <hr>
	<h3>Authorizeds:</h3>
	<c:forEach items="${model.account.authorizeds}" var="auth">
      <c:out value="${auth.dni}"/> <i>name:<c:out value="${auth.name}"/></i><br><br>
    </c:forEach>
</body>
</html>