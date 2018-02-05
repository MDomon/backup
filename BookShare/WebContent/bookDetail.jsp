<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta name="description" content="本の交換フリーマーケットサイトです。" />
		<meta name="keywords" content="本,古本,中古本,フリマ,フリーマーケット" />
		<title>マイページ</title>
		<link rel="stylesheet" href="./css/normalize.css" >
		<link rel="stylesheet" href="./css/style.css" >
	</head>
    <body>
        <div id="page">
            <header id="pageHead">
                <h1 id="siteTitle">
                    <a href='<s:url action="GoHomeAction" />'><img src="images/iconBook.png" alt="" width="90" height="90"></a>
                    BookShare
                </h1>
                <p id="catchcopy">本の交換フリーマーケットサイト</p>
                <div class="searchContainer">
                    <s:form action="SearchAction" theme="simple">
                        <input type="search" name="searchText" class="searchText">
                        <s:submit value="検索" class="textSearchSubmit"/>
                    </s:form>
		        </div>
		        <br>
		        <br>
                <nav class="globalNavi">
                    <ul>
                        <li class="current"><a href='<s:url action="GoHomeAction" />'>ホーム</a></li>
                        <li class="current"><a href='<s:url action="MyPageAction" />'>マイページ</a></li>
                        <li class="current">
                        	<s:if test="#session.id != null"><a href='<s:url action="LogoutAction" />'>ログアウト</a></s:if>
							<s:if test="#session.id == null"><a href='<s:url action="GoLoginAction" />'>ログイン</a></s:if></li>
                        <li class="current"><a href='<s:url action="UserCreateAction" />'>新規会員登録</a></li>
                    </ul>
                </nav>
            </header>


                <div id="pageBodyMain">
                    <article class="articleDetail">
                        <div id="main">
                            <section class="articleDetailBody">
                                <h2 class="heading-typeA"><s:property value="#session.userName"/>さんのマイページ！</h2>
                            </section>
                        </div>
						<header class="articleDetailHead">
                            <h1 class="pageTitle">Book情報</h1>
                            <div>
                            	<p><img src="images/iconBook.png" alt="" width="90" height="90"></p>
	                            	<div>著書名:<s:property value="#session.book_name"/></div>
	                            	<div>著者名:<s:property value="#session.book_author_name"/></div>
	                            	<div>コメント:<s:property value="#session.book_infomation"/></div>
	                            	<div>所有者:<s:property value="#session.book_user_name"/>さん</div>
                            </div>
                        </header>
                     </article>
              </div>
            <p class="pageTop"><a href="#page">ページの先頭へ戻る</a></p>
            <footer id="pageFoot">
                <p id="copyright"><small>Copyright&copy; 2018 @BookShare All Rights Reserved.</small></p>
            </footer>
        </div>
	</body>
</html>
