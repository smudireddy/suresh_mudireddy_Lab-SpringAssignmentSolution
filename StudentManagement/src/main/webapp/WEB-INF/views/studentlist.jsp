<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPEhtml>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>All Students</title>
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
		</nav>
		<br/>
		<br/>
		<br/>
		
	    <div class="container">
	    	<div class="container-fluid">
				<div class="col">
				    <h2>Registered Students</h2>
				</div>
				<div class="col">
				<form class="form-inline">
				    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  				</form>
  				</div>
			</div>
			
			<br/>
			<br/>
			
			<c:if test="${not empty success}">
				<div class="alert alert‐success alert‐dismissible fade show" role="alert"> ${success}
					<button type="button" class="btn‐close" data‐bs‐dismiss="alert" aria‐label="Close"> </button>	
				</div>
			</c:if>
			<table class="table table-bordered table-hover table-sm">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Student ID</th>
						<th scope="col">Student Name</th>
						<th scope="col">Course</th>
						<th scope="col">Country</th>
						<th scope="col">Actions</th>				
        			</tr>
        		</thead>
        		<tbody>
        			<c:forEach items="${students}" var="student">
        				<tr>
        					<td>${student.id}</td>
        					<td>${student.firstName}&nbsp;${student.lastName}</td>
        					<td>${student.course}</td>
        					<td>${student.country}</td>
        					<td>
        						<div class="container">
	        					<a href="/students/update?studentId=${student.id}">
	        					  	<button type="button" class="btn btn‐success">Modify</button>
	        					</a>
	        					<a href="/students/deregister?studentId=${student.id}">
	        					  	<button type="button" class="btn btn‐danger">Delete</button>
	        					</a>
	        					</div>
        					</td>
        				</tr>
        			</c:forEach>
        		</tbody>	
    		</table>
    		<br/>
    		<div class="form-group">
    		    <a href="students/register" >
      				<button type="button" class="btn btn-primary">Add New Student</button>
   				</a> 			
    		</div>
    	</div>
    </body>
</html>    	   	