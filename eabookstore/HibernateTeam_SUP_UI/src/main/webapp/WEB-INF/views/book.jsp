<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<spring:url value="/resource/js/controllers.js"/>"></script>
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Books</h1>
			</div>
		</div>
		
		<div class="container">
			<a href="<spring:url value="/items/add" />" class="btn btn-default pull-right">Load Purchase List</a>	
			<a href="<spring:url value="/items" />" class="btn btn-default pull-right">Purchase List</a>	
			<br>
			<a href="<spring:url value="/books/add" />" class="btn btn-default pull-right">Publish Book</a>	
			<a href="<spring:url value="/books/all" />" class="btn btn-default pull-right">Published Books</a>			
		</div>	  
	</section>
	<section class="container">

		<div class="row">

			<div class="col-md-5">
				<h3>${book.name}</h3>
				<p>${book.description}</p>
				<h4>${book.price}USD</h4>
				<p ng-controller="cartCtrl">

					<a href="<spring:url value="/books" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
		</div>
	</section>
</body>
</html>
