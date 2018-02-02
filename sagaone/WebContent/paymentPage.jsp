<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />

	<link rel="stylesheet" type="text/css" href="./css/login.css">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<link rel="stylesheet" type="text/css" href="./css/paymentPage.css">

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/themes/redmond/jquery-ui.css">
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/i18n/jquery-ui-i18n.min.js"></script>
<script type="text/javascript" src="./js/autocomplete.js"></script>

	<title>決済画面</title>


</head>

<body>
	<header class="clearfix">
		<div id="main-logo">
			<a href=' <s:url action= "GoHomeAction" /> '><img src="./img/sagaone_logo.png" height="100px"></a>
		</div>
		<div class="clearfix">
			<div id="search-form">
				<s:form action="SearchItemAction">
					<div id="search-box">
						<select name="itemCategory" id="category">
							<option value="0">全てのカテゴリー</option>
							<option value="1">本</option>
							<option value="2">家電・パソコン</option>
							<option value="3">おもちゃ・ゲーム</option>
						</select>
						<input type="text" name="searchWord" id="jquery-ui-autocomplete-input" />
					</div>
					<div class="search-btn">
					<input type="image" src="./img/searchIcon.png" width="20" height="20" class="icon"/>
					</div>
				</s:form>
			</div>
			<div id="header-container">
				<ul id="normal" class="dropmenu">
					<li id="itemmenu">商品カテゴリー&thinsp;<span class="sankaku">▼</span>
						<ul class="item-drop">
							<li>
								<s:form action="SearchItemAction">
									<input type="hidden" name="itemCategory" value="0" />
									<input type="hidden" name="searchWord" value="" />
									<s:submit value="全てのカテゴリー" cssClass="c-btn" />
								</s:form>
							</li>
							<li>
								<s:form action="SearchItemAction">
									<input type="hidden" name="itemCategory" value="1" />
									<input type="hidden" name="searchWord" value="" />
									<s:submit value="本" cssClass="c-btn" />
								</s:form>
							</li>
							<li>
								<s:form action="SearchItemAction">
									<input type="hidden" name="itemCategory" value="2" />
									<input type="hidden" name="searchWord" value="" />
									<s:submit value="家電・パソコン" cssClass="c-btn" />
								</s:form>
							</li>
							<li>
								<s:form action="SearchItemAction">
									<input type="hidden" name="itemCategory" value="3" />
									<input type="hidden" name="searchWord" value="" />
									<s:submit value="おもちゃ・ゲーム" cssClass="c-btn" />
								</s:form>
							</li>
						</ul>
					</li>
					<li id="acountmenu"><span class="drop-topic">アカウントメニュー&thinsp;<span class="sankaku">▼</span></span>
						<ul class="acount-drop">
							<s:if test="#session.loginFlg">
								<li><s:form action="MyPageAction">
										<s:submit value="マイページ" cssClass="b-btn" />
									</s:form>
								</li>
							</s:if>
							<s:if test="#session.loginFlg == false">
								<li><s:form action="LoginPageAction">
										<s:submit value="ログイン画面へ" cssClass="b-btn" />
									</s:form>
								</li>
							</s:if>

							<s:if test="#session.loginFlg">
								<li><s:form action="LogoutAction">
										<s:submit value="ログアウト" cssClass="b-btn" />
									</s:form>
								</li>
							</s:if>

							<s:if test="#session.loginFlg == false">
								<li>
									<s:form action="UserCreateAction">
										<s:submit value="ユーザー登録" cssClass="b-btn" />
									</s:form>
								</li>
							</s:if>

							<li><s:form action="CartAction">
									<s:hidden name="cartFlg" value="1"></s:hidden>
									<s:submit value="カート確認" cssClass="b-btn" />
								</s:form>
							</li>

							<s:if test="#session.loginFlg">
								<li><s:form action="PaymentAction">
										<s:submit value="決済" cssClass="b-btn" />
									</s:form>
								</li>
							</s:if>
						</ul>
					</li>
					<li id="welcome">
						<s:if test="#session.loginFlg" >
							<s:property value="#session.loginUserId" />&nbsp;さんでログイン中
						</s:if>
					</li>
				</ul>
			</div>
		</div>
	</header>


	<!--PaymentAction-->
	<div id="main">
		<div class="subPaymentPage">
			<s:if test="paymentMessage != null">
				<h2 class= "blank">カートに商品が入っていません</h2>

				<s:form action="SearchItemAction">
					<input type="hidden" name="itemCategory" value="0" />
					<input type="hidden" name="searchWord" value="" />
						<center><input type= "submit" value="商品一覧" id= "page" /></center>
								</s:form>
		</s:if>
		</div>

		<s:if test="paymentMessage == null">

		<div style = "text-align: center;">
		<h2>購入者情報</h2>
		</div>

		<table class= "myPage">

			<s:iterator value="session.paymentUserInfoDTO">
				<tr>
					<th>ユーザーID</th>
					<td><s:property value= "userId" />&thinsp;&thinsp;</td>
				</tr>
				<tr>
					<td class="bar" colspan="6"></td>
				</tr>
				<tr>
					<th>氏名</th>
					<td><s:property value="familyName"/>&thinsp;&thinsp;<s:property value="firstName"/></td>
				</tr>
				<tr>
					<td class="bar" colspan="6"></td>
				</tr>
				<tr>
					<th>ふりがな</th>
					<td><s:property value="familyNameKana"/>&thinsp;&thinsp;&thinsp;<s:property value="firstNameKana"/></td>
				</tr>
				<tr>
					<td class="bar" colspan="6"></td>
				</tr>
				<tr>
					<th>性別</th>
					<td>
						<s:if test="sex == 0">男性</s:if>
						<s:if test="sex == 1">女性</s:if>
					</td>
				</tr>
				<tr>
					<td class="bar" colspan="6"></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="email" /></td>
				</tr>
				<tr>
					<td class="bar" colspan="6"></td>
				</tr>
				</s:iterator>
			</table>


					<s:if test='statusFlg == "1"'>
						<div class="address">
							<h2>住所を選択してください</h2>
						</div>
							<s:iterator value="#session.addressDTOList" status="st">
								<div class="address-content clearfix">
									<div>
										<p class="content-head">既定の住所:</p>
									</div>
									<div>
										<p class="content-main"><s:property value="userAddress" /></p>
									</div>
								</div>
								<div class="address-btn clearfix">
									<a class = "page check" href = '<s:url action="PaymentAddressChoiceAction" ><s:param  name="adNum" value="#st.index"/></s:url>'>この住所を使う</a>
									<a class = "page change" href='<s:url action="DestinationAction" />'>住所の変更/登録</a>
								</div>
							</s:iterator>
					</s:if>

				<s:if test='myAddressExist == "1" && statusFlg == "0"'>

					<s:iterator value="#session.addressDTOList" status="st" begin="0" end="0">
						<div class="address-content clearfix">
									<div>
										<p class="content-head">登録済み住所:</p>
									</div>
									<div>
										<p class="content-main"><s:property value="userAddress" /></p>
									</div>
								</div>
								<div class="address-btn clearfix">
									<a class = "page check" href = '<s:url action="PaymentAddressChoiceAction" ><s:param  name="adNum" value="#sta.index"/></s:url>'>この住所を使う</a>
									<a class = "page change" href='<s:url action="DestinationAction" />'>住所の変更/登録</a>
								</div>
					</s:iterator>
				</s:if>

				<s:if test='myAddressExist == "0" && statusFlg == "0"'>
<%-- 					<tr>
						<th>住所</th>
						<td>住所が登録されていません</td>
						<td>
							<a class = "page" href='<s:url action="DestinationCreateAction" />'>宛先登録はこちらから</a>
						</td>
					</tr>
					<tr>
						<td class = "bar" colspan = "6"></td>
					</tr> --%>

									<h2 style="text-align: center;">住所が登録されていません</h2>
								<div class="address-btn clearfix">
									<a class = "page" href='<s:url action="DestinationCreateAction" />' style="margin-left: 210px;">宛先登録はこちらから</a>
								</div>

				</s:if>
		</s:if>
	</div>

	<footer>© 2017-2018, Sagaone.com</footer>

	<form name="form_test">
		<input type="hidden" name="input_test" value="<s:iterator value="#session.allWordsList" ><s:property /></s:iterator>">
	</form>
</body>
</html>