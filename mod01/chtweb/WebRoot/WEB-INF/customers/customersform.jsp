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

<title>My JSP 'customersform.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	//選擇器
	$(document).ready(
	//匿名事件
	function() {
		alert("hello jquery!!")
	});
</script>
</head>

<body>
	init-method="selectInitializer"未定義
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
	<br>
	<!-- struts ognl form field layout -->
	<s:form>
		<s:textfield label="客戶號碼" name="customerid" value="%{customerid}">客戶編號</s:textfield>
		<s:submit label="查詢" value="查察"></s:submit>
	</s:form>
	<s:property value="message" />
	<br>
</body>
</html>
