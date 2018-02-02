<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Go PasswordChangeCompleteAction</title>
<meta http-equiv="refresh" content="5;URL=<s:url action='GoHomeAction' />">
</head>
<body>
不正な操作が行われたため処理をキャンセルしました。<br>
<br>
５秒後にホームへジャンプします。<br>
ジャンプしない場合は、下記のＵＲＬをクリックしてください。<br>
<br>
<a href= '<s:url action= "GoHomeAction" />'>ホームへ</a>

</body>
</html>