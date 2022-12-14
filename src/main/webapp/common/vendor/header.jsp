<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/templates/admin" var="URL"></c:url>
<nav
	class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
	id="layout-navbar">
	<div
		class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
		<a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
			<i class="bx bx-menu bx-sm"></i>
		</a>
	</div>

	<div class="navbar-nav-right d-flex align-items-center"
		id="navbar-collapse">

		<ul class="navbar-nav flex-row align-items-center ms-auto">
			<!-- Place this tag where you want the button to render. -->

			<!-- User -->
			<li class="nav-item navbar-dropdown dropdown-user dropdown"><a
				class="nav-link dropdown-toggle hide-arrow"
				href="javascript:void(0);" data-bs-toggle="dropdown">
					<div class="avatar avatar-online">
						<c:url value="/image?fname=user/${account.getAvatar()}"
							var="imgUrl"></c:url>
						<img src="${imgUrl}" alt="Avatar"
							class="w-px-40 h-auto rounded-circle" />
					</div>
			</a>
				<ul class="dropdown-menu dropdown-menu-end">
					<li><a class="dropdown-item" href="#">
							<div class="d-flex">
								<div class="flex-shrink-0 me-3">
									<div class="avatar avatar-online">
										<c:url value="/image?fname=user/${account.getAvatar()}"
											var="imgUrl"></c:url>
										<img src="${imgUrl}" alt="Avatar"
											class="w-px-40 h-auto rounded-circle" />
									</div>
								</div>
								<div class="flex-grow-1">
									<span class="fw-semibold d-block">${account.getFistName()}
										${account.getLastName()}</span> <small class="text-muted">Vendor</small>
								</div>
							</div>
					</a></li>
					<li>
						<form action="/WebEcommerce/vendor/home" method="POST">
							<button href="/WebEcommerce/auth/login" style="border: none;">
								<i class="bx bx-power-off me-2"></i>Đăng xuất
							</button>
						</form>
					</li>
				</ul></li>
			<!--/ User -->
		</ul>
	</div>
</nav>
