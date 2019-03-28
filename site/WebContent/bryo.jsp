<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>購入完了</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>BuyComplete</h2>
  </div>
  <div>
    <h3>購入手続きが完了致しました。</h3>
    <p>購入履歴の確認は<a href='<s:url action="BryoAction"/>'>こちら</a></p>
    <p>トップページへ<a href='<s:url action="HAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>