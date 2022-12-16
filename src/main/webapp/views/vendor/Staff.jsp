<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<section>
	<div class="container py-5 h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-10">
				<div class="card" style="border-radius: 15px;">
					<h3 style="text-align: center;">Thông tin chủ cửa hàng</h3>
					<div class="card-body p-4">
						<div class="d-flex text-black">
							<div class="card testimonial-card flex-grow-1">
								<div class="card-up"
									style="background-color: #ccc; height: 200px; overflow: hidden; border-top-left-radius: 0.25rem; border-top-right-radius: 0.25rem;">
									<core:url value="/image?fname=user/${owner.cover}"
										var="imgUrl"></core:url>
									<img
										src="${imgUrl}" alt="Cover"
										width="100%" height="100%" style="object-fit: cover;" />
								</div>
								<div class="avatar mx-auto bg-white"
									style="width: 200px; height: 200px; margin-top: -60px; overflow: hidden; border: 3px solid #fff; border-radius: 50%;">
									<core:url value="/image?fname=user/${owner.avatar}"
										var="imgUrl"></core:url>
									<img src="${imgUrl}" alt="Avatar"
										class="rounded-circle img-fluid" />
								</div>
							</div>
							<div class="flex-grow-2 ms-4">
								<div class="mb-3">
									<label for="exampleFormControlInput1" class="form-label">Họ
										và tên</label> <input class="form-control"
										id="exampleFormControlInput1" placeholder="Họ và tên"
										name="name" value="${owner.fistName} ${owner.lastName}"
										disabled />
								</div>
								<div class="mb-3">
									<label for="exampleFormControlInput1" class="form-label">Địa
										chỉ</label> <input class="form-control" id="exampleFormControlInput1"
										placeholder="Địa chỉ" name="name" value="${owner.address}"
										disabled />
								</div>
								<div class="mb-3">
									<label for="exampleFormControlInput1" class="form-label">Số
										điện thoại</label> <input class="form-control"
										id="exampleFormControlInput1" placeholder="Số điện thoại"
										name="name" value="${owner.phone}" disabled />
								</div>
								<div class="mb-3">
									<label for="exampleFormControlInput1" class="form-label">Email</label>
									<input class="form-control" id="exampleFormControlInput1"
										placeholder="Email" name="name" value="${owner.email}"
										disabled />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<h3 style="text-align: center;">Thông tin nhân viên cửa hàng</h3>

<section>
	<div class="container py-5 h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<core:if test="${staff == 0}">
				<div class="col-10">
					<h3>Không có nhân viên trong cửa hàng</h3>
					<a href="/WebEcommerce/vendor/addStaff">
						<button type="button"
							class="btn btn-success me-3 d-flex align-items-center text-nowrap">
							<i class="bx bx-plus me-1"></i>Thêm nhân viên
						</button>
					</a>
				</div>
			</core:if>
			<core:if test="${staff == 1}">
				<div class="col-8">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Họ
							và tên</label> <input class="form-control" id="exampleFormControlInput1"
							placeholder="Họ và tên" name="name"
							value="${nv.fistName} ${nv.lastName}" disabled />
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Địa
							chỉ</label> <input class="form-control" id="exampleFormControlInput1"
							placeholder="Địa chỉ" name="name" value="${nv.address}" disabled />
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Số
							điện thoại</label> <input class="form-control"
							id="exampleFormControlInput1" placeholder="Số điện thoại"
							name="name" value="${nv.phone}" disabled />
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Email</label>
						<input class="form-control" id="exampleFormControlInput1"
							placeholder="Email" name="name" value="${nv.email}" disabled />
					</div>
				</div>
			</core:if>
		</div>
	</div>
</section>