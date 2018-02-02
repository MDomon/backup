<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/searchResult.css">


<title>商品一覧画面</title>
<!-- *******************ここから前頁共通******************* -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/themes/redmond/jquery-ui.css">
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.19/i18n/jquery-ui-i18n.min.js"></script>
<script type="text/javascript" src="./js/autocomplete.js"></script>
<!-- ===================ここまで前頁共通=================== -->

</head>

<body>
<!-- *******************ここから前頁共通******************* -->
	<header class="clearfix">
		<div id="main-logo">
			<a href=' <s:url action= "GoHomeAction" /> '><img src="./img/sagaone_logo.png" height="100px"></a>
		</div>
		<div class="clearfix">
			<div id="search-form">
				<s:form action="SearchItemAction">
					<div id="search-box">
						<select name="itemCategory" id="category">
							<option value="0" <s:if test='itemCategory == "0"'>selected="selected" </s:if> >全てのカテゴリー</option>
							<option value="1" <s:if test='itemCategory == "1"'>selected="selected" </s:if> >本</option>
							<option value="2" <s:if test='itemCategory == "2"'>selected="selected" </s:if> >家電・パソコン</option>
							<option value="3" <s:if test='itemCategory == "3"'>selected="selected" </s:if> >おもちゃ・ゲーム</option>
						</select>
						<input type="text" name="searchWord" id="jquery-ui-autocomplete-input" <s:if test='searchWord != null'>value="<s:property value="searchWord" />"</s:if>/>
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
<!-- ===================ここまで前頁共通=================== -->
	<div id="main">
		<s:if test='addFlg == "1"'>
			<div class="main1">

				<div class="cartitem">
					<s:iterator value="#session.itemdetailCartDTOList">
						<s:form action="ItemDetailAction">

							<div class="check">&#10003;</div>
							<div class="cartitem1">
								<a
									href='<s:url action="ItemDetailAction"><s:param name="product_id" value="StringProductId" /><s:param name="category_id" value="StringCategoryId" /></s:url>'>
									<img src=<s:property value="imageFilePath"/>
									style="width: 90px; height: 90px; border-style: solid; border-color: #999; border-width: 1px;" />
								</a>
							</div>


							<div class="tuika">追加されました！</div>
						</s:form>
					</s:iterator>
					<div class="cartitem2">
						カートの小計 <span id="price" style="font-size: 40px;">&nbsp;&#xA5;&nbsp;&nbsp;<s:property
								value="allPrice" /></span> 円
					</div>
					<div class="cartitem3">

						<form action="CartAction">
							<input type="hidden" name="cartFlg" value="1"> <span
								class="botton1"><input type="submit" class="form-style" value="カート編集へ"></span>
						</form>
						<s:if test="#session.loginFlg">
							<form action="PaymentAction">
								<span class="botton1"> <input type="submit" class="form-style" value="決済へ"></span>

							</form>

						</s:if>

					</div>
				</div>

			</div>
		</s:if>
		<div class="main-0">
			<a href=' <s:url action= "SortSearchAction"><s:param name="itemCategory" value="itemCategory" /><s:param name="searchWord" value="searchWord" /></s:url> '>価格の安い順に並び替え</a>
		</div>

		<div class="main2">
			<div class="items">
				<s:if test="session.searchErrorMessage != ''">
			'&thinsp;<s:property value="searchWord" />&thinsp;'&thinsp;の<s:property
						value="session.searchErrorMessage" />
				</s:if>

				<s:if test="session.searchErrorMessage == ''">
					<s:iterator value="session.searchItemList" status="st">

						<div class="item">
							<div class="aa">
								<a
									href='<s:url action="ItemDetailAction"><s:param name="product_id" value="productId" /><s:param name="category_id" value="categoryId" /></s:url>'>
									<img src=<s:property value="imageFilePath"/>
									style="width: 130px; height: 130px; margin: 10px;">
								</a>
							</div>
							<div class="bb">
								<a
									href='<s:url action="ItemDetailAction"><s:param name="product_id" value="productId" /><s:param name="category_id" value="categoryId" /></s:url>'>
									<span class="a"> <s:property value="productName" /> （ <s:property
											value="productNameKana" /> ）
								</span>
								</a>
							</div>
							<div class="cc">
								<a
									href='<s:url action="ItemDetailAction"><s:param name="product_id" value="productId" /><s:param name="category_id" value="categoryId" /></s:url>'>
									<span id="price">&#xA5;&nbsp;&nbsp;<s:property
											value="priceStr" /></span>
								</a>
							</div>
							<div class="dd">
								<div class="rating">
									<div class="rating-front"
										style="width: calc(<s:property value="avgvalue" />*20%)">★★★★★</div>
									<div class="rating-back">
										★★★★★<span class="count"> (<s:property
												value="countvalue" />件)
										</span>
									</div>


									<span class="balloon2"> 5つ星のうち<s:property
											value="avgvalue" /></span>
								</div>
							</div>
						</div>


					</s:iterator>

					<div class="page">

						<s:iterator value="pageNumList" status="sta">
							<s:if test='%{#sta.index==nowPage}'>
								<s:property />
							</s:if>
							<s:else>
								<a
									href='<s:url action="SearchPageAction"><s:param name="pageNum" value="#sta.index" /><s:param name="itemCategory" value="itemCategory" /><s:param name="searchWord" value="searchWord" /></s:url>'><s:property /></a>
							</s:else>
						</s:iterator>
					</div>
				</s:if>
			</div>
		</div>

		<div class="main4">
			<s:form action="GoHomeAction">
				<s:submit value="ホームへ戻る" cssClass="d-btn"/>
			</s:form>
		</div>
	</div>
<!-- *******************ここから前頁共通******************* -->
	<footer>© 2017-2018, Sagaone.com</footer>

	<form name="form_test">
		<input type="hidden" name="input_test" value="<s:iterator value="#session.allWordsList" ><s:property /></s:iterator>">
	</form>
<!-- ===================ここまで前頁共通=================== -->

</body>
</html>

