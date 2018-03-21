<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@include file="Header.jsp"%>
<title>Insert title here</title>
</head>
<body>

	<div class="row" >
<%-- <form action="<c:url value='/cart/addtocart/${product.productId }'></c:url>"> --%>
<c:forEach items="${listproduct}" var="product"> 
 <div class="col-sm-4">
      <img src="<c:url value="/resources/image/${product.productId}.jpg"/>" width="200" height="200"/>
	 <pre>
<b>Product Name:</b> ${product.productName }<br>
<b>Product Description:</b>${product.productDesc }<br>
<b>Price:</b>${product.productCost }<br>
<b>Stock:</b>${product.productStock }<br>
<b>Category </b>${product.category.categoryName }<br>	
	  <c:url value='/cart/addtocart/${product.productId}' var="addtocart"></c:url> 
	  <security:authorize access="hasRole('ROLE_USER')">
      <li><a href=${addtocart}><button type="submit"  value='Add To Cart'  class="btn btn-info btn-lg glyphicon" >
	  <span class="glyphicon-shopping-cart"></span>Add to Cart 
	  </button></a></li>
	  </security:authorize>
	  </pre>
	  
	  </div>
	  </c:forEach>
  </div>
</body>
</html>