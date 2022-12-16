<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 10/28/2022
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/templates/UploadImages" var="URL"></c:url>






<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
    <div class="container">
    <h2 style="margin-bottom:50px">Giỏ hàng</h2>
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__table">
                    <table>
                        <thead>
                        <tr>
                            <th class="shoping__product">Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${cart}">
                            <tr>
                                <td class="shoping__cart__item">
                                    <img style="height:200px;width:250px" src="${URL}/product/${item.getListImages()}" alt="">
                                    <h5><a style="color: inherit;text-decoration: inherit;" href="product/detail?id=${item.id}">${item.name}</a></h5>
                                </td>
                                <td class="shoping__cart__price">
                                    ${item.getPrice()}
                                </td>
                                <td class="shoping__cart__quantity">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <input type="text" value="${item.getCount()}">
                                        </div>
                                    </div>
                                </td>
                                <td class="shoping__cart__total">
                                    ${item.getCount()*item.getPrice()}
                                </td>
                                <td class="shoping__cart__item__close">
                                    <span class="icon_close"></span>
                                </td>
                            </tr>


                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__btns">
                    <a href="/WebEcommerce" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                    <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                        Upadate Cart</a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shoping__continue">
                    <div class="shoping__discount">
                        <h5>Discount Codes</h5>
                        <form action="#">
                            <input type="text" placeholder="Enter your coupon code">
                            <button type="submit" class="site-btn">APPLY COUPON</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shoping__checkout">
                    <h5>Cart Total</h5>
                    <ul>
                        <li>Subtotal <span>${total}</span></li>
                        <li>Total <span>${total}</span></li>
                    </ul>
                    <a href="/WebEcommerce/checkout" class="primary-btn">PROCEED TO CHECKOUT</a>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- Shoping Cart Section End -->
