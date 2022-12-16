<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/13/2022
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<core:url value="/templates/admin" var="URL"></core:url>

<div class="container-xxl flex-grow-1 container-p-y">
    <!-- search product -->

    <!-- list Product -->
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="nav-align-top mb-4">
                    <!-- tab product -->
                    <div class="card-header p-3">
                        <ul class="nav nav-pills mb-3" role="tablist">
                            <!-- tab all product -->
                            <li class="nav-item">
                                <button type="button" class="nav-link active" role="tab"
                                        data-bs-toggle="tab"
                                        data-bs-target="#navs-pills-top-product-all"
                                        aria-controls="navs-pills-top-product-all" aria-selected="true">
                                    tất cả
                                </button>
                            </li>
                            <!-- tab working -->


                        </ul>
                    </div>
                    <div class="card-body">
                        <div class="tab-content p-0">
                            <!-- all product -->
                            <div class="tab-pane fade show active" id="navs-pills-top-product-all"
                                 role="tabpanel">
                                <div class="row">
                                    <div class="card p-0">
                                        <div class="card-header p-1">
                                            <div class="row">
                                                <div
                                                        class="col-6 d-flex flex-column align-items-start justify-content-start">
                                                    <h5 class="card-title">Quản Lí Người Dùng</h5>
                                                    <div class="progress mb-1"
                                                         style="height: 3px; width: 50%;">
                                                        <div class="progress-bar bg-success"
                                                             role="progressbar" style="width: 25%;"
                                                             aria-valuenow="25" aria-valuemin="0"
                                                             aria-valuemax="100"></div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>


                                        <%--     table    product--%>
                                        <div class="table-responsive text-nowrap">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>
                                                        <label for="flexCheckDefault1"></label>
                                                        <input
                                                                class="form-check-input" type="checkbox" value=""
                                                                id="flexCheckDefault1">
                                                    </th>
                                                    <th>Ảnh</th>
                                                    <th>Tên</th>
                                                    <th>CMND</th>
                                                    <th>Email</th>
                                                    <th>Điện Thoại</th>
                                                    <th>Trạng Thái Email</th>
                                                    <th>Trạng Thái Điện Thoại</th>
                                                    <th>Loại Người Dùng</th>
                                                    <th>Địa Chỉ</th>
                                                    <th>Điểm</th>
                                                    <th>e wallet</th>

                                                </tr>
                                                </thead>
                                                <tbody class="table-border-bottom-0">
                                                <core:forEach items="${listUser}" var="kq">
                                                    <tr>
                                                        <td>
                                                            <label for="flexCheckDefault"></label>
                                                            <input
                                                                    class="form-check-input" type="checkbox" value=""
                                                                    id="flexCheckDefault">
                                                        </td>

                                                        <td>
                                                            <core:url value="/image?fname=product/${kq.avatar}" var="imgUrl"></core:url>
                                                            <img src="${imgUrl}"
                                                                 class="rounded float-start" height="40" width="40"
                                                                 alt="...">

                                                        </td>
                                                        <td><strong>${kq.firstName}</strong></td>
                                                        <td>${kq.id_card}đ</td>
                                                        <td>${kq.email}</td>
                                                        <td>${kq.phone}</td>
                                                        <td>
                                                            <core:if test="${kq.isEmailActive}"><span
                                                                    class="badge bg-label-primary me-1">Active</span></core:if>
                                                            <core:if test="${!kq.isEmailActive}"><span
                                                                    class="badge bg-label-danger me-1">Block</span></core:if>
                                                        </td>
                                                        <td>
                                                            <core:if test="${kq.isPhoneActive}"><span
                                                                    class="badge bg-label-primary me-1">Active</span></core:if>
                                                            <core:if test="${!kq.isPhoneActive}"><span
                                                                    class="badge bg-label-danger me-1">Block</span></core:if>
                                                        </td>
                                                        <td>${kq.role}</td>
                                                        <td>${kq.address}</td>
                                                        <td>${kq.point}</td>
                                                        <td>${kq.e_wallet}</td>
                                                        <td>
                                                            <div class="dropdown">
                                                                <button type="button"
                                                                        class="btn p-0 dropdown-toggle hide-arrow"
                                                                        data-bs-toggle="dropdown">
                                                                    <i
                                                                            class="bx bx-dots-vertical-rounded"></i>
                                                                </button>
                                                                <div class="dropdown-menu">
                                                                    <a class="dropdown-item"
                                                                       href="javascript:void(0);"><i
                                                                            class="bx bx-edit-alt me-1"></i>
                                                                        Edit</a>
                                                                    <a class="dropdown-item"
                                                                       href="javascript:void(0);"><i
                                                                            class="bx bx-trash me-1"></i>
                                                                        Delete</a>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </core:forEach>


                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <!--/ Basic Bootstrap Table -->
                                </div>
                            </div>
                            <!-- working -->
                            <div class="tab-pane fade" id="navs-pills-top-working" role="tabpanel">
                                <p>
                                    Donut dragée jelly pie halvah. Danish gingerbread bonbon cookie
                                    wafer candy oat cake ice
                                    cream. Gummies halvah tootsie roll muffin biscuit icing dessert
                                    gingerbread. Pastry ice cream
                                    cheesecake fruitcake.
                                </p>
                                <p class="mb-0">
                                    Jelly-o jelly beans icing pastry cake cake lemon drops. Muffin
                                    muffin pie tiramisu halvah
                                    cotton candy liquorice caramels.
                                </p>
                            </div>
                            <!-- stock -->
                            <div class="tab-pane fade" id="navs-pills-top-out-of-stock"
                                 role="tabpanel">
                                <p>
                                    Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                                    jelly
                                    beans macaroon gummies
                                    cupcake gummi bears cake chocolate.
                                </p>
                                <p class="mb-0">
                                    Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                                    apple pie brownie cake. Sweet
                                    roll icing sesame snaps caramels danish toffee. Brownie biscuit
                                    dessert dessert. Pudding jelly
                                    jelly-o tart brownie jelly.
                                </p>
                            </div>
                            <!-- pending -->
                            <div class="tab-pane fade" id="navs-pills-top-out-of-pending"
                                 role="tabpanel">
                                <p>
                                    Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                                    jelly
                                    beans macaroon gummies
                                    cupcake gummi bears cake chocolate.
                                </p>
                                <p class="mb-0">
                                    Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                                    apple pie brownie cake. Sweet
                                    roll icing sesame snaps caramels danish toffee. Brownie biscuit
                                    dessert dessert. Pudding jelly
                                    jelly-o tart brownie jelly.
                                </p>
                            </div>
                            <!-- violate -->
                            <div class="tab-pane fade" id="navs-pills-top-out-of-Violate"
                                 role="tabpanel">
                                <p>
                                    Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                                    jelly
                                    beans macaroon gummies
                                    cupcake gummi bears cake chocolate.
                                </p>
                                <p class="mb-0">
                                    Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                                    apple pie brownie cake. Sweet
                                    roll icing sesame snaps caramels danish toffee. Brownie biscuit
                                    dessert dessert. Pudding jelly
                                    jelly-o tart brownie jelly.
                                </p>
                            </div>
                            <!-- hidden -->
                            <div class="tab-pane fade" id="navs-pills-top-out-of-Hidden"
                                 role="tabpanel">
                                <p>
                                    Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                                    jelly
                                    beans macaroon gummies
                                    cupcake gummi bears cake chocolate.
                                </p>
                                <p class="mb-0">
                                    Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                                    apple pie brownie cake. Sweet
                                    roll icing sesame snaps caramels danish toffee. Brownie biscuit
                                    dessert dessert. Pudding jelly
                                    jelly-o tart brownie jelly.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

