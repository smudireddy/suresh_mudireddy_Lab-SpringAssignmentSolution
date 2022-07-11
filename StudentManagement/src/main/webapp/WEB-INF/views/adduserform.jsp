<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">College Fest - Student Management</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/users/">Users</a>
      </li>
    </ul>
  </div> 
</nav>
<br />
<br />
<br />
 <div class="container">
  
  <h3>User Registration</h3>
  
  <div class="card">
   
   <div class="card-body">
    
    <form action="/users/register" method="post">
    
    	<div class="form-group row">
     	 	<div class="col-sm-7">
       			<input type="hidden" class="form-control" name="id" placeholder="" value="${user.id}">
      		</div>
     	</div>

     	<div class="form-group row">
      		<label for="firstName" class="col-sm-2 col-form-label">User Name</label>
      		<div class="col-sm-7">
       			<input type="text" class="form-control" name="name" placeholder="Enter user name" value="${user.name}" required>
      		</div>
     	</div>

     	<div class="form-group row">
      		<label for="lastName" class="col-sm-2 col-form-label">Password</label>
      		<div class="col-sm-7">
       			<input type="text" class="form-control" name="password" value="${user.password}" placeholder="Enter password">
      		</div>
     	</div>
		
     	<div class="form-group form-check">
     		<div class="form-group row">
     	  		<label for="lastName" class="col-sm-2 col-form-label">Role</label>
      			<div class="col-sm-7">
      			    
      			     <c:forEach items="${roles}" var="role">
        			    <c:forEach items="${user.roles}" var="userrole">
        				</c:forEach>	
        			    
        				<label class="form-check-label">
        				<input class="form-check-input" type="checkbox" value="${role.roleId}" name="${role.roleId}">${role.roleName}
        					</label>
        				<br>	
        			 </c:forEach>
      			</div>	
      		</div>
    	</div>
     	<button type="submit" class="btn btn-primary">Submit</button>
    </form>
   </div>
  </div>
 </div>
</body>
</html>