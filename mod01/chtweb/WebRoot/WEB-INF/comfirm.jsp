<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>OK</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	OK
	<br>
	<!--scriptlet  -->
	<%=(String) request.getAttribute("customerid")%>
	<br>
	<%=(String) request.getAttribute("companyname")%>
	<br />
	<%=(String) request.getAttribute("address")%>
	<br />
	<%=(String) request.getAttribute("phone")%>
</body>
</html>
