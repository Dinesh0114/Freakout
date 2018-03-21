<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Iphone</title>
</head>
<body>



<c:forEach items="${listProducts}" var="product">
     
        
	<tr>
		<th>${product.productId}</th>
		<th>${product.productName}</th>
		
		 <img src="<c:url value="/resources/image/${product.productId}.jpg"/>" width="200" height="200"/>
		</tr>
</c:forEach>
 <c:url value='/cart/addtocart/${product.productId}' var="addtocart"></c:url> 
	  <security:authorize access="hasRole('ROLE_USER')">
      <li><a href=${addtocart}><button type="submit"  value='Add To Cart'  class="btn btn-info btn-lg glyphicon" >
	  <span class="glyphicon-shopping-cart"></span>Add to Cart 
	  </button></a></li>
	  </security:authorize>
	  </pre>
	  
	  </div>

</body>
</html>