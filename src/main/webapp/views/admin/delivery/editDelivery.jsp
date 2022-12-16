<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/14/2022
  Time: 10:35 PM
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
                <h5 class="card-header">Sửa Nhà Vận Chuyển</h5>
                <div class="card-body">
                    <form action="edit" method="post" enctype="multipart/form-data" role="form">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Tên Nhà Vận Chuyển</label>
                            <input type="text" class="form-control" name="name" id="exampleFormControlInput1"
                                   placeholder="Tên Nhà Vận Chuyển..." value="${delivery.name}"/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Mô tả Nhà Vận Chuyển</label>
                            <input type="text" class="form-control" name="description" id="exampleFormControlInput1"
                                   placeholder="Mô tả Nhà Vận Chuyển..." value="${delivery.description}"/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Giá</label>
                            <input type="text" class="form-control" name="price" id="exampleFormControlInput1"
                                   placeholder="Giá..." value="${delivery.price}"/>
                        </div>

                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <core:if test="${delivery.isDeleted}"><input class="form-check-input" type="checkbox"
                                                                             checked
                                                                             name="isDeleted"/></core:if>
                                <core:if test="${!delivery.isDeleted}"><input class="form-check-input" type="checkbox"
                                                                              name="isDeleted"/></core:if>

                                <label class="form-check-label"
                                >Hoạt động</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Sửa</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>
