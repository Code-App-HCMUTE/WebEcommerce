<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<table class="table caption-top">
	<caption>List of products</caption>
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Ten san pham</th>
			<th scope="col">Mo ta</th>
			<th scope="col">Gia goc</th>
			<th scope="col">Gia khuyen mai</th>
			<th scope="col">So Luong</th>
			<th scope="col">Anh</th>
			<th scope="col">Edit</th>
			<th scope="col">Delete</th>
		</tr>
	</thead>
	<tbody>
		<core:forEach items="${products}" var="kq">
			<tr>
				<th scope="row">${kq.id}</th>
				<td>${kq.name}</td>
				<td>${kq.description}</td>
				<td>${kq.price}</td>
				<td>${kq.promotionalPrice}</td>
				<td>${kq.quantity}</td>
				<td><core:url value="/image?fname=product/${kq.listImages}"
						var="imgUrl"></core:url> <img class="card-img-top" width="200px"
					height="200px" src="${imgUrl}" alt="Card image cap"></td>
				<td><a href="/WebEcommerce/admin/product/edit?id=${kq.id}">Edit</a></td>
				<td><a href="/WebEcommerce/admin/product/delete?id=${kq.id}">Delete</a></td>
			</tr>
		</core:forEach>
	</tbody>
</table>


