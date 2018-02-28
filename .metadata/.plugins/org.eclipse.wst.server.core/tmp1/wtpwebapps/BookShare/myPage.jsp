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
            </header>
            <div id="main">

                                <h2 class="heading-typeA"><s:property value="#session.userName"/>さんのマイページ！</h2>

                        </div>

            <div id="pageBody">
                <div id="pageBodyMain">
                    <article class="articleDetail">

						<header class="articleDetailHead">
                            <h1 class="pageTitle">アカウント情報</h1>
                            <div>
                            	<p><img src="images/iconMan.png" alt="" width="90" height="90"></p>
                            	<ul>
	                            	<li>ユーザーネーム:<s:property value="#session.userName"/></li>
	                            	<li>Bookcoin:<s:property value="#session.bookcoin"/>枚</li>
	                            	<li>譲った本の数:<s:property value="#session.giveBook"/>冊</li>
	                            	<li>譲り受けた本の数:<s:property value="#session.takeBook"/>冊</li>
	                            	<br>
	                            	<a href='<s:url action="BookCreateAction" />'>本の登録</a>
                            	</ul>
                            </div>

                        </header>
                        <header class="articleDetailHead">
                            <section class="bookList">
		                        <h1 class="pageTitle">出品中の本リスト</h1>
		                        		<s:if test="message4 != null">
											<h3><s:property value="message4"/></h3>
										</s:if>
										<br>
										<s:iterator value="bookList">
										 	<div class="box">
												<div class="bList">
													<p><img src="images/iconBook.png" alt="" width="90" height="90"></p>
													<p>著書名:<s:property value="book_name" /></p>
													<p>著者名:<s:property value="book_author_name" /></p>
													<p><s:form action="MyPageAction">
														<input type="hidden" name="deleteBook" value="1"/>
														<input type="hidden" value="<s:property value='book_id' />" name="bookId" />
														<s:submit value="削除" method="remove4" />
														</s:form></p>
												</div>
											</div>
										</s:iterator>
		                    </section>
                        </header>
                        <header class="articleDetailHead">
                            <section class="bookList">
		                         <h1 class="pageTitle">受け取った本リスト</h1>
										<s:iterator value="takeBookList">
										<div class="box">
												<div class="bList">
													<p><img src="images/iconBook.png" alt="" width="90" height="90"></p>
													<p>著書名:<s:property value="book_name" /></p>
													<p>著者名:<s:property value="book_author_name" /></p>
												</div>
										</div>
										</s:iterator>
		                    </section>
                        </header>
                        <header class="articleDetailHead">
                        	<section class="bookList">
		                         <h1 class="pageTitle">譲った本リスト</h1>
										<s:iterator value="giveBookList">
												<div class="bList">
													<p><img src="images/iconBook.png" alt="" width="90" height="90"></p>
													<p>著書名:<s:property value="book_name" /></p>
													<p>著者名:<s:property value="book_author_name" /></p>
												</div>
										</s:iterator>
		                    </section>
                        </header>
                    </article>
                </div>
                <div id="pageBodySub">
                    <section class="newList">
                        <h1><s:property value="#session.userName"/>さんのつぶやき</h1>
                        <s:form action="TweetCreateConfirmAction" theme="simple">
                        	<s:textarea class="textarea" key="tweet_message"/>
							<s:submit class="button" value="つぶやく"/>
						</s:form>
						<br>
							<s:if test="message2 != null">
								<h3><s:property value="message2"/></h3>
							</s:if>
								<table border="1">
								<tr>
									<th>つぶやき</th>
									<th>投稿日</th>
								</tr>
								<s:iterator value="tweetList">
									<tr>
										<td><s:property value="tweet_message" /></td>
										<td><s:property value="tweet_date" /></td>
										<td><s:form action="MyPageAction">
											<input type="hidden" name="deleteTweet" value="1">
											<input type="hidden" value="<s:property value='tweet_id' />" name="tweetId" />
											<s:submit value="削除" method="remove2" />
											</s:form></td>
									</tr>
								</s:iterator>
								</table>
                    </section>
                </div>
            </div>
            <p class="pageTop"><a href="#page">ページの先頭へ戻る</a></p>
            <footer id="pageFoot">
                <p id="copyright"><small>Copyright&copy; 2018 @BookShare All Rights Reserved.</small></p>
            </footer>
        </div>
	</body>
</html>
