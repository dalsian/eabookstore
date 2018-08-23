<%@ include file="includes/header.jsp"%>
<title>INV-Books Details</title>
</head>

<body>
	<div class="main">
		<div class="container">
			<div class="row justify-content-sm-center">
				<div class="col-sm-8">
					<h1>
						<i class="fas fa-book"></i> Book details
					</h1>
				</div>
				<div class="col-sm-4 ">
					<div class="alert alert-primary" role="alert">
						<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />,
  					<a href="<spring:url value='/dologout' />" class="alert-link">Logout</a>
						</security:authorize>

					</div>
				</div>
			</div>
		</div>
		<div class="jumbotron">
			<form:form modelAttribute="newBook" class="form-horizontal">
				<h3 class="display-4">
					<c:out value="${book.name}" />
				</h3>
				<span class="badge badge-info"><c:out
						value="${book.category.name}" /></span>
				<br />
				<p class="lead">
					<c:out value="${book.description}" />
				</p>
				<hr class="my-4">

				<div>
					<fieldset>
						<form:errors path="*" cssClass="alert alert-danger" element="div" />
						<div class="form-group">
							<label class="control-label col-sm-2" for="name"><spring:message
									code="updateBook.form.bookName.label" /></label>
							<div class="col-sm-10">
								<div class="form:input-prepend input-group mb-2 mr-sm-2">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fas fa-book"></i>
										</div>
									</div>
									<form:input id="name" path="name" type="text"
										value="${book.name}" class="form:input-small" readonly="true" />
									<form:errors path="name" cssClass="text-danger" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="author"><spring:message
									code="updateBook.form.bookAuthor.label" /></label>
							<div class="col-sm-10">
								<div class="form:input-prepend input-group mb-2 mr-sm-2">
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
							<label class="control-label col-sm-2" for="isbn"><spring:message
									code="updateBook.form.bookISBN.label" /></label>
							<div class="col-sm-10">
								<div class="form:input-prepend input-group mb-2 mr-sm-2">
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
							<label class="control-label col-sm-2" for="price"><spring:message
									code="updateBook.form.bookPrice.label" /></label>
							<div class="col-sm-10">
								<div class="form:input-prepend input-group mb-2 mr-sm-2">
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
							<label class="control-label col-sm-2" for="description"><spring:message
									code="updateBook.form.bookDescription.label" /></label>
							<div class="col-sm-10">
								<div class="form:input-prepend input-group mb-2 mr-sm-2">
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

						<div class="form-group">
							<label class="control-label col-sm-2" for="quantity"><spring:message
									code="updateBook.form.bookQuantity.label" /></label>
							<div class="col-sm-10">
								<div class="form:input-prepend input-group mb-2 mr-sm-2">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fas fa-hashtag"></i>
										</div>
									</div>
									<form:input id="quantity" path="quantity" type="text"
										value="${book.quantity}" class="form:input-small" readonly="true"
										 />
									&nbsp;
									<button type="button" class="btn btn-outline-success btn-sm"
										data-toggle="modal" data-target="#exampleModalCenter">
										<i class="fas fa-plus"></i>
									</button>
									<form:errors path="quantity" cssClass="text-danger" />
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
							/>
						<form:errors path="category.name" cssClass="text-danger" />
						<form:input id="status.id" path="status.id" type="text"
							value="${book.status.id}" class="form:input-small"
							readonly="true" />
						<form:errors path="status.id" cssClass="text-danger" />
						<form:input id="status.name" path="status.name" type="text"
							value="${book.status.name}" class="form:input-small"
							readonly="true" />
						<form:errors path="status.name" cssClass="text-danger" />
						<form:input id="quantity" path="quantity" type="text"
							value="${book.quantity}" class="form:input-small"
							readonly="true" />
						<form:errors path="quantity" cssClass="text-danger" />
					</div>
				</div>
				<div class="lead">
					<div class="btn-group" role="group" aria-label="Basic example">
						<a class="btn btn-light btn-sm"
							href="<spring:url value='/books' />" role="button"><i
							class="fas fa-chevron-left"></i> Back</a> <input
							class="btn btn-info btn-sm" type="submit" value="Save changes" />
					</div>
				</div>

			</form:form>
		</div>


		<!-- Modal -->
		<form:form modelAttribute="newBook"
			action="/HibernateTeam_INV_UI/books/${book.id}/request"
			class="form-horizontal">
			<div class="modal fade" id="exampleModalCenter" tabindex="-1"
				role="dialog" aria-labelledby="modelTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="modelTitle">Request to suppliers
								for quantity</h5>
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
										<form:input id="name" path="name" type="text"
											value="${book.name}" class="form:input-small" readonly="true" />
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
										<form:input id="quantity" path="quantity" type="text" value="${book.quantity}"
											class="form:input-small"/>
										<form:errors path="quantity" cssClass="text-danger" />
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<security:authorize access="hasRole('ROLE_ADMIN')">
								<input type="submit" class="btn btn-info" value="Send request" />
							</security:authorize>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>