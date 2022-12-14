<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div class="container-xxl flex-grow-1 container-p-y">
	<!-- list Product -->
	<div class="row">
		<div class="col-12">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#exampleModal">Rút tiền</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<form class="modal-content" action="Withdraw">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Rút tiền</h5>
						</div>
						<div class="modal-body">
							<h3>Nhập số tiền cần rút</h3>
							<input class="form-control"
								placeholder="Hãy nhập số tiền cần rút..." name="money" />
						</div>
						<div class="modal-footer">
							<button type="reset" class="btn btn-default"
								data-bs-dismiss="modal">Đóng</button>
							<button type="submit" class="btn btn-primary"
								data-bs-dismiss="modal">Rút</button>
						</div>
					</form>
				</div>
			</div>
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
													<h5 class="card-title">All Tracsaction</h5>
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
														<th scope="col">ID</th>
														<th scope="col">UserID</th>
														<th scope="col">IsUp</th>
														<th scope="col">Amount</th>
														<th scope="col">Created</th>
													</tr>
												</thead>
												<tbody class="table-border-bottom-0">
													<core:forEach items="${transactions}" var="kq">
														<tr>
															<th scope="row">${kq.id}</th>
															<td>${kq.userId}</td>
															<core:if test="${kq.isUp == false}">
																<td>Rút</td>
															</core:if>
															<core:if test="${kq.isUp == true}">
																<td>Nộp</td>
															</core:if>
															<td>${kq.amount}</td>
															<td>${kq.createdAt}</td>
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
