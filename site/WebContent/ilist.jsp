<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品一覧</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>ItemList</h2>
  </div>
  <div>
    <s:if test="session.message !=null">
      <h3><s:property value="session.message"/></h3>
    </s:if>
    <s:if test="itemList !=null">
      <table>
        <tr>
          <th>#</th>
          <th>ID</th>
          <th>商品名</th>
          <th>価格</th>
          <th>在庫数</th>
          <th>登録日</th>
        </tr>
        <s:iterator value="session.itemList">
          <tr>
            <td><a href='<s:url action="IdAction"><s:param name="id" value="%{id}"/></s:url>'><input type="submit" value="削除" class="submit"/></a></td>
            <td><s:property value="id"/></td>
            <td><s:property value="itemName"/></td>
            <td><s:property value="itemPrice"/></td>
            <td><s:property value="itemStock"/></td>
            <td><s:property value="insert_date"/></td>
          </tr>
        </s:iterator>
      </table>
    </s:if>
  </div>
  <div>
    <p>管理者画面へ<a href='<s:url action="KanriAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>