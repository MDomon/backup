<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />

<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/login.css">
<link rel="stylesheet" type="text/css" href="./css/paymentConfirm.css">


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/themes/redmond/jquery-ui.css">
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/i18n/jquery-ui-i18n.min.js"></script>
<script type="text/javascript" src="./js/autocomplete.js"></script>
<title>PaymentConfirm画面</title>



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

	<div id="main">
		<div class="wrapper clearfix">
			<div class="main-left">
			<h2>購入商品</h2>
				<s:iterator value="#session.productDTOList">
					<div class="purchase-list">
						<div class="item clearfix">
							<div class="img">
								<img src='<s:property value="imageFilePath" />' alt='<s:property value="imageFileName" />' >
							</div>
							<div class="detail">
								<p class="hurigana"><small><s:property value="productNameKana" /></small></p>
								<p class="name"><s:property value="productName" /></p>
								<p class="item-price"><span class="let-space">金額</span><s:property value="price" />円</p>
								<p class="count"><span class="let-space">数量</span><s:property value="productCount" />個</p>
								<p class="item-price"><span class="let-space">合計</span><s:property value="totalPrice" />円</p>
								<p class="company"><span class="let-space">販売元</span><s:property value="releaseCompany" /></p>
								<p class="release-date"><span class="let-space">発売日</span><s:property value="releaseDate" /></p>
							</div>
						</div>
					</div>
				</s:iterator>
			</div>

			<div class="main-right">
				<table class="myPage">
					<s:iterator value="#session.paymentUserInfoDTO">
						<tr>
							<th>ユーザーID</th>
							<td><s:property value="userId" />&thinsp;&thinsp;</td>
						</tr>
						<tr>
							<td class="bar" colspan="6"></td>
						</tr>

						<tr>
							<th>氏名</th>
							<td><s:property value="familyName" />&thinsp;&thinsp;<s:property
									value="firstName" /></td>
						</tr>
						<tr>
							<td class="bar" colspan="6"></td>
						</tr>

						<tr>
							<th>ふりがな</th>
							<td><s:property value="familyNameKana" />&thinsp;&thinsp;&thinsp;<s:property
									value="firstNameKana" /></td>
						</tr>
						<tr>
							<td class="bar" colspan="6"></td>
						</tr>

						<tr>
							<th>性別</th>
							<td><s:if test="sex == 0">男性</s:if> <s:if test="sex == 1">女性</s:if></td>
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

						<s:if test='<s:property value="#session.telNumber" /> '>
							<tr>
								<th>電話番号</th>
								<td><s:property value="#session.telNumber" /></td>
							</tr>
							<tr>
								<td class="bar" colspan="6"></td>
							</tr>

							<tr>
								<th>住所</th>
								<td><s:property value="#session.choicedAddress" />&thinsp;&thinsp;</td>
							</tr>
							<tr>
								<td class="bar" colspan="6"></td>
							</tr>
						</s:if>
					</s:iterator>
					<tr>
						<th>支払い方法</th>
						<td>
							<s:if test='#session.payMethod == "0" '>
								クレジットカード
							</s:if>
							<s:if test='#session.payMethod == "c" '>
								現金
							</s:if>
						</td>
					</tr>
							<tr>
								<td class="bar" colspan="6"></td>
							</tr>
					<tr>
						<th>合計金額</th>
						<td>
							<div class= "price"><s:property value="#session.sumPrice" />&thinsp;&thinsp;円</div>
						</td>
					</tr>
					<tr>
						<td class="bar" colspan="6"></td>
					</tr>
				</table>
				<div class="mypage-button">
					<p class="sub-btn"><a class="page1" href='<s:url action="PaymentCompleteAction" />'>購入完了</a></p>
					<p class="link-btn"><a id="page" href='<s:url action="DestinationCreateAction" />'>宛先登録はこちらから</a></p>
					<p class="link-btn"><a id="page" href='<s:url action="PaymentAddressChoiceAction" />'>前のページへ戻る</a></p>
				</div>
			</div>
		</div>
	</div>






	<footer>© 2017-2018, Sagaone.com</footer>

	<form name="form_test">
		<input type="hidden" name="input_test" value="<s:iterator value="#session.allWordsList" ><s:property /></s:iterator>">
	</form>

</body>
</html>