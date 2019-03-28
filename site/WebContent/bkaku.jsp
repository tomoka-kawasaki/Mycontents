<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>購入確認</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>BuyConfirm</h2>
  </div>
  <div>
    <s:form action="BkakuAction">
      <table>
        <tr>
          <td>商品名</td>
          <td><s:property value="session.itemName"/></td>
        </tr>
        <tr>
          <td>値段</td>
          <td><s:property value="session.btPrice"/><span>円</span></td>
        </tr>
        <tr>
          <td>購入個数</td>
          <td><s:property value="session.count"/><span>個</span></td>
        </tr>
        <tr>
          <td>支払い方法</td>
          <td><s:property value="session.pay"/></td>
        </tr>
        <tr>
          <td><br></td>
        </tr>
        <tr>
          <td><s:submit value="完了" class="submit"/></td>
        </tr>
      </table>
    </s:form>
  </div>
  <div>
    <p>ホーム画面へ<a href='<s:url action="HAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>