<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>購入画面</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>BuyItemSelect</h2>
  </div>
  <div>
   <s:if test="buyitemList==null">
     <h3>商品はありません。</h3>
   </s:if>
   <s:if test="buyitemList !=null">
    <p>商品をお選びください。</p>
    <table>
      <tr>
        <th>アイテム名</th>
        <th>価格</th>
        <th>在庫数</th>
        <th></th>
      </tr>
      <s:iterator value="session.buyitemList">
      <tr>
        <td><s:property value="itemName"/></td>
        <td><s:property value="itemPrice"/></td>
        <td><s:property value="itemStock"/></td>
        <td><a href='<s:url action="BuyAction"><s:param name="itemName" value="%{itemName}"/></s:url>'><input type="submit" value="購入" class="submit"/></a>
      </tr>
      </s:iterator>
    </table>
    </s:if>
  </div>
  <div>
    <p><s:if test="#session.lu_id !=null"><a href='<s:url action="LoAction"/>'>ログアウト</a></s:if></p>
    <p>ホーム画面へは<a href='<s:url action="HAction"/>'>こちら</a></p>
    <p>購入履歴は<a href='<s:url action="BryoAction"/>'>こちら</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>