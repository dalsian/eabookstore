<%@ include file="includes/header.jsp"%>
<title>INV-Warehouse Books</title>
</head>
<body>
	<div class="main">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<h1>
						<i class="fas fa-home"></i> Warehouse books
					</h1>
				</div>
				<div class="col-md-4 ">
					<div class="alert alert-primary" role="alert">
						<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />,
  					<a href="<spring:url value='/dologout' />" class="alert-link">Logout</a>
						</security:authorize>
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<a class="btn btn-outline-danger" role="button"
						href="<spring:url value="/newbooks" />"><i class="fas fa-fire"></i> New published books </a>
				</div>
			</div>
		</div>

		<div class="container books_table">
			<div class="row">
				<div class="col">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">#</th>
								<th scope="col">Name</th>
								<th scope="col">Author</th>
								<th scope="col">ISBN</th>
								<th scope="col">Price</th>
								<th scope="col">Category</th>
								<th scope="col">Description</th>
								<th scope="col">Stock quantity</th>
								<th scope="col">More details</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${books}" var="book">
								<tr>
								<th scope="row">${book.id}</th>
								<td>${book.name}</td>
								<td>${book.author}</td>
								<td>${book.isbn}</td>
								<td><c:out value="${book.price}" />$</td>
								<td><c:out value="${book.category.name}" /></td>
								<td><c:out value="${book.description}" /></td>
								<td><c:out value="${book.quantity}" /></td>
								<td><a class="btn btn-outline-info"
									href="<spring:url value="/books/${book.id}"/>" class="text-info">View
										details <i class="fas fa-chevron-right"></i>
								</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>