<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品詳細</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>BuyItemConfirm</h2>
  </div>
  <div>
    <h3>購入個数・支払い方法を選択してください。</h3>
    <s:form action="BiAction">
    <table>
      <tr>
        <th><label>商品名</label></th>
        <td><s:property value="%{#session.itemName}"/></td>
      </tr>
      <tr>
        <th><label>価格</label></th>
        <td><s:property value="%{#session.itemPrice}"/></td>
      </tr>
      <tr>
        <th><label>購入個数</label></th>
        <td><select name="count">
          <option value="1" selected="selected">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select></td>
      </tr>
      <tr>
        <th><label>支払い方法</label></th>
        <td><input type="radio" name="pay" value="1" checked="checked">現金払い
        <input type="radio" name="pay" value="2">クレジットカード</td>
      </tr>
      <tr>
        <td><s:submit value="購入" class="submit"/></td>
      </tr>
    </table>
    </s:form>
    <div>
      <p>前の画面へ<a href='<s:url action="FirstAction"/>'>戻る</a></p>
    </div>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>