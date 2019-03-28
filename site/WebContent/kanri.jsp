<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>管理者画面</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>Admin</h2>
  </div>
  <div id="kanri">
    <p>商品管理</p>
    <s:form action="IsAction">
      <s:submit value="商品新規追加" class="submit"/>
    </s:form>
    <s:form action="IlAction">
      <s:submit value="商品一覧" class="submit"/>
    </s:form>
  </div>
  <div id="kanri">
    <p>ユーザー管理</p>
    <s:form action="UsAction">
      <s:submit value="ユーザー新規作成" class="submit"/>
    </s:form>
    <s:form action="UlAction">
      <s:submit value="ユーザー一覧" class="submit"/>
    </s:form>
  </div>
  <div>
    <p>ホーム画面へ<a href='<s:url action="HAction"/>'>戻る</a></p>
    <p><a href='<s:url action="LoAction"/>'>ログアウト</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>