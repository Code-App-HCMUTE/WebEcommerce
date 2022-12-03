<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form role="form" action="AddProduct" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label>Tên san pham: </label> 
		<input class="form-control" placeholder="Hãy nhập tên san pham" name="name" />
	</div>
	<div class="form-group">
		<label>Mô tả:</label> 
		<input class="form-control"	placeholder="Hãy nhập mô tả" name="description" />
	</div>
	<div class="form-group">
		<label>Gia ca:</label> 
		<input class="form-control"	placeholder="Hãy nhập gia ca" name="price" />
	</div>
	<div class="form-group">
		<label>Gia khuyen mai:</label> 
		<input class="form-control"	placeholder="Hãy nhập gia khuyen mai" name="promotionalprice" />
	</div>
	<div class="form-group">
		<label>So luong:</label> 
		<input class="form-control"	placeholder="Hãy nhập so luong" name="quantity" />
	</div>
	<div class="form-group">
		<label>Ảnh đại diện</label> <input type="file" name="images" />
	</div>
	
	<button type="submit" class="btn btn-default">Thêm</button>
	<button type="reset" class="btn btn-primary">Hủy</button>
</form>
    