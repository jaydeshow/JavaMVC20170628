<%@ page language="java" import="java.util.*, com.cht.entity.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'countrylist.jsp' starting page</title>

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
	countryquery
	<br> msg: ${msg}
	<br> data: ${data[0].country}
	<!-- 走訪 foreach -->
	<%
		//dispatcher 
		List<Country> datas = (List<Country>) request.getAttribute("data");
		//區域變數無法做  EL，做成pageContext參考屬性
		request.setAttribute("datas", datas);
	%>
	<table style="width:100%" border="1">
		<tr>
			<td>編號</td>
			<td>國家別</td>
			<td>最後更新時間</td>
		</tr>
		<c:forEach items="${datas}" var="country">
			<tr>
				<td>${country.country_id}</td>
				<td>${country.country}</td>
				<td>${country.last_update}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
