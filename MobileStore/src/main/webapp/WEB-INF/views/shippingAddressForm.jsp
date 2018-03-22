 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@include file="Header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="/cart/createorder/${cartId }" var="url"></c:url>
<form:form action="${url }" modelAttribute="shippingaddress">

<div class="boxed" style="border:1px solid">
Enter Shipping Address

<div class="form-group">
<%-- <form:hidden path="id"/> --%>
<form:label path="apartmentnumber">Apartment Number</form:label>
<form:input path="apartmentnumber"  class="form-control"></form:input>
<form:errors path="apartmentnumber" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<form:label path="streetname">Streetname</form:label>
<form:input path="streetname"  class="form-control"></form:input>
<form:errors path="streetname" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<form:label path="city">City</form:label>
<form:input path="city"  class="form-control"></form:input>
<form:errors path="" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<form:label path="State">State</form:label>
<form:input path="State"  class="form-control"></form:input>
<form:errors path="" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<form:label path="zipcode">Zipcode</form:label>
<form:input path="zipcode"  class="form-control"></form:input>
<form:errors path="" cssStyle="color:red"></form:errors>
</div>
</div>

<input type="submit" value="Next">
</form:form>
</body>
</html> 