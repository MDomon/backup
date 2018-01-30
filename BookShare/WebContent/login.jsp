<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta name="description" content="本の交換フリーマーケットサイトです。" />
		<meta name="keywords" content="本,古本,中古本,フリマ,フリーマーケット" />
		<title>ログインページ</title>
		<link rel="stylesheet" href="./css/normalize.css" >
		<link rel="stylesheet" href="./css/style.css" >
        <link rel="stylesheet" href="./css/form.css" >
	</head>
    <body>
        <div id="page">
            <header id="pageHead">
                <h1 id="siteTitle">
                    <a href='<s:url action="GoHomeAction" />'><img src="images/iconBook.png" alt="" width="90" height="90"></a>
                    BookShare
                </h1>
                <p id="catchcopy">本の交換フリーマーケットサイト</p>
                <br>
                <div class=border></div>
            </header>

	<div id="main">
		<div id="top">
			<p>ログイン画面</p>
		</div>
		<div>
			 <table>
                    <s:form action="LoginAction">
                        <tr>
                            <td>
                                <label>ログインID:</label>
                            </td>
                            <td>
                                <input type="text" name="loginUserId" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>ログインPASS:</label>
                            </td>
                            <td>
                                <input type="text" name="loginPassword" value="" />
                            </td>
                        </tr>
                        <s:submit value="ログイン"/>
                    </s:form>
                    </table>
			<div id="com">
				<p>新規会員登録は<a href='<s:url action="UserCreateAction" />'>こちら</a></p>
				<p>ホームページは<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
	</div>

	<footer id="pageFoot">
                <p id="copyright"><small>Copyright&copy; 2018 @BookShare All Rights Reserved.</small></p>
            </footer>
        </div>
	</body>
</html>