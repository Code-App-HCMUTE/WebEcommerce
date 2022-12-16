<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
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
					<div class="form-group" style="margin: 15px;">
						<label for="exampleFormControlSelect1" class="form-label">Commission</label>
						<select class="form-select" id="exampleFormControlSelect1"
							name="commission" aria-label="Thể Loại">
							<option>Chọn Commission</option>
							<core:forEach items="${commissions}" var="kq">
								<option value="${kq.id}">${kq.name}</option>
							</core:forEach>
						</select>
					</div>
					<div style="margin: 15px;">
						<button type="reset" class="btn btn-default">
							<a href="/WebEcommerce/home">Hủy</a>
						</button>
						<button type="submit" class="btn btn-primary">Thêm</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
