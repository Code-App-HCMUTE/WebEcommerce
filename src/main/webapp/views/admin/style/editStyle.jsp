<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/15/2022
  Time: 12:24 AM
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
                <h5 class="card-header">Sửa kiểu</h5>
                <div class="card-body">
                    <form action="edit" method="post" enctype="multipart/form-data" role="form">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Tên kiểu</label>
                            <input type="text" class="form-control" name="name" id="exampleFormControlInput1"
                                   placeholder="Tên kiểu..." value="${style.name}"/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Thể kiểu Cha</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="categoryId"
                                    aria-label="Thể Loại">
                                <core:if test="${style.caId ==  0}">
                                    <option selected value="0">chọn kiểu</option>
                                </core:if>
                                <core:forEach items="${styles}" var="kq">
                                    <core:if test="${kq.caId == style.caId}">
                                        <option selected value="${kq.id}">${kq.name}</option>
                                    </core:if>
                                    <core:if test="${kq.caId !=  style.caId}">
                                        <option value="${kq.id}">${kq.name}</option>
                                    </core:if>

                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <core:if test="${style.isDelete}"><input class="form-check-input" type="checkbox"
                                                                          checked
                                                                          name="isDeleted"/></core:if>
                                <core:if test="${!style.isDelete}"><input class="form-check-input" type="checkbox"
                                                                           name="isDeleted"/></core:if>

                                <label class="form-check-label"
                                >Hoạt động</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Sửa kiểu</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>

