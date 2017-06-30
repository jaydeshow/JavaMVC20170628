<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- html5.0 -->
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'customersmaintform.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.inputwidth {
	width: 400px;
	background-color: yellow;
}
</style>
</head>

<body>
	<h2>客戶資料維護</h2>
	<br>
	<s:property value="dataSource" />
	<br>
	<fieldset>
		<legend>客戶新增作業</legend>
		<table style="width:100%">
			<tr>
				<td>客戶編號</td>
				<td><s:textfield name="customers.customerid"
						style="width:200px"></s:textfield></td>
			</tr>
			<tr>
				<td>公司名稱</td>
				<td><s:textfield name="customers.companyname"
						style="width:200px"></s:textfield></td>
			</tr>
			<tr>
				<td>聯絡地址</td>
				<td><s:textfield name="customers.address" cssClass="inputwidth"></s:textfield></td>
			</tr>
			<tr>
				<td>連絡電話</td>
				<td><s:textfield name="customers.phone" cssClass="inputwidth"></s:textfield></td>
			</tr>
			<tr>
				<td>地區</td>
				<td></td>
			</tr>

		</table>
	</fieldset>
	
	<s:property value="alias" />
</body>
</html>
