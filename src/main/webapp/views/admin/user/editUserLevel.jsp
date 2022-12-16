<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/15/2022
  Time: 11:07 AM
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
                <h5 class="card-header">Sửa Cấp Người Dùng</h5>
                <div class="card-body">
                    <form action="edit" method="post" enctype="multipart/form-data" role="form">


                        <div class="mb-3">
                            <label class="form-label">Tên Cấp Độ</label>
                            <input type="text" class="form-control" name="name"
                                   placeholder="Tên Cấp Độ..." value="${userLevel.name}"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Điểm</label>
                            <input type="text" class="form-control" name="minPoint"
                                   placeholder="Điểm..." value="${userLevel.minPoint}"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giảm Giá</label>
                            <input type="text" class="form-control" name="discount"
                                   placeholder="Giảm Giá..." value="${userLevel.discount}"/>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <core:if test="${userLevel.isDeleted}"><input class="form-check-input" checked
                                                                               type="checkbox"
                                                                               id="flexSwitchCheckDefault"
                                                                               name="isDeleted"/></core:if>
                                <core:if test="${!userLevel.isDeleted}"><input class="form-check-input" type="checkbox"
                                                                                id="flexSwitchCheckDefault"
                                                                                name="isDeleted"/></core:if>


                                <label class="form-check-label" for="flexSwitchCheckDefault"
                                >bật cấp độ</label>
                            </div>
                        </div>
                        <div class="mb-3">

                            <button type="submit" class="btn btn-primary">Sửa cấp độ</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>


