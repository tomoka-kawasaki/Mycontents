<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>購入履歴削除</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>BuyItemDelete</h2>
  </div>
  <div>
    <h3>こちらの購入履歴を削除しますか。</h3>
    <s:form action="BdeleAction">
      <table>
        <tr>
          <th>購入日</th>
          <td><s:property value="%{#session.insertdate}"/></td>
        </tr>
        <tr>
          <th>商品名</th>
          <td><s:property value="%{#session.itemId}"/></td>
        </tr>
        <tr>
          <th>値段</th>
          <td><s:property value="%{#session.toPrice}"/></td>
        </tr>
        <tr>
          <th>購入個数</th>
          <td><s:property value="%{#session.toCount}"/></td>
        </tr>
        <tr>
          <th>支払い方法</th>
          <td><s:property value="%{#session.payment}"/></td>
        </tr>
        <tr>
          <th></th>
          <td><input type="hidden" name="deleteFlg" value="1">
          <s:hidden value="%{#session.id}"/>
          <s:hidden value="%{#session.uName}"/>
          <s:submit value="削除" method="delete" class="submit"/></td>
        </tr>
      </table>
    </s:form>
  </div>
  <div>
    <p>前の画面に<a href='<s:url action="BryoAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>