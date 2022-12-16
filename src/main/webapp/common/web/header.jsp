<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/templates/customer" var="URL"></c:url>
<!-- Page Preloder -->
<div id="preloder">
	<div class="loader"></div>
</div>

<!-- Humberger Begin -->
<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
	<div class="humberger__menu__logo">
		<a href="#"><img src="${URL}/img/logo.png" alt=""></a>
	</div>
	<div class="humberger__menu__cart">
		<ul>
			<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
			<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
		</ul>
		<div class="header__cart__price">
			item: <span>$150.00</span>
		</div>
	</div>
	<div class="humberger__menu__widget">
		<div class="header__top__right__language">
			<img src="${URL}/img/language.png" alt="">
			<div>English</div>
			<span class="arrow_carrot-down"></span>
			<ul>
				<li><a href="">Spanis</a></li>
				<li><a href="#">English</a></li>
			</ul>
		</div>
		<div class="header__top__right__auth">
			<a href="/WebEcommerce/auth/login"><i class="fa fa-user"></i>
				Login</a>
		</div>
	</div>
	<nav class="humberger__menu__nav mobile-menu">
		<ul>
			<li class="active"><a href="/WebEcommerce/home">Home</a></li>
			<li><a href="/WebEcommerce/shop/category">Shop</a></li>
			<li><a href="#">Pages</a>
				<ul class="header__menu__dropdown">
					<li><a href="/WebEcommerce/shop/blog/detail">Shop Details</a></li>
					<li><a href="/WebEcommerce/cart">Shoping Cart</a></li>
					<li><a href="/WebEcommerce/checkout">Check Out</a></li>
					<li><a href="/WebEcommerce/shop/blog/detail">Blog Details</a></li>
				</ul></li>
			<li><a href="/WebEcommerce/shop/blog">Blog</a></li>
			<li><a href="/WebEcommerce/contact">Contact</a></li>
		</ul>
	</nav>
	<div id="mobile-menu-wrap"></div>
	<div class="header__top__right__social">
		<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
			class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
		<a href="#"><i class="fa fa-pinterest-p"></i></a>
	</div>
	<div class="humberger__menu__contact">
		<ul>
			<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
			<li>Free Shipping for all Order of $99</li>
		</ul>
	</div>
</div>
<!-- Humberger End -->

<!-- Header Section Begin -->
<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="header__top__left">
						<ul>
							<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
							<li>Free Shipping for all Order of $99</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="header__top__right">
						<div class="header__top__right__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-linkedin"></i></a> <a href="#"><i
								class="fa fa-pinterest-p"></i></a>
						</div>
						<div class="header__top__right__language">
							<img src="${URL}/img/language.png" alt="">
							<div>English</div>
							<span class="arrow_carrot-down"></span>
							<ul>
								<li><a href="#">Spanis</a></li>
								<li><a href="#">English</a></li>
							</ul>
						</div>
						<form action="/WebEcommerce/home" method="POST">
							<button href="/WebEcommerce/auth/login" style="border: none;">Đăng
								xuất</button>
						</form>
						<div class="header__top__right__auth">
							<c:if test="${user != ''}">
								<a href="/WebEcommerce/auth/login"><i class="fa fa-user"></i>
									${user}</a>
							</c:if>
							<c:if test="${user == ''}">
								<a href="#"><i class="fa fa-pinterest-p"></i></a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="/WebEcommerce/home"><img src="${URL}/img/logo.png"
						alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="/WebEcommerce/home">Home</a></li>
						<li><a href="/WebEcommerce/shop/category">Shop</a></li>
						<li><a href="#">Pages</a>
							<ul class="header__menu__dropdown">
								<li><a href="/WebEcommerce/product/detail">Shop Details</a></li>
								<li><a href="/WebEcommerce/cart">Shoping Cart</a></li>
								<li><a href="/WebEcommerce/checkout">Check Out</a></li>
								<li><a href="/WebEcommerce/shop/blog/detail">Blog
										Details</a></li>
							</ul></li>
						<li><a href="/WebEcommerce/shop/blog">Blog</a></li>
						<li><a href="/WebEcommerce/contact">Contact</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
						<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
					</ul>
					<div class="header__cart__price">
						item: <span>$150.00</span>
					</div>
				</div>
			</div>
		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
<!-- Header Section End -->