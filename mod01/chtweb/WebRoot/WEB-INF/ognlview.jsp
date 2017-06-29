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

<title>My JSP 'ognlview' starting page</title>

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
	ognldemo.
	<br> ${msg}
	<br>
	<!-- 使用OGNL EL -->
	OGNL EL:
	<s:property value="#attr.msg"></s:property>
	<br> EL算術運算:10*20-5:${10*20-5}
	<br> Struts算術運算:10*20-5:
	<s:property value="%{10*20-5}" />
	<br> EL Model:${country}
	<br> 國家別:
	<s:property value="country" />
	<br>

	<fieldset>
		<legend>客戶資料</legend>
		<table>
			<tr>
				<td>客戶編號:</td>
				<td><s:property value="customers.customerid" />
			</tr>
			<tr>
				<td>公司名稱:</td>
				<td><s:property value="customers.companyname" />
			</tr>
			<tr>
				<td>聯絡地址:</td>
				<td><s:property value="customers.address" />
			</tr>
			<tr>
				<td>連絡電話:</td>
				<td><s:property value="customers.phone" />
			</tr>
		</table>
	</fieldset>
</body>
</html>
