<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
<title><fmt:message key="title"/> </title>
</head>
<body>
	<h1><fmt:message key="heading"/> </h1>
	<br>
	<p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
	<h3>Account</h3>
	
</body>
</html>