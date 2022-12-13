<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-xxl">
	<div class="authentication-wrapper authentication-basic container-p-y">
		<div class="authentication-inner">
			<div class="card">
				<form role="form" action="AddProduct" method="post"
					enctype="multipart/form-data">
					<div class="form-group" style="margin: 10px;">
						<label>Tên sản phẩm: </label> <input class="form-control"
							placeholder="Hãy nhập tên san pham" name="name" />
					</div>
					<div class="form-group" style="margin: 10px;">
						<label>Mô tả:</label> <input class="form-control"
							placeholder="Hãy nhập mô tả" name="description" />
					</div>
					<div class="form-group" style="margin: 10px;">
						<label>Giá cả:</label> <input class="form-control"
							placeholder="Hãy nhập gia ca" name="price" />
					</div>
					<div class="form-group" style="margin: 10px;">
						<label>Giá khuyến mãi:</label> <input class="form-control"
							placeholder="Hãy nhập gia khuyen mai" name="promotionalprice" />
					</div>
					<div class="form-group" style="margin: 10px;">
						<label>Số lượng:</label> <input class="form-control"
							placeholder="Hãy nhập so luong" name="quantity" />
					</div>
					<div class="form-group" style="margin: 10px;">
						<label>Ảnh đại diện</label> <input type="file" name="images" />
					</div>

					<button type="submit" class="btn btn-default">Thêm</button>
					<button type="reset" class="btn btn-primary">Hủy</button>
				</form>
			</div>
		</div>
	</div>
</div>

