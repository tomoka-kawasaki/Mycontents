<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="discription" content=""/>
<meta name="keywords" content=""/>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品追加</title>
</head>
<body>

<div id="header">
  <div id="pr"></div>
</div>
<div id="main">
  <div id="top">
    <h2>AddItem</h2>
  </div>
  <div>
    <s:if test="errorMessage !=''">
      <s:property value="errorMessage" escape="false"/>
    </s:if>

    <table>
      <s:form action="IsakuAction">
        <tr>
          <td><label>商品名</label></td>
          <td><input type="text" name="itName" value=""/></td>
        </tr>
        <tr>
          <td><label>価格</label></td>
          <td><input type="text" name="itPrice" value=""/></td>
        </tr>
        <tr>
          <td><label>在庫数</label></td>
          <td><input type="text" name="itStock" value=""/></td>
        </tr>
        <s:submit value="登録" class="submit"/>
      </s:form>
    </table>
  </div>
  <div>
    <p>管理者画面へ戻る場合は<a href='<s:url action="KanriAction"/>'>こちら</a>
  </div>
</div>
<div id="footer">
  <div id="pr"></div>
</div>

</body>
</html>