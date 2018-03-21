<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="Header.jsp"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<style>
.register
{
font-size:50px;
}
</style>
</head>
<body>
<c:url value='/all/registercustomer' var="url"></c:url>
<form:form action="${url }" modelAttribute="customer">

+
<div class="boxed" style="border:1px solid">
<span class="register">Enter Customer Details</span>
<div class="form-group">
<form:label path="firstname">Enter Firstname</form:label>
<form:input path="firstname"  class="form-control"></form:input>

</div>

<div class="form-group">
<form:label path="lastname">Enter Lastname</form:label>
<form:input path="lastname"  class="form-control"></form:input>

</div>

<div class="form-group">
<form:label path="email">Email</form:label>
<form:input path="email" type="email" class="form-control" title="Please enter valid email address"></form:input>

<span style="color:red">${duplicateEmail }</span>
</div>

<div class="form-group">
<form:label path="phonenumber">PhoneNumber</form:label>
<form:input path="phonenumber"  class="form-control"></form:input>
<form:errors path="phonenumber" cssStyle="color:red"></form:errors>
</div>
</div>

<div class="boxed" style="border:1px solid">
<span class="register">Enter login credentials</span>
<div class="form-group">
<form:label path="user.username">Username</form:label>
<form:input path="user.username"  class="form-control"></form:input>

<span style="color:red">${duplicateUsername }</span>
</div>

<div class="form-group">
<form:label path="user.password">Password</form:label>
<form:input path="user.password" type="password" class="form-control"></form:input>

</div>
</div>
<div class="boxed" style="border:1px solid">
<span class="register">Enter Billing Address</span>
<div class="form-group">
<form:label path="billingaddress.apartmentnumber">Apartment Number</form:label>
<form:input path="billingaddress.apartmentnumber"  class="form-control"></form:input>

</div>

<div class="form-group">
<form:label path="billingaddress.streetname">Streetname</form:label>
<form:input path="billingaddress.streetname"  class="form-control"></form:input>

</div>

<div class="form-group">
<form:label path="billingaddress.city">City</form:label>
<form:input path="billingaddress.city"  class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="billingaddress.state">State</form:label>
<form:input path="billingaddress.state"  class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="billingaddress.zipcode">Zipcode</form:label>
<form:input path="billingaddress.zipcode"  class="form-control"></form:input>
<form:errors path="billingaddress.zipcode" cssStyle="color:red"></form:errors>
</div>
</div>
<div class="boxed" style="border:1px solid">
<span class="register">Enter Shipping Address</span>
<div class="form-group">
<form:label path="shippingaddress.apartmentnumber">Apartment Number</form:label>
<form:input path="shippingaddress.apartmentnumber"  class="form-control"></form:input>
<form:errors path="shippingaddress.apartmentnumber" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<form:label path="shippingaddress.streetname">Streetname</form:label>
<form:input path="shippingaddress.streetname"  class="form-control"></form:input>

</div>

<div class="form-group">
<form:label path="shippingaddress.city">City</form:label>
<form:input path="shippingaddress.city"  class="form-control"></form:input>
<form:errors path="shippingaddress.city" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<form:label path="shippingaddress.state">State</form:label>
<form:input path="shippingaddress.state"  class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="shippingaddress.zipcode">Zipcode</form:label>
<form:input path="shippingaddress.zipcode"  class="form-control"></form:input>
</div>
</div>

<input type="submit" value="Register">
</form:form>
</body>
</html>