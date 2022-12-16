<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/14/2022
  Time: 1:44 PM
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
                <h5 class="card-header">Sửa Sản Phẩm</h5>
                <div class="card-body">
                    <form action="edit" method="post" enctype="multipart/form-data" role="form">
                        <div class="mb-3">
                            <label class="form-label">Tên</label>
                            <input type="text" class="form-control" name="name" value="${product.name}"
                                   placeholder="Tên Sản Phẩm..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Mô Tả</label>
                            <textarea class="form-control" name="description" rows="3"
                                      >${product.description}</textarea>
                        </div>
                        <div class="mb-3">

                            <label class="form-label">Hình Ảnh</label>
                            <core:url value="/image?fname=product/${product.listImages}"
                                      var="imgUrl"></core:url>
                            <img class="rounded-circle" height="200" width="200" id="image"
                                 width="100px" src="${imgUrl}" alt="">
                            <input class="form-control" name="image" type="file" id="formFile"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Giá</label>
                            <input type="text" class="form-control" name="price" value="${product.price}"
                                   placeholder="Giá..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giá Khuyến Mãi</label>
                            <input type="text" class="form-control" name="promotionalprice"
                                   value="${product.promotionalPrice}"
                                   placeholder="Giá Khuyến Mãi..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số Lượng </label>
                            <input type="text" class="form-control" name="quantity" value="${product.quantity}"
                                   placeholder="Số Lượng ..."/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Thể
                                Loại</label> <select class="form-select" id="exampleFormControlSelect1"
                                                     name="categoryId" aria-label="Thể Loại">
                            <core:forEach items="${categorys}" var="kq">
                                <core:if test="${kq.id == category.id}">
                                    <option selected value="${kq.id}">${kq.name}</option>
                                </core:if>
                                <core:if test="${kq.id != category.id}">
                                    <option value="${kq.id}">${kq.name}</option>
                                </core:if>
                            </core:forEach>
                        </select>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">

                                <core:if test="${product.isSelling}">
                                    <input class="form-check-input" type="checkbox" checked
                                           id="flexSwitchCheckDefault"
                                           name="isSelling"/>
                                </core:if>
                                <core:if test="${!product.isSelling}">
                                    <input class="form-check-input" type="checkbox"
                                           id="flexSwitchCheckDefault"
                                           name="isSelling"/>
                                </core:if>
                                <label class="form-check-label" for="flexSwitchCheckDefault"
                                >Bán Sản phẩm</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">

                                <core:if test="${product.isActive}">
                                    <input class="form-check-input" type="checkbox" checked
                                           id="flexSwitchCheckDefault"
                                           name="isActive"/>
                                </core:if>
                                <core:if test="${!product.isActive}">
                                    <input class="form-check-input" type="checkbox"
                                           id="flexSwitchCheckDefault"
                                           name="isActive"/>
                                </core:if>
                                <label class="form-check-label" for="flexSwitchCheckDefault"
                                >Cấp Phép</label>
                            </div>
                        </div>
                        <div class="mb-3">

                            <button type="submit" class="btn btn-primary">Sửa Sản Phẩm</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>

