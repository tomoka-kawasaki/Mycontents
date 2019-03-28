<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>登録確認</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>CreateUserConfirm</h2>
  </div>
  <div>
    <h3>登録する内容は以下の通りでよろしいでしょうか。</h3>
    <table>
      <s:form action="UkakuAction">
        <tr>
          <td><label>ログインID:</label></td>
          <td><s:property value="userId" escape="false"/></td>
        </tr>
        <tr>
          <td><label>パスワード:</label></td>
          <td><s:property value="password" escape="false"/></td>
        </tr>
        <tr>
          <td><label>ユーザー名:</label></td>
          <td><s:property value="name" escape="false"/></td>
        </tr>
        <tr>
          <td><s:submit value="完了" class="submit"/></td>
        </tr>
      </s:form>
    </table>
  </div>
  <div>
    <p>前の画面へ<a href='<s:url action="UsAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>