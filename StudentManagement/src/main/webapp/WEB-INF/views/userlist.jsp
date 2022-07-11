<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPEhtml>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Registered Users</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link href="<c:url value="/css/custom.css"/>" rel="stylesheet" >
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
		<br/>
		<br/>
		<br/>
		
	    <div class="container">
	    
	    	<div class="row">
  				<div class="col-sm-11">
  					<h3>Users</h3>
  				</div>
  				<div class="col-sm-1">
  					<a href="/logout" class="btn btn-link btn-sm mb-3 mx-auto">Logout</a>
  				</div>
			</div>
	    	<hr/>
			
			<c:if test="${not empty success}">
				<div class="alert alert‐success alert‐dismissible fade show" role="alert"> ${success}
					<button type="button" class="btn‐close" data‐bs‐dismiss="alert" aria‐label="Close"> </button>	
				</div>
			</c:if>
			<table class="table table-bordered table-striped table-sm">
				<thead class="thead-dark">
					<tr>
						<th scope="col">User ID</th>
						<th scope="col">User Name</th>
						<th scope="col">User Role</th>
						<th scope="col">Actions</th>				
        			</tr>
        		</thead>
        		<tbody>
        			<c:forEach items="${users}" var="user">
        				<tr>
        					<td>${user.id}</td>
        					<td>${user.name}</td>
        					
        					<td>
        						<c:forEach items="${user.roles}" var="role">
        						  <p>${role.roleName}</p>
        						</c:forEach>
        					</td>
        					
        					<td>
        						<a href="/users/update?userId=${user.id}" class="btn btn-info btn-sm">Update</a>
	        					<a href="/users/delete?userId=${user.id}" class="btn btn-danger btn-sm"
	        					onClick=if (!(confirm('Are you sure you want to delete the user?'))) return false">Delete</a>
	        					
        					</td>
        				</tr>
        			</c:forEach>
        		</tbody>	
    		</table>
    		<br/>
    		
    		<div class="row">
  				<div class="col-sm-2">
  				     <a href="/users/adduser">
      					<button type="button" class="btn btn-primary" align="right">Add User</button>
   					</a> 		
  				</div>
			</div>
			
    	</div>
    </body>
</html>