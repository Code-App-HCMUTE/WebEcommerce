<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/12/2022
  Time: 9:54 AM
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
                <h5 class="card-header">Tạo Thể Loại</h5>
                <div class="card-body">
                    <form action="add" method="post" enctype="multipart/form-data" role="form">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Tên Thể Loại</label>
                            <input type="text" class="form-control" name="name" id="exampleFormControlInput1"
                                   placeholder="Tên Thể Loại..."/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Hình Ảnh</label>
                            <input class="form-control" name="image" type="file" id="formFile"/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Thể Loại Cha</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="categoryId"
                                    aria-label="Thể Loại">
                                <option selected value="0">Chọn Thể Loại</option>
                                <core:forEach items="${categorys}" var="kq">
                                    <option value="${kq.id}">${kq.name}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <input class="form-check-input" type="checkbox"
                                       name="isDeleted"/>
                                <label class="form-check-label"
                                >Hoạt động</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Tạo Thể Loại</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>
