<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/vendor/product/edit?id=${product.id}" var="edit"></c:url>
<div class="container-xxl flex-grow-1 container-p-y">
	<!-- search product -->
	<div class="row">
		<div class="col-12 mb-4 order-0">
			<div class="card mb-4">
				<form role="form" action="${edit}" method="post"
					enctype="multipart/form-data">
					<input name="id" value="${product.id}" hidden="">
					<div class="form-group">
						<label>Tên sản phẩm: </label> <input class="form-control"
							placeholder="Hãy nhập tên sản phẩm" name="name"
							value="${product.name}" />
					</div>
					<div class="form-group">
						<label>Mô tả:</label>
						<textarea class="form-control" placeholder="Hãy nhập mô tả"
							name="description">${product.description}</textarea>
					</div>
					<div class="form-group">
						<label>Giá cả:</label> <input class="form-control"
							placeholder="Hãy nhập giá cả" name="price"
							value="${product.price}" />
					</div>
					<div class="form-group">
						<label>Giá khuyến mãi:</label> <input class="form-control"
							placeholder="Hãy nhập giá khuyến mãi" name="promotionalprice"
							value="${product.promotionalPrice}" />
					</div>
					<div class="form-group">
						<label>Số lượng:</label> <input class="form-control"
							placeholder="Hãy nhập số lượng" name="quantity"
							value="${product.quantity}" />
					</div>
					<div class="form-group">
						<label>Ảnh đại diện</label><br>
						<c:url value="/image?fname=product/${product.listImages}"
							var="imgUrl"></c:url>
						<img class="rounded-circle" height="200" width="200" id="image"
							width="100px" src="${imgUrl}" alt="">
						<input type="file"
							name="images" onchange="chooseFile(this, id = 'image')" />
					</div>
					<button type="reset" class="btn btn-default">Hủy</button>
					<button type="submit" class="btn btn-primary">Chỉnh sửa</button>
				</form>
			</div>
		</div>
	</div>
</div>
