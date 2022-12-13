<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-xxl">
	<div class="authentication-wrapper authentication-basic container-p-y">
		<div class="authentication-inner">
			<div class="card">

				<form role="form" action="CreateStore" method="post"
					enctype="multipart/form-data">
					<div class="form-group" style="margin: 10px;">
						<label>Tên Shop: </label> <input class="form-control"
							placeholder="Hãy nhập tên shop" name="name" />
					</div>
					<div class="form-group" style="margin: 10px;">
						<label>Mô tả:</label> <input class="form-control"
							placeholder="Hãy nhập mô tả" name="bio" />
					</div>
					<div class="form-group" style="margin: 15px;">
						<label>Ảnh đại diện</label> <input type="file" name="avatar" />
					</div>
					<div class="form-group" style="margin: 15px;">
						<label>Ảnh bìa</label> <input type="file" name="cover" />
					</div>
					<div class="form-group" style="margin: 15px;">
						<label>Ảnh đặc trưng</label> <input type="file"
							name="featured_images" />
					</div>
					<button type="reset" class="btn btn-default">Hủy</button>
					<button type="submit" class="btn btn-primary">Thêm</button>
				</form>
			</div>
		</div>
	</div>
</div>
