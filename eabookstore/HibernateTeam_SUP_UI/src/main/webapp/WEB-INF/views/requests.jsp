<%@ include file="includes/header.jsp"%>
<title>SUP-Purchase requests</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<i class="fas fa-clipboard-list"></i>&nbsp;Purchase request list
				</h1>
				<p>All purchases requests to us</p>
				<a class="btn btn-dark" href="<spring:url value="/books" />"><i
					class="fas fa-chevron-circle-left"></i>&nbsp;BACK</a>
			</div>

		</div>
	</section>

	<section class="container">
		<div class="row">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Quantity</th>
						<th scope="col">Status</th>
						<th scope="col">Control</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${requests}" var="request">
						<tr>
							<td>${request.book.name}</td>
							<td>${request.quantity}</td>
							<td><c:choose>
									<c:when test="${request.status.name=='CONFIRMED'}">
										<span class="badge badge-success">${request.status.name }</span>
									</c:when>
									<c:otherwise>
										<span class="badge badge-danger">${request.status.name }</span>
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${request.status.name=='PENDING'}">
										<button data-toggle="modal"
											data-target="#requestModal<c:out value='${request.id }' />"
											class="btn btn-outline-success" role="button">
											<i class="fas fa-check-circle"></i>&nbsp;CONFIRM
										</button>
									</c:when>
								</c:choose>
								<form:form action="/HibernateTeam_SUP_UI/requests/confirm/${request.id }" class="form-horizontal">
								<div class="modal fade"
									id="requestModal<c:out value='${request.id }' />" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Confirm
													request</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<div class="alert alert-danger" role="alert">
													<strongp>You are going to confirm this request:</strong>
												</div>
												<p>
													Book name: <strong>${request.book.name }</strong>
												</p>
												<p>
													Quantity: <strong>${request.quantity }</strong>
												</p>

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
												<button class="btn btn-success" type="submit">Continue</button>
											</div>
										</div>
									</div>
								</div>
								</form:form>
								</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
	</section>
	<%-- <section class="container">
		<div class="row">
			<c:forEach items="${requests}" var="request">
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">${request.book.name}&nbsp;<c:choose>
									<c:when test="${request.status.name=='CONFIRMED'}">
										<span class="badge badge-success">${request.status.name }</span>
									</c:when>
									<c:otherwise>
										<span class="badge badge-danger">${request.status.name }</span>
									</c:otherwise>
								</c:choose>
							</h5>
							<p class="card-text">
								Book name: ${request.book.name} <br /> Quantity:
								${request.quantity}
							</p>
							<c:choose>
								<c:when test="${request.status.name=='PENDING'}">
									<a tabindex="0" class="btn btn-outline-success" role="button"
										data-toggle="popover" data-trigger="focus" title="Confirm"
										data-content="And here's some amazing content. It's very engaging. Right?"><i
										class="fas fa-check-circle"></i>&nbsp;CONFIRM</a>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section> --%>
</body>
</html>
