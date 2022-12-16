<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<c:url value="/templates/customer" var="URL"></c:url>
			<!DOCTYPE html>
			<html>

			<head>
				<!-- Site meta -->
				<meta charset="utf-8">
				<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
				<title>home</title>
				<!-- CSS -->
				<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
					rel="stylesheet">

				<!-- Css Styles -->
				<link rel="stylesheet" href="${URL}/css/bootstrap.min.css" type="text/css">
				<!-- <link rel="stylesheet" href="${URL}/css/font-awesome.min.css" type="text/css"> -->
				<link rel="stylesheet" href="${URL}/css/elegant-icons.css" type="text/css">
				<link rel="stylesheet" href="${URL}/css/nice-select.css" type="text/css">
				<link rel="stylesheet" href="${URL}/css/jquery-ui.min.css" type="text/css">
				<link rel="stylesheet" href="${URL}/css/owl.carousel.min.css" type="text/css">
				<link rel="stylesheet" href="${URL}/css/slicknav.min.css" type="text/css">
				<link rel="stylesheet" href="${URL}/css/style.css" type="text/css">
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
                    <script>
                        function chooseFile(fileinput, id)
                        {
                            if(fileinput.files && fileinput.files[0]){
                                var reader = new FileReader();
                                reader.onload=function (e){
                                    $('#'+id).attr('src',e.target.result);
                                }
                                reader.readAsDataURL(fileinput.files[0])
                            }
                        }
                    </script>
			</head>

			<body>
				<%@ include file="/common/web/header.jsp" %>
					<!-- body -->
					<dec:body />
					<!-- body -->
					<!--=== Footer v4 ===-->
					<jsp:include page="/common/web/footer.jsp"></jsp:include>
					<!--=== End Footer v4 ===-->
					<!-- JS -->
					<script src="https://kit.fontawesome.com/babdaf3a12.js" crossorigin="anonymous"></script>
					<script src="${URL}/js/jquery-3.3.1.min.js"></script>
					<script src="${URL}/js/bootstrap.min.js"></script>
					<script src="${URL}/js/jquery.nice-select.min.js"></script>
					<script src="${URL}/js/jquery-ui.min.js"></script>
					<script src="${URL}/js/jquery.slicknav.js"></script>
					<script src="${URL}/js/mixitup.min.js"></script>
					<script src="${URL}/js/owl.carousel.min.js"></script>
					<script src="${URL}/js/main.js"></script>

			</html>