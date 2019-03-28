<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>完了</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>CreateUserComplete</h2>
  </div>
  <div>
    <h3>登録が完了しました。</h3>
    <p><a href='<s:url action="FirstAction"/>'>ログイン画面へ</a></p>
  </div>
  <div>
    <s:if test="#session.adflg !=null">
      <p><a href='<s:url action="KanriAction"/>'>管理画面へ</a></p>
    </s:if>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>