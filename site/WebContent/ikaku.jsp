<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品追加確認</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>AddItemConfirm</h2>
  </div>
  <div>
    <h3>以下で間違いはありませんか。</h3>
    <table>
      <s:form action="IkakuAction">
        <tr>
          <td><label>商品名:</label></td>
          <td><s:property value="itName"/></td>
        </tr>
        <tr>
          <td><label>価格:</label></td>
          <td><s:property value="itPrice"/></td>
        </tr>
        <tr>
          <td><label>在庫数:</label></td>
          <td><s:property value="itStock"/></td>
        </tr>
        <s:submit value="完了" class="submit"/>
      </s:form>
    </table>
  </div>
  <div>
    <p>前の画面に<a href='<s:url action="IsAction"/>'>戻る</a></p>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>