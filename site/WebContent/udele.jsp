<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー削除確認</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>UserDelete</h2>
  </div>
  <div>
    <h3>こちらのユーザーを削除しますか。</h3>
    <s:form action="UdeleAction">
    <table>
      <tr>
        <th>ID</th>
        <td><s:property value="%{#session.id}"/></td>
      </tr>
      <tr>
        <th><label>ユーザー名</label></th>
        <td><s:property value="%{#session.userName}"/></td>
      </tr>
      <tr>
        <th><label>ユーザーID</label></th>
        <td><s:property value="%{#session.loginId}"/></td>
      </tr>
      <tr>
        <th><label>パスワード</label></th>
        <td><s:property value="%{#session.loginPass}"/></td>
      </tr>
      <tr>
        <th><label>登録日</label></th>
        <td><s:property value="%{#session.insert_date}"/></td>
      </tr>
      <tr>
        <th></th>
        <td><input type="hidden" name="deleteFlg" value="1">
        <s:submit value="削除" method="delete" class="submit"/></td>
      </tr>
    </table>
    </s:form>
  </div>
  <div>
    <p>前の画面に<a href='<s:url action="UlAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>