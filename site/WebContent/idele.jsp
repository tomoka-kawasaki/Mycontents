<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品削除確認</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>ItemDelete</h2>
  </div>
  <div>
    <h3>こちらの商品を削除しますか。</h3>
    <s:form action="IdeleAction">
      <table>
        <tr>
          <th>ID</th>
          <td><s:property value="%{#session.id}"/></td>
        </tr>
        <tr>
          <th>商品名</th>
          <td><s:property value="%{#session.itemName}"/></td>
        </tr>
        <tr>
          <th>価格</th>
          <td><s:property value="%{#session.itemPrice}"/></td>
        </tr>
        <tr>
          <th>在庫数</th>
          <td><s:property value="%{#session.itemStock}"/></td>
        </tr>
        <tr>
          <th>登録日</th>
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
    <p>前の画面に<a href='<s:url action="IlAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>