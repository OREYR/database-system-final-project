<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Client Management Web</title>
<style> 
	body {
	height: 100%;
	}
	
	body {
		margin: 0;
		background: linear-gradient(45deg, #49a09d, #5f2c82);
		font-family: sans-serif;
		font-weight: 100;
	}
	
	.container {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
	}
	
	.btn-header {
		  background-color: none; 
		  border: none; 
		  color: #1614b3; 
		  padding: 10px;
		  font-size: 20px; 
		  cursor: pointer; 
	}
	
	.btn-body {
		  background-color: none; 
		  border: none; 
		  color: #1614b3; 
		  margin: 5px
		  font-size: 16px; 
		  cursor: pointer; 
	} 
	
	table {
		width: 1000px;
		border-collapse: collapse;
		overflow: hidden;
		box-shadow: 0 0 20px rgba(0,0,0,0.1);
	}
	
	th,
	td {
		border: 1px solid #444;
		padding: 20px;
		background-color: rgba(255,255,255,0.2);
		color: white;
	}
	
	th {
		text-align: left;
	}
	
	thead {
		th {
			background-color: #55608f;
		}
	}
	
	tbody {
		tr {
			&:hover {
				background-color: rgba(255,255,255,0.3);
			}
		}
		td {
			position: relative;
			&:hover {
				&:before {
					content: "";
					position: absolute;
					left: 0;
					right: 0;
					top: -9999px;
					bottom: -9999px;
					background-color: rgba(255,255,255,0.2);
					z-index: -1;
				}
			}
		}
	}
	
</style>

</head>
<body>

	
	<br>

	<div class="row">
		
		<div class="container">
			<h1 style="color:White;">Client List</h1>


			<a href="<%=request.getContextPath()%>/new" class="btn-header">Add
					New Client</a>
			<br>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Last Name</th>
						<th>First Name</th>
						<th>Middle Initial</th>
						<th>Birth Date</th>
						<th>Age</th>
						<th>Gender</th>
						<th>SSN</th>
						<th>Mail Address</th>
						<th>Fraud Rate</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="client" items="${listClient}">

						<tr>
							<td><c:out value="${client.id}" /></td>
							<td><c:out value="${client.lastName}" /></td>
							<td><c:out value="${client.firstName}" /></td>
							<td><c:out value="${client.middleInitial}" /></td>
							<td><c:out value="${client.birthDate}" /></td>
							<td><c:out value="${client.age}" /></td>
							<td><c:out value="${client.gender}" /></td>
							<td><c:out value="${client.ssn}" /></td>
							<td><c:out value="${client.mailAddress}" /></td>
							<td><c:out value="${client.fraudRate}" /></td>
							<td><a href="edit?id=<c:out value='${client.id}'/>" class="btn-body">Edit</a>
								&nbsp; <a
								href="delete?id=<c:out value='${client.id}'/>" class="btn-body">Delete</a></td>
						</tr>
					</c:forEach>
				
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
