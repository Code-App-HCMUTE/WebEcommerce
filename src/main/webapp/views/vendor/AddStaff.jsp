<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/templates/admin" var="URL"></c:url>
<div class="container-xxl">
	<div class="authentication-wrapper authentication-basic container-p-y">
		<div class="authentication-inner">
			<!-- Register Card -->
			<div class="card">

				<form id="formAuthentication" class="mb-3" action="addStaff" method="POST" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="username" class="form-label">First name</label> <input
							type="text" class="form-control" id="username" name="firstname"
							placeholder="Enter your first name" autofocus />
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Last Name</label> <input
							type="text" class="form-control" id="username" name="lastname"
							placeholder="Enter your last name" autofocus />
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Phone</label> <input
							type="text" class="form-control" id="phone" name="phone"
							placeholder="Enter your phone" autofocus />
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="text" class="form-control" id="email" name="email"
							placeholder="Enter your email" />
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Address</label> <input
							type="text" class="form-control" id="email" name="address"
							placeholder="Enter your address" />
					</div>
					<button class="btn btn-default" type="reset">Hủy</button>
					<button class="btn btn-primary" type="submit">Xác nhận</button>
				</form>
			</div>
		</div>
	</div>
</div>