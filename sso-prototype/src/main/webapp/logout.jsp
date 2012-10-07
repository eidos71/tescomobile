<%@ page import="org.springframework.security.AuthenticationException" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%session.invalidate();%>
<head><meta http-equiv="Refresh" content="0;URL=../cas/logout/"></head>
</html>


