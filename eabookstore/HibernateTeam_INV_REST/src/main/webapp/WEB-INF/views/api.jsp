<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<style>
.code {
	max-width: 100px;
	max-height: 50px;
	overflow: hidden;
}
.code:hover {
	max-width: auto;
	max-height: auto;
}
</style>
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> Inventory REST Services </h1>
			</div>	 

		</div>	
	</section>
	
<div class="jumbotron container">
<p>Books in stock</p>
 <table class="table .table-dark">
  <thead>
    <tr>
      <th scope="col">Method</th>
      <th scope="col">URL</th>
      <th scope="col">Description</th>
      <th scope="col">Body</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">GET</th>
      <td>${base_url}/books</td>
      <td>Find all books that are in stock</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">GET</th>
      <td>${base_url}/books/{id}</td>
      <td>Find book with specific id</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">POST</th>
      <td>${base_url}/books</td>
      <td>Add new book in stock</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">PUT</th>
      <td>${base_url}/books/{id}</td>
      <td>Update book with specific id</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">POST</th>
      <td>${base_url}/books/{id}</td>
      <td>Update book with specific id</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">GET</th>
      <td>${base_url}/books/quantity/{id}</td>
      <td>Get quantity for specific book</td>
      <td></td>
    </tr>
  </tbody>
</table>	 	
</div>


<div class="jumbotron container">
<p>New Published Books</p>
 <table class="table .table-dark">
  <thead>
    <tr>
      <th scope="col">Method</th>
      <th scope="col">URL</th>
      <th scope="col">Description</th>
      <th scope="col">Body</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">GET</th>
      <td>${base_url}/newbooks</td>
      <td>Find all books that are in stock</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">GET</th>
      <td>${base_url}/newbooks/{id}</td>
      <td>Find book with specific id</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">POST</th>
      <td>${base_url}/newbooks</td>
      <td>Add new book in stock</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">PUT</th>
      <td>${base_url}/newbooks/{id}</td>
      <td>Update book with specific id</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">POST</th>
      <td>${base_url}/newbooks/{id}</td>
      <td>Update book with specific id</td>
      <td></td>
    </tr>
  </tbody>
</table>	 	
</div>

<div class="jumbotron container">
<p>Messaging</p>
 <table class="table .table-dark">
  <thead>
    <tr>
      <th scope="col">Method</th>
      <th scope="col">URL</th>
      <th scope="col">Description</th>
      <th scope="col">Body</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">GET</th>
      <td>${base_url}/msg/stockrequest/{isbn}/{qty}</td>
      <td>Request new stock from supplier</td>
      <td></td>
    </tr>
    <tr>
      <th scope="row">POST</th>
      <td>${base_url}/msg/newpublish</td>
      <td>Publish new book. Just for testing. Should be done by the Supplier</td>
      <td>
      </td>
    </tr>
    <tr>
      <th scope="row">GET</th>
      <td>${base_url}/msg/stockresponse/{isbn}/{qty}</td>
      <td>Respond new stock confirmation from supplier</td>
      <td></td>
    </tr>
  </tbody>
</table>	 	
</div>

</body>
</html>
