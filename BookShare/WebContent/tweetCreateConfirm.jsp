<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta name="description" content="本の交換フリーマーケットサイトです。" />
		<meta name="keywords" content="本,古本,中古本,フリマ,フリーマーケット" />
		<title>つぶやき確認ページ</title>
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
					<p>つぶやき内容は以下でよろしいですか。</p>
				</div>
				<div>
					<table>
						<s:form action="TweetCreateAction">
							<tr id="box">
								<td>
									<label>つぶやき内容:</label>
								</td>
								<td>
									<s:property value="tweet_message" escape="false" />
								</td>
							</tr>
							<tr>

									<s:submit value="完了" />

							</tr>
						</s:form>
					</table>
				</div>
			</div>


			<footer id="pageFoot">
                <p id="copyright"><small>Copyright&copy; 2018 @BookShare All Rights Reserved.</small></p>
            </footer>
        </div>
	</body>
</html>



