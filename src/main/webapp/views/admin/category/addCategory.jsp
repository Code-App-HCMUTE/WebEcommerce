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
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Tên Thể Loại</label>
                        <input type="email" class="form-control" id="exampleFormControlInput1"
                               placeholder="Tên Shop..."/>
                    </div>

                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Tên slug</label>
                        <input type="email" class="form-control" id="exampleFormControlInput1"
                               placeholder="Tên slug..."/>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Hình Ảnh</label>
                        <input class="form-control" type="file" id="formFile"/>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Thể Loại Cha</label>
                        <input type="email" class="form-control" id="exampleFormControlInput1"
                               placeholder="Category Parrent..."/>
                    </div>

                    <button type="submit" class="btn btn-primary">Tạo Thể Loại</button>

                </div>

            </div>
        </div>
    </div>

</div>
