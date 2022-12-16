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
                <h5 class="card-header">Tạo Đơn Đặt Hàng</h5>
                <div class="card-body">
                    <form action="add" method="post" enctype="multipart/form-data" role="form">
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Người Dùng</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="userId"
                                    aria-label="Người Dùng">
                                <option selected value="0">Chọn Người Dùng</option>
                                <core:forEach items="${users}" var="kq">
                                    <option value="${kq._id}">${kq.firstName}
                                        <sapn></sapn>
                                            ${kq.lastName}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Cửa Hàng</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="storeId"
                                    aria-label="Cửa Hàng">
                                <option selected value="0">Chọn Cửa Hàng</option>
                                <core:forEach items="${stores}" var="kq">
                                    <option value="${kq._id}">${kq.name}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Nhà Vận Chuyển</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="deliveryId"
                                    aria-label="Nhà Vận Chuyển">
                                <option selected value="0">Chọn Nhà Vận Chuyển</option>
                                <core:forEach items="${deliverys}" var="kq">
                                    <option value="${kq._id}">${kq.name}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Hoa Hồng</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="commissionId"
                                    aria-label="Hoa Hồng">
                                <option selected>Chọn Hoa Hồng</option>
                                <core:forEach items="${commissions}" var="kq">
                                    <option value="${kq.id}">${kq.name}</option>
                                </core:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Địa Chỉ</label>
                            <textarea class="form-control" name="address" rows="3"></textarea>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Điện Thoại</label>
                            <input type="text" class="form-control" name="phone"
                                   placeholder="Điện Thoại..."/>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlSelect1" class="form-label">Trạng thái Đơn Hàng</label>
                            <select class="form-select" id="exampleFormControlSelect1" name="status"
                                    aria-label="Thể Loại">
                                <option selected value="not precessed">Chọn Trạng thái Đơn Hàng</option>
                                <option value="processing">processing</option>
                                <option value="shipped">shipped</option>
                                <option value="delivered">delivered</option>
                                <option value="cancelled">cancelled</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <div class="form-check form-switch mb-2">
                                <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault"
                                       name="isPaidBefore"/>
                                <label class="form-check-label" for="flexSwitchCheckDefault"
                                >Đã Thanh Toán</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tiền khách trả </label>
                            <input type="text" class="form-control" name="amountFromUser"
                                   placeholder="Tiền khách trả..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tiền cửa hàng phải trả</label>
                            <input type="text" class="form-control" name="amountFromStore"
                                   placeholder="Tiền cửa hàng phải trả ..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tiền Cửa Hàng Nhận</label>
                            <input type="text" class="form-control" name="amountToStore"
                                   placeholder="Tiền Cửa Hàng Nhận ..."/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tiền Hệ Thống Nhận </label>
                            <input type="text" class="form-control" name="amountToGD"
                                   placeholder="Tiền Hệ Thống Nhận ..."/>
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
