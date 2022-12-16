<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div class="container-xxl flex-grow-1 container-p-y">
	<!-- list Product -->
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="nav-align-top mb-4">
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
													<h5 class="card-title">Order</h5>
													<div class="progress mb-1" style="height: 3px; width: 50%;">
														<div class="progress-bar bg-success" role="progressbar"
															style="width: 25%;" aria-valuenow="25" aria-valuemin="0"
															aria-valuemax="100"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="table-responsive text-nowrap">
											<table class="table">
												<thead>
													<tr>
														<th scope="col">UserID</th>
														<th scope="col">DeliveryID</th>
														<th scope="col">CommissionID</th>
														<th scope="col">Address</th>
														<th scope="col">Phone</th>
														<th scope="col">Status</th>
														<th scope="col">isPaidBefore</th>
														<th scope="col">amountFromUser</th>
														<th scope="col">Detail</th>
													</tr>
												</thead>
												<tbody class="table-border-bottom-0">
													<core:forEach items="${orders}" var="kq">
														<tr>
															<td>${kq.userId}</td>
															<td>${kq.deliveryId}</td>
															<td>${kq.commissionId}</td>
															<td>${kq.address}</td>
															<td>${kq.phone}</td>
															<td>${kq.status}</td>
															<core:if test="${kq.isPaidBefore == false}">
																<td>Chưa thanh toán</td>
															</core:if>
															<core:if test="${kq.isPaidBefore == true}">
																<td>Đã thanh toán</td>
															</core:if>
															<td>${kq.amountFromUser}</td>
															<td><a href="/WebEcommerce/vendor/order/detail?id=${kq.id}">Detail</a></td>
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
	</div>
</div>
