<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Student</title>
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
        <a class="nav-link" href="/students">Registered Students</a>
      </li>
    </ul>
  </div> 
</nav>
<br />
<br />
<br />
 <div class="container">
  <h3>Student Registration</h3>
  <div class="card">
   <div class="card-body">
    <form action="/students/register" method="post">
    
    	<div class="form-group row">
     	 	<label for="id" class="col-sm-2 col-form-label"></label>
      		<div class="col-sm-7">
       			<input type="hidden" class="form-control" name="id" placeholder="" value="${student.id}">
      		</div>
     	</div>

     <div class="form-group row">
      <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="firstName" placeholder="Enter first name" value="${student.firstName}" required>
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Last
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="lastName" value="${student.lastName}" placeholder="Enter last name">
      </div>
     </div>

     <div class=" form-group row">
      <label for="course" class="col-sm-2 col-form-label">Course</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="course" value="${student.course}"
        placeholder="Enter course" required>
      </div>
     </div>

     <div class="form-group row">
      <label for="country" class="col-sm-2 col-form-label">Country</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="country" value="${student.country}"
        placeholder="Enter country" required>
      </div>
     </div>
     	<button type="submit" class="btn btn-primary">Submit</button>
    </form>
   </div>
  </div>
 </div>
</body>
</html>