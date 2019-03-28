<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>購入履歴</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>BuyItemHistory</h2>
  </div>
  <div>
    <h3>ログイン情報</h3>
    <table>
      <tr>
        <th><label>ユーザー名:</label></th>
        <td><s:property value="#session.name"/></td>
      </tr>
      <tr>
        <th><label>ユーザーID:</label></th>
        <td><s:property value="#session.lu_id"/></td>
      </tr>
    </table>
  </div>
  <p>　</p>
  <div>
    <s:if test="session.message !=null">
      <h3><s:property value="session.message"/></h3>
    </s:if>
    <s:if test="bitemList !=null">
      <table>
        <tr>
          <th>#</th>
          <th>商品名</th>
          <th>値段</th>
          <th>購入個数</th>
          <th>支払い方法</th>
          <th>購入日</th>
        </tr>
        <s:iterator value="session.bitemList">
          <tr>
            <td><a href='<s:url action="BdAction"><s:param name="id" value="%{id}"/></s:url>'><input type="submit" value="削除" class="submit"/></a></td>
            <td><s:property value="itemId"/></td>
            <td><s:property value="toPrice"/></td>
            <td><s:property value="toCount"/></td>
            <td><s:property value="payment"/></td>
            <td><s:property value="insertdate"/></td>
          </tr>
        </s:iterator>
      </table>
    </s:if>
    <div>
      <p>Homeへ<a href='<s:url action="HAction"/>'>戻る</a></p>
      <p><a href='<s:url action="LoAction"/>'>ログアウトする</a></p>
    </div>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>