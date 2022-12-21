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
	
	.btn {
		  background-color: rgba(255,255,255,0.3); 
		  border-color:1px solid rgba(0,0,0,.125); 
		  color: black; 
		  padding: 12px;
		  font-size: 15px; 
		  cursor: pointer; 
	}
	
	.card{
		position:relative;
		display:-ms-flexbox;
		display:flex;
		-ms-flex-direction:column;
		flex-direction:column;
		min-width:0;
		word-wrap:break-word;
		background-color: rgba(255,255,255,0.3);
		background-clip:border-box;
		border:1px solid rgba(0,0,0,.125);
		border-radius:.25rem
		
	}
	
	.card-body{
		-ms-flex:1 1 auto;
		flex:1 1 auto;
		padding:2.0rem;
		color: black
		
	}
	

	
</style>
</head>
<body>

	
	<br>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<c:if test="${client != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${client == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${client != null}">
            			Edit Client
            		</c:if>
						<c:if test="${client == null}">
            			Add New Client
            		</c:if>
					</h2>
				</caption>

				<c:if test="${client != null}">
					<input type="hidden" name="id" value="<c:out value='${client.id}' />" />
				</c:if>

				<fieldset>
					<label>Client Last Name</label> <input type="text"
						value="<c:out value='${client.lastName}' />"
						name="lastName" required="required">
				</fieldset>
				<br>
				<fieldset>
					<label>Client First Name</label> <input type="text"
						value="<c:out value='${client.firstName}' />"
						name="firstName" required="required">
				</fieldset>
				<br>
				<fieldset>
					<label>Client Middle Initial</label> <input type="text"
						value="<c:out value='${client.middleInitial}' />"
						name="middleInitial">
				</fieldset>
				<br>
				<fieldset>
					<label>Client Birth Date</label><input type="text"
						value="<c:out value='${client.birthDate}' />" 
						name="birthDate">
				</fieldset>
				<br>
				<fieldset>
					<label>Client Gender</label> <input type="text"
						value="<c:out value='${client.gender}' />"
						name="gender">
				</fieldset>
				<br>
				<fieldset>
					<label>Client SSN</label> <input type="text"
						value="<c:out value='${client.ssn}' />"
						name="ssn">
				</fieldset>
				<br>
				<fieldset>
					<label>Client  Mailing Address</label> <input type="text"
						value="<c:out value='${client.mailAddress}' />"
						name="mailAddress">
				</fieldset>
				<br>
				<button type="submit" class="btn">Save</button>
				</form>
			
			</div>
		</div>
	</div>
</body>
</html>
