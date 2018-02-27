<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta name="description" content="本の交換フリーマーケットサイトです。" />
		<meta name="keywords" content="本,古本,中古本,フリマ,フリーマーケット" />
		<title>ホームページ</title>
		<link rel="stylesheet" href="./css/normalize.css" >
		<link rel="stylesheet" href="./css/bookDetail.css" >
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
                    <s:form action="BookSearchAction" theme="simple">
                        <input type="search" name="searchWord" class="searchText">
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
                        	<s:if test="#session.user_id != null"><a href='<s:url action="LogoutAction" />'>ログアウト</a></s:if>
							<s:if test="#session.user_id == null"><a href='<s:url action="GoLoginAction" />'>ログイン</a></s:if></li>
                        <li class="current"><a href='<s:url action="UserCreateAction" />'>新規会員登録</a></li>
                    </ul>
                </nav>
                <br>
            </header>
                      <div id="pageBody">
                <div id="pageBodyMain">
                    <article class="articleDetail">
                        <div id="main">

                        </div>


                            <section class="bookList">
		                        <h1 class="pageTitle">Book詳細</h1>

									<div class="box">
											<div class="bookImg">
												<p><img src="images/iconBook.png" alt="" width="90" height="90"></p>
											</div>
											<div class="bookInfo">
												<p>ユーザー名:<s:property value="#session.book_user_name" /></p>
												<p>著書名:<s:property value="#session.book_name" /></p>
												<p>著者名:<s:property value="#session.book_author_name" /></p>
												<p>コメント:<s:property value="#session.book_infomation" /></p>
												<p>登録日:<s:property value="#session.book_date" /></p>
											</div>
											<s:if test="#session.masterId != #session.book_master_id && #session.masterId != null">
											<div class="bookButton">
												<s:form action="BookShareConfirmAction">
													<s:token/>
													<s:submit value="購入する" />
												</s:form>
											</div>
											</s:if>
									</div>

		                    </section>

                    </article>
                </div>

            </div>
            <p class="pageTop"><a href="#page">ページの先頭へ戻る</a></p>
            <footer id="pageFoot">
                <p id="copyright"><small>Copyright&copy; 2018 @BookShare All Rights Reserved.</small></p>
            </footer>
        </div>
	</body>
</html>