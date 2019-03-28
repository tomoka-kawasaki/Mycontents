<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>新規ユーザー登録</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>CreateUser</h2>
  </div>
  <div>
    <s:if test="errorMessage !=''">
      <s:property value="errorMessage" escape="false"/>
    </s:if>
  </div>
  <div>
    <s:if test="message !=''">
      <s:property value="message" escape="false"/>
    </s:if>
  </div>
  <div>
    <table>
      <s:form action="UsakuAction">
        <tr>
          <td><label>ログインID:</label></td>
          <td><s:textfield name="userId"/></td>
        </tr>
        <tr>
          <td><label>パスワード:</label></td>
          <td><s:textfield name="password"/></td>
        </tr>
        <tr>
          <td><label>ユーザー名:</label></td>
          <td><s:textfield name="name"/></td>
        </tr>
        <s:submit value="登録" class="submit"/>
      </s:form>
    </table>
  </div>
  <div>
    <p>ログイン画面へ<a href='<s:url action="FirstAction"/>'>戻る</a></p>
    <s:if test="#session.adflg !=null">
      <p>管理画面へ<a href='<s:url action="KanriAction"/>'>戻る</a></p>
    </s:if>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>