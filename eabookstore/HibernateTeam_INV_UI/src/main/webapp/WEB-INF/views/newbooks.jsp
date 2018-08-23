<%@ include file="includes/header.jsp"%>
<title>INV-New published books</title>
</head>

<body>
	<div class="main">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-8">
					<h1>
						<i class="fas fa-fire"></i> New published books
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
					<a class="btn btn-outline-success" role="button"
						href="<spring:url value="/books" />"><i
						class="fas fa-chevron-left"></i> Back to warehouse books</a>
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
									<td><button type="button"
											class="btn btn-outline-danger btn-sm" data-toggle="modal"
											data-target="#newbook<c:out value='${book.id}' />">
											Request&nbsp;<i class="fas fa-arrow-circle-down"></i>
										</button></td>
								</tr>
								<!-- Modal -->

								<div class="modal fade" id="newbook<c:out value='${book.id}' />"
									tabindex="-1" role="dialog" aria-labelledby="modelTitle"
									aria-hidden="true">
									<form:form modelAttribute="newBook"
										action="/HibernateTeam_INV_UI/newbooks/${book.id}/request"
										class="form-horizontal">
										<div class="modal-dialog modal-dialog-centered"
											role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="modelTitle">Request to
														suppliers for new book</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">

													<div class="form-group">
														<label class="control-label" for="name"><spring:message
																code="updateBook.form.bookName.label" /></label>
														<div class="col-sm-10">
															<div class="form:input-prepend input-group">
																<div class="input-group-prepend">
																	<div class="input-group-text">
																		<i class="fas fa-book"></i>
																	</div>
																</div>
																<form:input id="name" name="name" type="text"
																	path="name" value="${book.name}"
																	class="form:input-small" readonly="true"
																	disabled="true" />
																<form:errors path="name" cssClass="text-danger" />
																<div class="invisible">
																	<form:input id="isbn" path="isbn" type="text"
																		value="${book.isbn}" class="form:input-small"
																		readonly="true" />
																	<form:errors path="isbn" cssClass="text-danger" />
																</div>
															</div>
														</div>
													</div>
													<div class="form-group">
														<label class="control-label" for="quantity"><spring:message
																code="updateBook.form.requestQuantity.label" /></label>
														<div class="col-sm-10">
															<div class="form:input-prepend input-group">
																<div class="input-group-prepend">
																	<div class="input-group-text">
																		<i class="fas fa-hashtag"></i>
																	</div>
																</div>
																<form:input id="quantity" path="quantity" type="text"
																	class="form:input-small" />
																<form:errors path="quantity" cssClass="text-danger" />
															</div>
														</div>
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
													<security:authorize access="hasRole('ROLE_ADMIN')">
														<input type="submit" class="btn btn-danger"
															value="Send request" />
													</security:authorize>
												</div>
											</div>
										</div>
									</form:form>
								</div>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>