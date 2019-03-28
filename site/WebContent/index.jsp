<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Index</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>Index</h2>
  </div>
  <div>
    <p>ようこそ</p>
    <p>
      <s:form action="FirstAction">
        <s:submit value="商品購入" class="submit"/>
      </s:form>
    </p>
    <p>
      <s:if test="#session.adflg !=null">
        <s:form action="KanriAction">
          <s:submit value="管理者画面" class="submit"/>
        </s:form>
      </s:if>
    </p>
    <p>
      <s:if test="#session.lu_id !=null">
        <p>ログアウトは<a href='<s:url action="LoAction"/>'>こちら</a>から</p>
      </s:if>
    </p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>