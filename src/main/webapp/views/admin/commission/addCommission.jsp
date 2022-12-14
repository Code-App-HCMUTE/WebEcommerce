<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/14/2022
  Time: 12:44 AM
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
                <h5 class="card-header">Tạo Chính Sách Hoa Hồng</h5>
                <div class="card-body">
                    <form action="add" method="post" enctype="multipart/form-data" role="form">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Tên Chính Sách Hoa Hồng</label>
                            <input type="text" class="form-control" name="name" id="exampleFormControlInput1"
                                   placeholder="Tên Chính Sách Hoa Hồng..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tiền</label>
                            <input type="text" class="form-control" name="cost"
                                   placeholder="Tiền..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-icon-default-message">Mô Tả</label>
<%--                            <div class="input-group input-group-merge">--%>
<%--                                <span id="basic-icon-default-message2" class="input-group-text"--%>
<%--                                ><i class="bx bx-comment"></i--%>
<%--                                ></span>--%>
                                <textarea
                                        id="basic-icon-default-message"
                                        class="form-control"
                                        name="description"
                                        placeholder="Mô Tả"
                                        aria-label="Hi, Do you have a moment to talk Joe?"
                                        aria-describedby="basic-icon-default-message2"
                                ></textarea>
<%--                            </div>--%>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <input class="form-check-input" type="checkbox"
                                       name="isDelete"/>
                                <label class="form-check-label"
                                >Hoạt động</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Tạo Chính Sách Hoa Hồng</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

</div>
