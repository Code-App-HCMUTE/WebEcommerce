<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/14/2022
  Time: 7:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<core:url value="/templates/admin" var="URL"></core:url>

<div class="container-xxl flex-grow-1 container-p-y">
    <!-- search product -->
    <div class="row">
        <div class="col-12 mb-4 order-0">
            <div class="card mb-4">
                <h5 class="card-header">Tạo Giao Dịch</h5>
                <div class="card-body">
                    <form action="add" method="post" enctype="multipart/form-data" role="form">
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Người dùng</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="categoryId"
                                    aria-label="Thể Loại">
                                <option selected value="0">Chọn Người dùng</option>
                                <core:forEach items="${users}" var="kq">
                                    <option value="${kq._id}">${kq.firstName}<span> </span>${kq.lastName}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Cửa Hàng</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="categoryId"
                                    aria-label="Thể Loại">
                                <option selected value="0">Chọn Cửa Hàng</option>
                                <core:forEach items="${stores}" var="kq">
                                    <option value="${kq._id}">${kq.name}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <input class="form-check-input" type="checkbox"
                                       name="isUp"/>
                                <label class="form-check-label"
                                >Rút</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Số Tiền Giao Dịch</label>
                            <input type="text" class="form-control" name="amount" id="exampleFormControlInput1"
                                   placeholder="Số Tiền Giao Dịch..."/>
                        </div>

                        <button type="submit" class="btn btn-primary">Tạo Giao Dịch</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>

