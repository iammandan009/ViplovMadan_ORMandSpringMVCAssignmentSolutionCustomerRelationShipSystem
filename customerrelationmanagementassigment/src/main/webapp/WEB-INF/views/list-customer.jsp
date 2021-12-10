<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Customer RelationShip Management</h1>
		<hr />

		<h2>
			List of Customers <a
				href="/customerrelationmanagementassigment/customers/new"
				class="btn btn-primary btn-sm float-end">Add a Customer</a>
		</h2>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>

						<td><c:out value="${customer.firstName}" /></td>
						<td><c:out value="${customer.lastName}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td><a
							href="/customerrelationmanagementassigment/customers/edit?id=${customer.id}"
							class="btn btn-secondary btn-sm">Update</a> <a
							href="/customerrelationmanagementassigment/customers/delete?id=${customer.id}"
							class="btn btn-danger btn-sm">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>