<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:url value="/vendor/infor" var="edit"></core:url>
<div class="container-xxl flex-grow-1 container-p-y">
	<!-- search product -->
	<div class="row">
		<div class="col-12 mb-4 order-0">
			<div class="card mb-4">
				<div class="card-header">
					<h5 class="">Hồ Sơ Shop</h5>
					<small class=" text-muted">xem tình trạng của shop và cập
						nhật hồ sơ của shop</small>
				</div>
				<form role="form" action="${edit}" method="post"
					enctype="multipart/form-data">
					<div class="card-body">
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Tên
								Shop</label> <input class="form-control"
								id="exampleFormControlInput1" placeholder="Tên Shop..." name="name"
								value="${store.name}" />
						</div>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Ảnh
								đại diện Shop</label>
							<div class="row">
								<div class="col-2">
									<core:url value="/image?fname=store/${store.avatar}" var="imgUrl"></core:url>
									<img src="${imgUrl}" class="rounded-circle" id="avatar"
										style="width: 150px;" alt="Avatar" />
								</div>
								<div class="col-5">
									<div class="mt-3">
										<input class="form-control" type="file" id="formFile"
											onchange="chooseFile(this, id = 'avatar')" name="avatar">
									</div>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">ảnh
								bìa</label>
							<div class="row">
								<div class="col-2">
									<core:url value="/image?fname=store/${store.cover}" var="imgUrl"></core:url>
									<img src="${imgUrl}" id="cover" class="rounded float-start"
										height="100" width="100" alt="...">
								</div>
								<div class="col-5">
									<div class="mt-3">
										<input class="form-control" type="file" id="formFile" name="cover"
											onchange="chooseFile(this, id = 'cover')">
									</div>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">ảnh
								đặt trưng</label>
							<div class="row">
								<div class="col-2">
									<core:url value="/image?fname=store/${store.featured_images}"
										var="imgUrl"></core:url>
									<img src="${imgUrl}" class="rounded float-start" height="100"
										width="100" alt="..." id="feature">
								</div>
								<div class="col-5">
									<div class="mt-3">
										<input class="form-control" type="file" id="formFile" name="feature"
											onchange="chooseFile(this, id = 'feature')">
									</div>
								</div>
							</div>
						</div>
						<div class="mb-3">
							<label for="exampleFormControlReadOnlyInput1" class="form-label">Mô
								Tả Shop</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3" placeholder="Mô tả..." name="description">${store.bio}</textarea>
						</div>
						<button type="reset" class="btn btn-default">Hủy</button>
						<button type="submit" class="btn btn-primary">Lưu</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>