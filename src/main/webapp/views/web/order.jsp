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
    <h2 style="margin-bottom:50px">Đặt hàng</h2>
        <div class="row">
            <div class="col-lg-12">
                <c:forEach var="item" items="${order}">
                    <div class="shoping__cart__table">
                    <h6>Đơn hàng ngày : ${item.getCreatedAt()}</h6>
                        <table>
                            <thead>
                            <tr>
                                <th class="shoping__product">Products</th>
                                <th>Price</th>
                                <th>Status</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="element" items="${item.getOrderItems()}">
                                <tr>
                                <td class="shoping__cart__item">
                                    <img style="height:200px;width:250px" src="${URL}/product/${element.getProduct().getListImages()}" alt="">
                                    <h5><a style="color: inherit;text-decoration: inherit;" href="product/detail?id=${item.id}">${element.getProduct().name}</a></h5>
                                </td>
                                <td class="shoping__cart__price">
                                    ${element.getProduct().getPrice()}
                                </td>
                                <td class="shoping__cart__price">
                                    ${item.getStatus()}
                                </td>
                                <td class="shoping__cart__quantity">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <input type="text" value="${element.getCount()}">
                                        </div>
                                    </div>
                                </td>
                                <td class="shoping__cart__total">
                                    ${element.getCount()*element.getProduct().getPrice()}
                                </td>
                                <td class="shoping__cart__item__close">
                                    <span class="icon_close"></span>
                                </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="shoping__checkout">
                    <h5>Order Total</h5>
                    <ul>
                        <li>Subtotal <span>${total}</span></li>
                        <li>Total <span>${total}</span></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- Shoping Cart Section End -->
