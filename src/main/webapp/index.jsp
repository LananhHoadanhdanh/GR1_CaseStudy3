<%--
  Created by IntelliJ IDEA.
  User: Duy Le Vu
  Date: 12/2/2021
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Figure Shop</title>
</head>
<body>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of Products</h2></caption>
    <tr>
      <th>Img</th>
      <th>Category</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
    </tr>
    <c:forEach var="product" items="${products}">
      <tr>
        <td><cgit:out value="${product.img}"/></td>
        <td><c:out value="${product.category}"/></td>
        <td><c:out value="${product.name}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td><c:out value="${product.quantity}"/></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
