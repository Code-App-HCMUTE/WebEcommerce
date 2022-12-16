<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div class="container-xxl flex-grow-1 container-p-y">
	<main>
		<div class="row g-5">
			<div class="col-md-5 col-lg-4 order-md-last">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-primary">Sản Phẩm</span>
				</h4>
				<ul class="list-group mb-3">
					<core:forEach items="${products}" var="kq">
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<h6 class="my-0">Tên sản phẩm: ${kq.name}</h6>
								<small class="text-muted">Mô tả: ${kq.description}</small>
							</div> <span class="text-muted">Chi phí: ${kq.price}đ</span>
						</li>
					</core:forEach>
				</ul>
			</div>
			<div class="col-md-7 col-lg-8">
				<h4 class="mb-3">Thông tin khách hàng</h4>
				<form class="needs-validation" novalidate>
					<div class="row g-3">
						<div class="col-sm-6">
							<label for="firstName" class="form-label">First name</label> <input
								type="text" class="form-control" id="firstName" placeholder=""
								value="${user.firstName}" disabled>
						</div>

						<div class="col-sm-6">
							<label for="lastName" class="form-label">Last name</label> <input
								type="text" class="form-control" id="lastName" placeholder=""
								value="${user.lastName}" disabled>
						</div>

						<div class="col-12">
							<label for="email" class="form-label">Email <span
								class="text-muted">(Optional)</span></label> <input type="email"
								disabled class="form-control" id="email"
								placeholder="you@example.com" value="${user.email}">
						</div>

						<div class="col-12">
							<label for="address" class="form-label">Address</label> <input
								type="text" class="form-control" id="address" disabled
								placeholder="1234 Main St" required value="${user.address}">
						</div>
					</div>
				</form>
				<form action="detail" method="post" enctype="multipart/form-data" role="form">
					<div class="mb-3">
						<label for="exampleFormControlSelect1" class="form-label">Trạng
							thái đơn hàng</label> <select class="form-select"
							id="exampleFormControlSelect1" name="status"
							aria-label="Thể Loại">
							<option>Chọn Thể Loại</option>
							<option selected value="${order.status}">${order.status}</option>
							<option value="notprocessed">not processed</option>
							<option value="processing">processing</option>
							<option value="shipped">shipped</option>
							<option value="delivered">delivered</option>
							<option value="cancelled">cancelled</option>
						</select>
					</div>
					<button type="submit" class="btn btn-success me-3 d-flex align-items-center text-nowrap">
						Cập nhập trạng thái
					</button>
				</form>
			</div>
		</div>
	</main>
</div>
