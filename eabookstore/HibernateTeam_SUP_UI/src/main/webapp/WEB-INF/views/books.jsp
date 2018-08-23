<%@ include file="includes/header.jsp"%>
<title>SUP-Published books</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<i class="fas fa-home"></i>&nbsp;Published Books
				</h1>
				<p>Newly published books</p>
				<a class="btn btn-outline-danger"
					href="<spring:url value="/requests" />"><i
					class="fas fa-registered"></i>&nbsp;NEW REQUESTS</a>
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#exampleModal">
					<i class="fas fa-bullhorn"></i>&nbsp;PUBLISH NEW BOOK!
				</button>
			</div>
		</div>
	</section>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form:form modelAttribute="newBook"
					action="/HibernateTeam_SUP_UI/books/add" class="form-horizontal">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Publish book
							form</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div>
							<fieldset>
								<%-- <form:errors path="*" cssClass="alert alert-danger"
									element="div" /> --%>
								<div class="form-group">
									<label class="control-label" for="name"><spring:message
											code="newBook.form.bookName.label" /></label>
									<div>
										<div class="form:input-prepend input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fas fa-book"></i>
												</div>
											</div>
											<form:input id="name" path="name" type="text"
												value="${book.name}" class="form:input-small" />
											<form:errors path="name" cssClass="text-danger" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label " for="category"><spring:message
											code="newBook.form.bookCategory.label" /></label>
									<div>
										<div class="form:input-prepend input-group">
											<%-- <form:select class="form-control" path="category">
												<form:option value="NONE" label="--- Select ---" />
												<form:options items="${categories}" itemLabel="name" itemValue="id" />
												<c:forEach items="${categories}" var="category">
													<form:option value="${category.id}"
														label="${category.name}" />
												</c:forEach>
											</form:select> --%>
											<select name="category.id" class="form-control">
												<option value="-">--Select Category--</option>
												<c:forEach var="category" items="${categories}">
													<option value="${category.id}">${category.name}</option>
												</c:forEach>
											</select>

										</div>
									</div>

								</div>

								<div class="form-group">
									<label class="control-label " for="author"><spring:message
											code="newBook.form.bookAuthor.label" /></label>
									<div>
										<div class="form:input-prepend input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fas fa-user-circle"></i>
												</div>
											</div>
											<form:input id="author" path="author" type="text"
												value="${book.author}" class="form:input-small" />
											<form:errors path="author" cssClass="text-danger" />
										</div>
									</div>

								</div>

								<div class="form-group">
									<label class="control-label " for="isbn"><spring:message
											code="newBook.form.bookISBN.label" /></label>
									<div>
										<div class="form:input-prepend input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fas fa-qrcode"></i>
												</div>
											</div>
											<form:input id="isbn" path="isbn" type="text"
												value="${book.isbn}" class="form:input-small" />
											<form:errors path="isbn" cssClass="text-danger" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label " for="price"><spring:message
											code="newBook.form.bookPrice.label" /></label>
									<div>
										<div class="form:input-prepend input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">$</div>
											</div>
											<form:input id="price" path="price" type="text"
												value="${book.price}" class="form:input-small form-control" />
											<form:errors path="price" cssClass="text-danger" />
										</div>
									</div>
								</div>



								<div class="form-group">
									<label class="control-label " for="description"><spring:message
											code="newBook.form.bookDescription.label" /></label>
									<div>
										<div class="form:input-prepend input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fas fa-info"></i>
												</div>
											</div>
											<form:input id="description" path="description" type="text"
												value="${book.description}"
												class="form:input-small form-control" />
											<form:errors path="description" cssClass="text-danger" />
										</div>
									</div>
								</div>
							</fieldset>
							<div class="invisible">
								<form:input id="category.id" path="category.id" type="text"
									value="${book.category.id}" class="form:input-small"
									readonly="true" />
								<form:errors path="category.id" cssClass="text-danger" />
								<form:input id="category.name" path="category.name" type="text"
									value="${book.category.name}" class="form:input-small"
									readonly="true" />
								<form:errors path="category.name" cssClass="text-danger" />
							</div>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success">
							<i class="fas fa-bullhorn"></i>&nbsp;PUBLISH NEW BOOK!
						</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<section class="container">
		<div class="row">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Name</th>
						<th scope="col">Author</th>
						<th scope="col">ISBN</th>
						<th scope="col">Price</th>
						<th scope="col">Category</th>
						<th scope="col">Description</th>
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
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
</body>
</html>
