<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
    <%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div>
<div>
<a href="<c:url value='/cart/clearcart/${Cart.id }'></c:url>" class="btn btn-danger pull-left " >
<span class="glyphicon glypicon-remove-sign"></span>Clear Cart  </a>

<a href="<c:url value='/cart/checkout/${Cart.id }'></c:url>" class="btn btn-success pull-right">
<span class="glyphicon glypicon-shopping-cart"></span> Check Out  </a>
<table class="table table-striped">
<thead>
<tr><th>Name</th><th>Quantity</th><th>Total Price</th><th>Remove</th>
</tr>
</thead>
<!-- double grandTotal=0 -->
<c:set var="grandTotal" value="0"></c:set>
<c:forEach items="${Cart.cartItems }" var="cartItem">
<tr>
<td>${cartItem.product.productName }</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.totalPrice }</td>

<td><a href="<c:url value='/cart/deletecartitem/${CartItem.id }'></c:url>" class="label label-danger pull-left">

<span class="glyphicon glypicon-remove" ></span>Remove
</a></td>
<td></td>
<!--  grandTotal = cartItem.totalPrice + grandTotal -->

<c:set var="grandTotal" value="${cartItem.totalPrice  + grandTotal }"></c:set>
</tr>
</c:forEach>
</table>
Total Price : ${grandTotal }
</div>

</div>
</body>
</html>