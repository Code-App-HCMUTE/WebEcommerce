<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div class="container-xxl flex-grow-1 container-p-y">
	<!-- list Product -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="nav-align-top mb-4">
					<!-- tab product -->
					<div class="card-header p-3">
						<ul class="nav nav-pills mb-3" role="tablist">
							<!-- tab all product -->
							<li class="nav-item">
								<button type="button" class="nav-link active" role="tab"
									data-bs-toggle="tab"
									data-bs-target="#navs-pills-top-product-all"
									aria-controls="navs-pills-top-product-all" aria-selected="true">
									Tất Cả</button>
							</li>
							<!-- tab working -->
							<li class="nav-item">
								<button type="button" class="nav-link" role="tab"
									data-bs-toggle="tab" data-bs-target="#navs-pills-top-working"
									aria-controls="navs-pills-top-working" aria-selected="false">
									Đang Hoạt Động</button>
							</li>
							<!-- tab out of stock -->
							<li class="nav-item">
								<button type="button" class="nav-link" role="tab"
									data-bs-toggle="tab"
									data-bs-target="#navs-pills-top-out-of-stock"
									aria-controls="navs-pills-top-out-of-stock"
									aria-selected="false">
									Hết Hàng
									<!-- <span class="badge rounded-pill badge-center h-px-20 w-px-20 bg-danger">3</span> -->
								</button>
							</li>
							<!-- tab  stock -->
							<li class="nav-item">
								<button type="button" class="nav-link" role="tab"
									data-bs-toggle="tab"
									data-bs-target="#navs-pills-top-un-out-of-stock"
									aria-controls="navs-pills-top-un-out-of-stock"
									aria-selected="false">
									Còn Hàng
									<!-- <span class="badge rounded-pill badge-center h-px-20 w-px-20 bg-danger">3</span> -->
								</button>
							</li>
							<!-- tab hidden -->
							<li class="nav-item">
								<button type="button" class="nav-link" role="tab"
									data-bs-toggle="tab"
									data-bs-target="#navs-pills-top-out-of-Hidden"
									aria-controls="navs-pills-top-out-of-Hidden"
									aria-selected="false">
									Đã Ẩn
									<!-- <span class="badge rounded-pill badge-center h-px-20 w-px-20 bg-danger">3</span> -->
								</button>
							</li>
						</ul>
					</div>
					<div class="card-body">
						<div class="tab-content p-0">
							<!-- all product -->
							<div class="tab-pane fade show active"
								id="navs-pills-top-product-all" role="tabpanel">
								<div class="row">
									<div class="card p-0">
										<div class="card-header p-1">
											<div class="row">
												<div
													class="col-6 d-flex flex-column align-items-start justify-content-start">
													<h5 class="card-title">Sản Phẩm</h5>
													<div class="progress mb-1" style="height: 3px; width: 50%;">
														<div class="progress-bar bg-success" role="progressbar"
															style="width: 25%;" aria-valuenow="25" aria-valuemin="0"
															aria-valuemax="100"></div>
													</div>
												</div>
												<div
													class="col-6 d-flex align-items-center justify-content-end">
													<form action="searchproduct"
														class="form-inline my-2 my-lg-0">
														<input type="text" name="txt" value=""
															class="form-control" placeholder="Search...">
													</form>
													<a href="/WebEcommerce/vendor/AddProduct">
														<button type="button"
															class="btn btn-success me-3 d-flex align-items-center text-nowrap">
															<i class="bx bx-plus me-1"></i>Thêm sản Phẩm
														</button>
													</a>
												</div>
											</div>
										</div>
										<div class="table-responsive text-nowrap">
											<table class="table">
												<thead>
													<tr>
														<th></th>
														<th scope="col">ID</th>
														<th scope="col">Tên sản phẩm</th>
														<th scope="col">Mô tả</th>
														<th scope="col">Giá gốc</th>
														<th scope="col">Giá khuyến mãi</th>
														<th scope="col">Số lượng</th>
														<th scope="col">Ảnh</th>
													</tr>
												</thead>
												<tbody class="table-border-bottom-0">
													<core:forEach items="${products}" var="kq">
														<tr>
															<td><input class="form-check-input" type="checkbox"
																value="" id="flexCheckDefault"></td>
															<th scope="row">${kq.id}</th>
															<td>${kq.name}</td>
															<td>${kq.description}</td>
															<td>${kq.price}</td>
															<td>${kq.promotionalPrice}</td>
															<td>${kq.quantity}</td>
															<td><core:url
																	value="/image?fname=product/${kq.listImages}"
																	var="imgUrl"></core:url> <img class="img-thumbnail"
																src="${imgUrl}" height="50px" width="50px"
																alt="Card image cap"></td>
															<td>
																<div class="dropdown">
																	<button type="button"
																		class="btn p-0 dropdown-toggle hide-arrow"
																		data-bs-toggle="dropdown">
																		<i class="bx bx-dots-vertical-rounded"></i>
																	</button>
																	<div class="dropdown-menu">
																		<a class="dropdown-item"
																			href="/WebEcommerce/vendor/product/edit?id=${kq.id}"><i
																			class="bx bx-edit-alt me-1"></i> Sửa</a> <a
																			class="dropdown-item"
																			href="/WebEcommerce/vendor/product/delete?id=${kq.id}"><i
																			class="bx bx-trash me-1"></i> Xóa</a>
																	</div>
																</div>
															</td>
														</tr>
													</core:forEach>
												</tbody>
											</table>
										</div>
									</div>
									<!--/ Basic Bootstrap Table -->
								</div>
							</div>
							<!-- working -->
							<div class="tab-pane fade" id="navs-pills-top-working"
								role="tabpanel">
								<div class="table-responsive text-nowrap">
									<table class="table">
										<thead>
											<tr>
												<th></th>
												<th scope="col">ID</th>
												<th scope="col">Tên sản phẩm</th>
												<th scope="col">Mô tả</th>
												<th scope="col">Giá gốc</th>
												<th scope="col">Giá khuyến mãi</th>
												<th scope="col">Số lượng</th>
												<th scope="col">Ảnh</th>
											</tr>
										</thead>
										<tbody class="table-border-bottom-0">
											<core:forEach items="${productactive}" var="kq">
												<tr>
													<td><input class="form-check-input" type="checkbox"
														value="" id="flexCheckDefault"></td>
													<th scope="row">${kq.id}</th>
													<td>${kq.name}</td>
													<td>${kq.description}</td>
													<td>${kq.price}</td>
													<td>${kq.promotionalPrice}</td>
													<td>${kq.quantity}</td>
													<td><core:url
															value="/image?fname=product/${kq.listImages}"
															var="imgUrl"></core:url> <img class="img-thumbnail"
														src="${imgUrl}" height="50px" width="50px"
														alt="Card image cap"></td>
													<td>
														<div class="dropdown">
															<button type="button"
																class="btn p-0 dropdown-toggle hide-arrow"
																data-bs-toggle="dropdown">
																<i class="bx bx-dots-vertical-rounded"></i>
															</button>
															<div class="dropdown-menu">
																<a class="dropdown-item"
																	href="/WebEcommerce/vendor/product/edit?id=${kq.id}"><i
																	class="bx bx-edit-alt me-1"></i> Sửa</a> <a
																	class="dropdown-item"
																	href="/WebEcommerce/vendor/product/delete?id=${kq.id}"><i
																	class="bx bx-trash me-1"></i> Xóa</a>
															</div>
														</div>
													</td>
												</tr>
											</core:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- stock -->
							<div class="tab-pane fade" id="navs-pills-top-out-of-stock"
								role="tabpanel">
								<div class="table-responsive text-nowrap">
									<table class="table">
										<thead>
											<tr>
												<th></th>
												<th scope="col">ID</th>
												<th scope="col">Tên sản phẩm</th>
												<th scope="col">Mô tả</th>
												<th scope="col">Giá gốc</th>
												<th scope="col">Giá khuyến mãi</th>
												<th scope="col">Số lượng</th>
												<th scope="col">Ảnh</th>
											</tr>
										</thead>
										<tbody class="table-border-bottom-0">
											<core:forEach items="${productnoquantity}" var="kq">
												<tr>
													<td><input class="form-check-input" type="checkbox"
														value="" id="flexCheckDefault"></td>
													<th scope="row">${kq.id}</th>
													<td>${kq.name}</td>
													<td>${kq.description}</td>
													<td>${kq.price}</td>
													<td>${kq.promotionalPrice}</td>
													<td>${kq.quantity}</td>
													<td><core:url
															value="/image?fname=product/${kq.listImages}"
															var="imgUrl"></core:url> <img class="img-thumbnail"
														src="${imgUrl}" height="50px" width="50px"
														alt="Card image cap"></td>
													<td>
														<div class="dropdown">
															<button type="button"
																class="btn p-0 dropdown-toggle hide-arrow"
																data-bs-toggle="dropdown">
																<i class="bx bx-dots-vertical-rounded"></i>
															</button>
															<div class="dropdown-menu">
																<a class="dropdown-item"
																	href="/WebEcommerce/vendor/product/edit?id=${kq.id}"><i
																	class="bx bx-edit-alt me-1"></i> Sửa</a> <a
																	class="dropdown-item"
																	href="/WebEcommerce/vendor/product/delete?id=${kq.id}"><i
																	class="bx bx-trash me-1"></i> Xóa</a>
															</div>
														</div>
													</td>
												</tr>
											</core:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- Còn hàng -->
							<div class="tab-pane fade" id="navs-pills-top-un-out-of-stock"
								role="tabpanel">
								<div class="table-responsive text-nowrap">
									<table class="table">
										<thead>
											<tr>
												<th></th>
												<th scope="col">ID</th>
												<th scope="col">Tên sản phẩm</th>
												<th scope="col">Mô tả</th>
												<th scope="col">Giá gốc</th>
												<th scope="col">Giá khuyến mãi</th>
												<th scope="col">Số lượng</th>
												<th scope="col">Ảnh</th>
											</tr>
										</thead>
										<tbody class="table-border-bottom-0">
											<core:forEach items="${productquantity}" var="kq">
												<tr>
													<td><input class="form-check-input" type="checkbox"
														value="" id="flexCheckDefault"></td>
													<th scope="row">${kq.id}</th>
													<td>${kq.name}</td>
													<td>${kq.description}</td>
													<td>${kq.price}</td>
													<td>${kq.promotionalPrice}</td>
													<td>${kq.quantity}</td>
													<td><core:url
															value="/image?fname=product/${kq.listImages}"
															var="imgUrl"></core:url> <img class="img-thumbnail"
														src="${imgUrl}" height="50px" width="50px"
														alt="Card image cap"></td>
													<td>
														<div class="dropdown">
															<button type="button"
																class="btn p-0 dropdown-toggle hide-arrow"
																data-bs-toggle="dropdown">
																<i class="bx bx-dots-vertical-rounded"></i>
															</button>
															<div class="dropdown-menu">
																<a class="dropdown-item"
																	href="/WebEcommerce/vendor/product/edit?id=${kq.id}"><i
																	class="bx bx-edit-alt me-1"></i> Sửa</a> <a
																	class="dropdown-item"
																	href="/WebEcommerce/vendor/product/delete?id=${kq.id}"><i
																	class="bx bx-trash me-1"></i> Xóa</a>
															</div>
														</div>
													</td>
												</tr>
											</core:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- hidden -->
							<div class="tab-pane fade" id="navs-pills-top-out-of-Hidden"
								role="tabpanel">
								<div class="table-responsive text-nowrap">
									<table class="table">
										<thead>
											<tr>
												<th></th>
												<th scope="col">ID</th>
												<th scope="col">Tên sản phẩm</th>
												<th scope="col">Mô tả</th>
												<th scope="col">Giá gốc</th>
												<th scope="col">Giá khuyến mãi</th>
												<th scope="col">Số lượng</th>
												<th scope="col">Ảnh</th>
											</tr>
										</thead>
										<tbody class="table-border-bottom-0">
											<core:forEach items="${productunactive}" var="kq">
												<tr>
													<td><input class="form-check-input" type="checkbox"
														value="" id="flexCheckDefault"></td>
													<th scope="row">${kq.id}</th>
													<td>${kq.name}</td>
													<td>${kq.description}</td>
													<td>${kq.price}</td>
													<td>${kq.promotionalPrice}</td>
													<td>${kq.quantity}</td>
													<td><core:url
															value="/image?fname=product/${kq.listImages}"
															var="imgUrl"></core:url> <img class="img-thumbnail"
														src="${imgUrl}" height="50px" width="50px"
														alt="Card image cap"></td>
													<td>
														<div class="dropdown">
															<button type="button"
																class="btn p-0 dropdown-toggle hide-arrow"
																data-bs-toggle="dropdown">
																<i class="bx bx-dots-vertical-rounded"></i>
															</button>
															<div class="dropdown-menu">
																<a class="dropdown-item"
																	href="/WebEcommerce/vendor/product/edit?id=${kq.id}"><i
																	class="bx bx-edit-alt me-1"></i> Sửa</a> <a
																	class="dropdown-item"
																	href="/WebEcommerce/vendor/product/delete?id=${kq.id}"><i
																	class="bx bx-trash me-1"></i> Xóa</a>
															</div>
														</div>
													</td>
												</tr>
											</core:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
