<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
        <div class="header__cart__price">item: <span>$150.00</span></div>
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
            <a href="/WebEcommerce/auth/login"><i class="fa fa-user"></i> Login</a>
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
                </ul>
            </li>
            <li><a href="/WebEcommerce/shop/blog">Blog</a></li>
            <li><a href="/WebEcommerce/contact">Contact</a></li>
        </ul>
    </nav>
    <div id="mobile-menu-wrap"></div>
    <div class="header__top__right__social">
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-linkedin"></i></a>
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
<div class="container" >
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
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                            <a href="#"><i class="fa fa-pinterest-p"></i></a>
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
                        <div class="header__top__right__language">
                            <c:if test="${user != null}">
                                <div><i class="fa fa-user"></i> ${user.getFistName()}</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="/WebEcommerce/UserProfile">Your Profile</a></li>
                                    <li><form action="/WebEcommerce/home" method="POST">
                                        <button href="/WebEcommerce/auth/login" style="border:none;">Đăng xuất</button>
                                    </form></li>
                                </ul>
                            </c:if>
                            <c:if test="${user == null}">
                                <a href="/WebEcommerce/auth/login" style="all:unset"><i class="fa fa-pinterest-p"></i> Đăng nhập</a>
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
                    <a href="/WebEcommerce/home"><img src="${URL}/img/logo.png" alt=""></a>
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
                                <li><a href="/WebEcommerce/shop/blog/detail">Blog Details</a></li>
                            </ul>
                        </li>
                        <li><a href="/WebEcommerce/shop/blog">Blog</a></li>
                        <li><a href="/WebEcommerce/contact">Contact</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <li><a href="/WebEcommerce/order"><i class="fa-solid fa-truck-fast"></i> <span>${order.size()}</span></a></li>
                        <li><a href="/WebEcommerce/cart"><i class="fa fa-shopping-bag"></i> <span>${cart.size()}</span></a></li>
                    </ul>
                    <div class="header__cart__price">item: <span>${total}</span></div>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
    <section class="hero">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="hero__categories">
                                <div class="hero__categories__all">
                                    <i class="fa fa-bars"></i>
                                    <span>All departments</span>
                                </div>
                                <ul style="display:none">
                                <c:forEach var="item" items="${category}">
                                    <li><a href="/WebEcommerce/category?id=${item.getId()}">${item.getName()}</a></li>
                                </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-9"
                            <div class="hero__search">
                                <div class="hero__search__form" style="height:50px">
                                    <form action='/WebEcommerce/search?index=1' method="POST">
                                         <select class="form-select" name="search" aria-label="Default select example">
                                           <option value="product">Sản Phẩm</option>
                                           <option value="store">Cửa Hàng</option>
                                           <option value="user">Người dùng</option>
                                         </select>
                                        <input type="text" name="searchValue" placeholder="What do yo u need?">
                                        <button type="submit" class="site-btn">SEARCH</button>
                                    </form>
                                </div>
                                <div class="hero__search__phone">
                                    <div class="hero__search__phone__icon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <div class="hero__search__phone__text">
                                        <h5>+65 11.188.888</h5>
                                        <span>support 24/7 time</span>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </section>
</div>
<!-- Header Section End -->