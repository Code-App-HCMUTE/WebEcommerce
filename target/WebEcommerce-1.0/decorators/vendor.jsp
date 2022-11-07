<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="dec"
		   uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/admin" var="URL"></c:url>
<!DOCTYPE html>
<html lang="en"
	 class="light-style layout-menu-fixed"
	 dir="ltr"
	 data-theme="theme-default"
	 data-assets-path="${URL}/assets/"
	 data-template="vertical-menu-template-free">
	<head>
		<!-- Site meta -->
		<meta charset="utf-8">
		<meta name="viewport"
			  content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>vendor</title>
		<!-- CSS -->
		<!-- Favicon -->
		<link rel="icon" type="image/x-icon" href="${URL}/assets/img/favicon/favicon.ico"/>

		<!-- Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com"/>
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
		<link
				href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
				rel="stylesheet"
		/>

		<!-- Icons. Uncomment required icon fonts -->
		<link rel="stylesheet" href="${URL}/assets/vendor/fonts/boxicons.css"/>

		<!-- Core CSS -->
		<link rel="stylesheet" href="${URL}/assets/vendor/css/core.css" class="template-customizer-core-css"/>
		<link rel="stylesheet" href="${URL}/assets/vendor/css/theme-default.css" class="template-customizer-theme-css"/>
		<link rel="stylesheet" href="${URL}/assets/css/demo.css"/>

		<!-- Vendors CSS -->
		<link rel="stylesheet" href="${URL}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>

		<link rel="stylesheet" href="${URL}/assets/vendor/libs/apex-charts/apex-charts.css"/>

		<!-- Page CSS -->

		<!-- Helpers -->
		<script src="${URL}/assets/vendor/js/helpers.js"></script>

		<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
		<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
		<script src="${URL}/assets/js/config.js"></script>
	</head>
	<body>
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<%--menu--%>
			<%@ include file="/common/vendor/menu.jsp" %>
			<div class="layout-page">
				<%--heeder--%>
				<%@ include file="/common/vendor/header.jsp" %>

				<div class="content-wrapper">
					<!-- body -->
					<dec:body/>
					<!--=== Footer v4 ===-->
					<%@ include file="/common/vendor/footer.jsp" %>
					<div class="content-backdrop fade"></div>
				</div>

			</div>
			<!-- body -->


		</div>
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	</div>
	<!--=== End Footer v4 ===-->
	<!-- JS -->
	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->
	<script src="${URL}/assets/vendor/libs/jquery/jquery.js"></script>
	<script src="${URL}/assets/vendor/libs/popper/popper.js"></script>
	<script src="${URL}/assets/vendor/js/bootstrap.js"></script>
	<script src="${URL}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

	<script src="${URL}/assets/vendor/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->
	<script src="${URL}/assets/vendor/libs/apex-charts/apexcharts.js"></script>

	<!-- Main JS -->
	<script src="${URL}/assets/js/main.js"></script>

	<!-- Page JS -->
	<script src="${URL}/assets/js/dashboards-analytics.js"></script>

	<!-- Place this tag in your head or just before your close body tag. -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	</body>
	</html>