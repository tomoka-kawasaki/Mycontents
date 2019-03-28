<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Login</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>Login</h2>
  </div>
  <div>
    <s:form action="LiAction">
      <s:textfield name="loginUserId" label="ユーザーID"/>
      <s:password name="loginPassword" label="パスワード"/>
      <s:submit value="ログイン" class="submit"/>
    </s:form>
  </div>
  <div>
    <p>新規ユーザー登録は<a href='<s:url action="UsAction"/>'>こちら</a></p>
    <p>ホーム画面へは<a href='<s:url action="HAction"/>'>こちらから</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>