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
<!-- 進行ajax invoke server-side REST Service -->
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
	//選擇器
	$(document).ready(
	//匿名事件
	function() {
		//alert("hello jquery!!")
		//選擇id jquery 支援 ajax
		$('#btnValid').click(
		//事件程序
		function() {
			alert("click!!")
		});
	});
</script>
</head>

<body>
	<h2>客戶資料維護</h2>
	<br>
	<s:property value="dataSource" />
	<br>
	<fieldset>
		<legend>客戶新增作業</legend>
		<s:form action="customers/save.action">
			<table style="width:100%">
				<tr>
					<td>客戶編號</td>
					<td><s:textfield name="customers.customerid"
							style="width:200px"></s:textfield> <input type="button"
						value="驗證客戶編號..." /></td>
					<td><input type="button" value="驗證客戶編號...2" id="btnValid" /></td>
				</tr>
				<tr>
					<td>公司名稱</td>
					<td><s:textfield name="customers.companyname"
							style="width:200px"></s:textfield></td>
				</tr>
				<tr>
					<td>聯絡地址</td>
					<td><s:textfield name="customers.address"
							cssClass="inputwidth"></s:textfield></td>
				</tr>
				<tr>
					<td>連絡電話</td>
					<td><s:textfield name="customers.phone" cssClass="inputwidth"></s:textfield></td>
				</tr>
				<tr>
					<td>地區</td>
					<td><s:select list="alias" name="customers.aliasid" label="區域"
							listValue="alias" listKey="aliasid" value="1" headerKey="-1"
							headerValue="--請挑選--"></s:select></td>
				</tr>

			</table>
			<s:submit value="傳送" ></s:submit>
		</s:form>
	</fieldset>

	<s:property value="alias" />
</body>
</html>
