<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="Header.jsp" %>
<html>
<head>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-show-password/1.0.3/bootstrap-show-password.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<!-- <body background="/resources/image/corrupt.jpg" style="background-repeat:no-repeat;background-size:cover;" > -->
<div class="container" style=width:400px>
      <form action="<c:url value='/j_spring_security_check'></c:url>" method="post">
      <div class=" ">
     <label> Username:</label>
     <input type="text" id="username" name="j_username" class="form-control" />
      </div>
      <div class="form-group">
      <label>Password:</label>
      <input type="password" id="password" name="j_password" class="form-control" />
      </div>
      <div class="form-group">
      <input type="submit" value="Login" disabled="disabled" id="login" style="color:blue" class="form-control"/>
      </div>
      


    </form>
    
    </div>
   
    <style>
#username {
    color:blue;
}
</style>
    <script type=text/javascript src='https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js'></script>
    <script type="text/javascript">
$(document).ready(function() {
     $('#login').attr('disabled','disabled');
     $('#username').keyup(function() {
        if($(this).val() != '') {
           $('#login').removeAttr('disabled');
        }
        else {
        $('#login').attr('disabled','disabled');
        }
     });
     $(document).ready(function() {
         $('#username').click(function(){
             $(this).css({'color': '#black'});
         });
     }); });
 
 
</script>
</body>
</html>