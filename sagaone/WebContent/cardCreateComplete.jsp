<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel= "stylesheet" type= "text/css" href= "./css/login.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">

<title>クレジットカード登録完了</title>
<style type="text/css">
		#title{
			height: 100px;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		input[type="button"]{
			background: #4B99AD;
		    padding: 8px 15px 8px 15px;
		    border: none;
		    color: #fff;
		}
</style>
</head>
<body>
	<header>
		<div id="main-logo">
			<a href=' <s:url action= "GoHomeAction" /> '><img src="./img/sagaone_logo.png" height="100px"></a>
		</div>
		<div id="title">クレジットカード登録完了</div>
	</header>
	<div id="main">
		<h3>クレジットカードの登録が完了致しました。</h3>
		<s:if test='fromPayment == "1"'>
			<div>
				<s:form action="PaymentAction">
					<input type="hidden" name="adNum" value="#session.adNum" />
					<s:submit value="決済画面へ" cssClass="page" />
				</s:form>
			</div>
		</s:if>
		<div>
			<input type="button" onclick="location.href=' <s:url action= "MyPageAction" />'" value="マイページへ">
		</div>
	</div>

	<footer>© 2017-2018, Sagaone.com</footer>
</body>
</html>