<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/12/2022
  Time: 3:17 PM
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
                <h5 class="card-header">Tạo Sản Phẩm</h5>
                <div class="card-body">
                    <form action="add" method="post" enctype="multipart/form-data" role="form">


                        <div class="mb-3">
                            <label class="form-label">Tên</label>
                            <input type="text" class="form-control" name="name"
                                   placeholder="Tên Sản Phẩm..."/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mô Tả</label>
                            <textarea class="form-control" name="description" rows="3"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Hình Ảnh</label>
                            <input class="form-control" type="file" name="image" id="formFile"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Giá</label>
                            <input type="text" class="form-control" name="price"
                                   placeholder="Giá..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giá Khuyến Mãi</label>
                            <input type="text" class="form-control" name="promotionalprice"
                                   placeholder="Giá Khuyến Mãi..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số Lượng </label>
                            <input type="text" class="form-control" name="quantity"
                                   placeholder="Số Lượng ..."/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Thể Loại</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="categoryId"
                                    aria-label="Thể Loại">
                                <option selected>Chọn Thể Loại</option>
                                <core:forEach items="${categorys}" var="kq">
                                    <option value="${kq.id}">${kq.name}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault"
                                       name="isSelling"/>
                                <label class="form-check-label" for="flexSwitchCheckDefault"
                                >Bán Sản phẩm</label>
                            </div>
                        </div>
                        <div class="mb-3">

                            <button type="submit" class="btn btn-primary">Tạo Sản Phẩm</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>
