<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー一覧</title>

</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>UserList</h2>
  </div>
  <div>
    <s:if test="session.message !=null">
      <h3><s:property value="session.message"/></h3>
    </s:if>
    <s:if test="userList !=null">
      <table>
        <tr>
          <th>#</th>
          <th>ID</th>
          <th>ユーザー名</th>
          <th>ユーザーID</th>
          <th>パスワード</th>
          <th>登録日</th>
        </tr>
        <s:iterator value="session.userList">
          <tr>
            <td><a href='<s:url action="UdAction"><s:param name="id" value="%{id}"/></s:url>'><input type="submit" value="削除" class="submit"/></a></td>
            <td><s:property value="id"/></td>
            <td><s:property value="userName"/></td>
            <td><s:property value="loginId"/></td>
            <td><s:property value="loginPass"/></td>
            <td><s:property value="insert_date"/></td>
          </tr>
        </s:iterator>
      </table>
    </s:if>
    <div>
      <p>管理者画面へ<a href='<s:url action="KanriAction"/>'>戻る</a></p>
    </div>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>