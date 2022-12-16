<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 12/15/2022
  Time: 10:56 AM
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
        <h5 class="card-header">Cấp Độ Người Dùng</h5>
        <div class="card-body">
          <form action="add" method="post" enctype="multipart/form-data" role="form">


            <div class="mb-3">
              <label class="form-label">Tên Cấp Độ Người Dùng</label>
              <input type="text" class="form-control" name="name"
                     placeholder="Tên Cấp Độ..."/>
            </div>
            <div class="mb-3">
              <label class="form-label">Điểm</label>
              <input type="text" class="form-control" name="minPoint"
                     placeholder="Điểm..."/>
            </div>
            <div class="mb-3">
              <label class="form-label">Giảm Giá</label>
              <input type="text" class="form-control" name="discount"
                     placeholder="Giảm Giá..."/>
            </div>
            <div class="mb-3">
              <div class="form-check form-switch mb-2">
                <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault"
                       name="isDeleted"/>
                <label class="form-check-label" for="flexSwitchCheckDefault"
                >bật cấp độ</label>
              </div>
            </div>
            <div class="mb-3">

              <button type="submit" class="btn btn-primary">Tạo cấp độ Người Dùng</button>
            </div>
          </form>
        </div>

      </div>
    </div>
  </div>

</div>

