<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title>My JSP 'queryresult.jsp' starting page</title>

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
	查詢還沒寫.
	<br>
	<s:property value="dataSource" />
	<br>
	<s:property value="customerid" />
	<br>
	<s:property value="customer.customer_id" />
	<br>
	<s:property value="customer.first_name" />
	<br>
	<s:property value="customer.last_name" />
	<br>
	<s:property value="customer.email" />
	<br>
	<s:property value="customer.last_update" />
</body>
</html>
