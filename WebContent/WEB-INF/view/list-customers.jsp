<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE HTML>

<html>

<head>

<title> List Customers</title>

<!-- Reference our style sheet  -->
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		
		</div>
		
		<div id="container">
		
			<div id="content">
			
			<!-- Put new Button to add Customer -->
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;"
						class="add-button"/>
			
			<!-- Put new text field and button to search for the Customer -->
			<form:form action="searchCustomer" method="GET">
			
			<input type="text" name="searchName"/>
			<input type="submit" value="Search"  class="add-button"/>
			
			</form:form>
			
			<!--  add out the html table -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!--  loop over and print the customers -->
				
				
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- Construct an update Link with customer id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
				
					<c:param name="customerID" value="${tempCustomer.id }"></c:param>
				
				</c:url>
			
				<!-- Construct an DeleteLink with customer id -->
				<c:url var="deleteLink" value="/customer/delete">
				
					<c:param name="customerID" value="${tempCustomer.id }"></c:param>
				
				</c:url>	
				
				<tr>
					
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>	
					
					<td>
						<!-- Display the update link -->
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete the Customer?')))return false">Delete</a>
					</td>
									
				</tr>
				
				</c:forEach>
			</table>
			
			</div>
		
		</div>

</body>


</html>