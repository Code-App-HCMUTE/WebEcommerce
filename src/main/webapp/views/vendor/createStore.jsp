<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form role="form" action="CreateStore" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label>Tên Shop: </label> 
		<input class="form-control" placeholder="Hãy nhập tên shop" name="name" />
	</div>
	<div class="form-group">
		<label>Mô tả:</label> 
		<input class="form-control"	placeholder="Hãy nhập mô tả" name="bio" />
	</div>
	<div class="form-group">
		<label>Ảnh đại diện</label> <input type="file" name="avatar" />
	</div>
	<div class="form-group">
		<label>Ảnh bìa</label> <input type="file" name="cover" />
	</div>
	<div class="form-group">
		<label>Ảnh đặc trưng</label> <input type="file" name="featured_images" />
	</div>
	<button type="submit" class="btn btn-default">Thêm</button>
	<button type="reset" class="btn btn-primary">Hủy</button>
</form>
