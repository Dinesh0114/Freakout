<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
     uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>FreaKouT</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">FreaKouT</span></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <c:forEach items="${categories}" var="c">
      <c:url value="all/viewallproducts?searchCondition=${c.categoryId}" var="url"></c:url>
      <li>
      <a href="${url}" >${c.categoryName } </a>
       </li>
      </c:forEach>
        <ul class="nav navbar-nav navbar-right">
      		<c:url value="/cart/getcart" var="cart"></c:url>
	      	<security:authorize access="hasRole('ROLE_USER')">
	      	
	      <ul class="nav navbar-nav navbar-right">
      		<li><a href=${cart}><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
      		</ul>
			</security:authorize>
			<c:url value="/admin/category" var="category"></c:url>
			<c:url value="/admin/add" var="product"></c:url>
			<security:authorize access="hasRole('ROLE_ADMIN')">
			<ul class="nav navbar-nav navbar-right">
			<li><a href=${category}><span class="glyphicon glyphicon-th-list">Category</span></a></li>
			<li><a href=${product}><span class="glyphicon glyphicon-th">Product</span></a></li> 
			
			</ul>     		
	         </security:authorize>
			<c:if test="${pageContext.request.userPrincipal.name==null }">
			<li><a href="Login"> <span class="glyphicon glyphicon-log-in"> </span> Login</a></li>
			<li><a href="all/registrationform"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<li><a href="">Welcome ${pageContext.request.userPrincipal.name}</a></li>
			<li><a href="<c:url value='/j_spring_security_logout'></c:url>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:if>			
			</ul>
    </div>
  </div>
</nav>

      </body>
</html>