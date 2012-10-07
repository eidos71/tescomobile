<%@ page import="org.springframework.security.AuthenticationException" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>Login to CAS failed!</title>
</head>

<body>
<h2>Login to CAS failed!</h2>

<font color="red">
	<%session.invalidate();%>
    Your CAS credentials were cancelled and rejected.<br/><br/>
    Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>

</font>

</body>
</html>
