<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SiteEV" %>
<%
SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>湊くんのページ</title>
</head>
<body>
	<h1>湊くんのページへようこそ</h1>
	<p>
	<a href="/LikeDislike/MinatoIndex?action=like">いいね</a>:
	<%= siteEV.getLike() %>人
	<a href="/LikeDislike/MinatoIndex?action=dislike">いくないね</a>:
	<%= siteEV.getDislike() %>人
	</p>

</body>
</html>