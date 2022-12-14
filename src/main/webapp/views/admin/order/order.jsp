<%--
  Created by IntelliJ IDEA.
  User: Tu Nguyen
  Date: 11/3/2022
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<core:url value="/templates/admin" var="URL"></core:url>

<div class="container-xxl flex-grow-1 container-p-y">
  <!-- search product -->
  <div class="row">
    <div class="col-12 mb-4 order-0">
      <div class="card ">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-12">
            <div class="card-body p-3">
              <div class="d-flex flex-column align-items-start ">
                <label class="form-label">Nghành Hàng</label>
                <div class="input-group">
                  <button class="btn btn-outline-secondary dropdown-toggle"
                          type="button" data-bs-toggle="dropdown"
                          aria-expanded="false">Tên sản phẩm
                  </button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a>
                    </li>
                    <li><a class="dropdown-item" href="#">Something else
                      here</a>
                    </li>
                    <li>
                      <hr class="dropdown-divider">
                    </li>
                    <li><a class="dropdown-item" href="#">Separated link</a>
                    </li>
                  </ul>
                  <input type="text" class="form-control"
                         aria-label="Text input with dropdown button">
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-6 col-md-6 col-sm-12">
            <div class="card-body p-3">
              <div class="d-flex flex-column align-items-start ">
                <label class="form-label">Nghành
                  Hàng</label>
                <select class="form-select" id="search-"
                        aria-label="Default select example">
                  <option selected>chọn</option>
                  <option value="1">One</option>
                  <option value="2">Two</option>
                  <option value="3">Three</option>
                </select>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-12">
            <div class="card-body p-3">
              <div
                      class="d-flex flex-column align-items-start justify-content-center ">
                <label class="form-label">kho
                  hàng</label>
                <div class="d-flex align-items-start justify-content-start ">
                  <input type="text" class="form-control" placeholder="tối thiểu"
                         aria-label="tối thiểu">
                  <span class="input-group-sm p-2">-</span>
                  <input type="text" class="form-control" placeholder="tối đa"
                         aria-label="tối đa">
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-6 col-md-6 col-sm-12">
            <div class="card-body p-3">
              <div
                      class="d-flex flex-column align-items-start justify-content-center ">
                <label class="form-label me-2">Doanh Số</label>
                <div class="d-flex align-items-start justify-content-start ">
                  <input type="text" class="form-control" placeholder="tối thiểu"
                         aria-label="tối thiểu">
                  <span class="input-group-sm p-2">-</span>
                  <input type="text" class="form-control" placeholder="tối đa"
                         aria-label="tối đa">
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <div class="card">
              <div class="card-body">
                <button type="button" class="btn btn-primary me-2">Tìm</button>
                <button type="button" class="btn btn-outline-secondary">Nhập
                  Lại
                </button>
              </div>
            </div>

          </div>
        </div>
      </div>


    </div>
  </div>
  <!-- list Product -->
  <div class="row">
    <div class="col-12">
      <div class="card">
        <div class="nav-align-top mb-4">
          <!-- tab product -->
          <div class="card-header p-3">
            <ul class="nav nav-pills mb-3" role="tablist">
              <!-- tab all product -->
              <li class="nav-item">
                <button type="button" class="nav-link active" role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-pills-top-product-all"
                        aria-controls="navs-pills-top-product-all" aria-selected="true">
                  tất cả
                </button>
              </li>
              <!-- tab working -->
              <li class="nav-item">
                <button type="button" class="nav-link" role="tab"
                        data-bs-toggle="tab" data-bs-target="#navs-pills-top-working"
                        aria-controls="navs-pills-top-working" aria-selected="false">
                  Đang hoạt động
                </button>
              </li>
              <!-- tab out of stock -->
              <li class="nav-item">
                <button type="button" class="nav-link" role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-pills-top-out-of-stock"
                        aria-controls="navs-pills-top-out-of-stock"
                        aria-selected="false">
                  Hết Hàng
                </button>
              </li>
              <!-- tab pending -->
              <li class="nav-item">
                <button type="button" class="nav-link" role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-pills-top-out-of-pending"
                        aria-controls="navs-pills-top-out-of-pending"
                        aria-selected="false">
                  Chờ duyệt
                </button>
              </li>
              <!-- tab violate -->
              <li class="nav-item">
                <button type="button" class="nav-link" role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-pills-top-out-of-Violate"
                        aria-controls="navs-pills-top-out-of-Violate"
                        aria-selected="false">
                  Vi Phạm
                </button>
              </li>
              <!-- tab hidden -->
              <li class="nav-item">
                <button type="button" class="nav-link" role="tab"
                        data-bs-toggle="tab"
                        data-bs-target="#navs-pills-top-out-of-Hidden"
                        aria-controls="navs-pills-top-out-of-Hidden"
                        aria-selected="false">
                  Đã Ẩn
                </button>
              </li>
            </ul>
          </div>
          <div class="card-body">
            <div class="tab-content p-0">
              <!-- all product -->
              <div class="tab-pane fade show active" id="navs-pills-top-product-all"
                   role="tabpanel">
                <div class="row">
                  <div class="card p-0">
                    <div class="card-header p-1">
                      <div class="row">
                        <div
                                class="col-6 d-flex flex-column align-items-start justify-content-start">
                          <h5 class="card-title">Sản Phẩm</h5>
                          <div class="progress mb-1"
                               style="height: 3px; width: 50%;">
                            <div class="progress-bar bg-success"
                                 role="progressbar" style="width: 25%;"
                                 aria-valuenow="25" aria-valuemin="0"
                                 aria-valuemax="100"></div>
                          </div>
                          <p class="text-muted fs-6">Có thể đăng tải tối
                            da 100 sản phẩm</p>
                        </div>
                        <div
                                class="col-6 d-flex align-items-center justify-content-end">
                          <a href="order/add">
                            <button type="button"
                                    class="btn btn-success me-3 d-flex align-items-center text-nowrap">
                              <i
                                      class="bx bx-plus me-1"></i> Thêm sản
                              Phẩm
                            </button>
                          </a>
                          <div class="btn-group btn-group-sm" role="group"
                               aria-label="Button group with nested dropdown">
                            <div class="btn-group" role="group">
                              <button id="btnGroupDrop1" type="button"
                                      class="btn btn-outline-secondary dropdown-toggle"
                                      data-bs-toggle="dropdown"
                                      aria-haspopup="true"
                                      aria-expanded="false">
                                Công cụ xử lý hàng loạt
                              </button>
                              <div class="dropdown-menu"
                                   aria-labelledby="btnGroupDrop1">
                                <a class="dropdown-item"
                                   href="javascript:void(0);">xoá</a>
                                <a class="dropdown-item"
                                   href="javascript:void(0);">Dropdown
                                  link</a>
                              </div>
                            </div>
                            <button type="button"
                                    class="btn btn-outline-secondary">
                              <i class='bx bx-list-ul'></i>
                            </button>
                            <button type="button"
                                    class="btn btn-outline-secondary">

                              <i class='bx bx-grid'></i>
                            </button>
                          </div>

                        </div>
                      </div>
                    </div>


                    <%--     table    product--%>
                    <div class="table-responsive text-nowrap">
                      <table class="table">
                        <thead>
                        <tr>
                          <th>
                            <label for="flexCheckDefault1"></label>
                            <input
                                    class="form-check-input" type="checkbox" value=""
                                    id="flexCheckDefault1">
                          </th>
                          <th>Mã Khách Hàng</th>
                          <th>Mã Cửa Hàng</th>
                          <th>Mã Nhà Vận Chuyển</th>
                          <th>Mã Hoa Hồng</th>
                          <th>Địa Chỉ</th>
                          <th>Điện Thoại</th>
                          <th>Trạng Thái Hàng</th>
                          <th>Thanh Toán</th>
                          <th>Tiền Khách Hàng Trả</th>
                          <th>Tiền Cửa Hàng Trả</th>
                          <th>Tiền Cửa Hàng Nhận</th>
                          <th>Tiền Hệ Thống Nhận</th>
                          <th>Chỉnh Sữa</th>

                        </tr>
                        </thead>
                        <tbody class="table-border-bottom-0">
                        <core:forEach items="${listOrder}" var="kq">
                          <tr>
                            <td>
                              <label for="flexCheckDefault"></label>
                              <input
                                      class="form-check-input" type="checkbox" value=""
                                      id="flexCheckDefault">
                            </td>
                            <td><strong>${kq.userId}</strong></td>
                            <td>${kq.storeId}</td>
                            <td>${kq.deliveryId}</td>
                            <td>${kq.commissionId}</td>

                            <td>${kq.address}</td>

                            <td>${kq.phone}</td>
                            <td>${kq.status}</td>
                            <td>
                              <core:if test="${kq.isPaidBefore}"><span
                                      class="badge bg-label-primary me-1">Đã Thanh Toán</span></core:if>
                              <core:if test="${!kq.isPaidBefore}"><span
                                      class="badge bg-label-danger me-1">Chưa Thanh Toán</span></core:if>
                            </td>
                            <td>${kq.amountFromUser}₫</td>
                            <td>${kq.amountFromStore}₫</td>
                            <td>${kq.amountToStore}₫</td>
                            <td>${kq.amountToGD}₫</td>
                            <td>
                              <div class="dropdown">
                                <button type="button"
                                        class="btn p-0 dropdown-toggle hide-arrow"
                                        data-bs-toggle="dropdown">
                                  <i
                                          class="bx bx-dots-vertical-rounded"></i>
                                </button>
                                <div class="dropdown-menu">
                                  <a class="dropdown-item"
                                     href="javascript:void(0);"><i
                                          class="bx bx-edit-alt me-1"></i>
                                    Edit</a>
                                  <a class="dropdown-item"
                                     href="javascript:void(0);"><i
                                          class="bx bx-trash me-1"></i>
                                    Delete</a>
                                </div>
                              </div>
                            </td>
                          </tr>
                        </core:forEach>


                        </tbody>
                      </table>
                    </div>
                  </div>
                  <!--/ Basic Bootstrap Table -->
                </div>
              </div>
              <!-- working -->
              <div class="tab-pane fade" id="navs-pills-top-working" role="tabpanel">
                <p>
                  Donut dragée jelly pie halvah. Danish gingerbread bonbon cookie
                  wafer candy oat cake ice
                  cream. Gummies halvah tootsie roll muffin biscuit icing dessert
                  gingerbread. Pastry ice cream
                  cheesecake fruitcake.
                </p>
                <p class="mb-0">
                  Jelly-o jelly beans icing pastry cake cake lemon drops. Muffin
                  muffin pie tiramisu halvah
                  cotton candy liquorice caramels.
                </p>
              </div>
              <!-- stock -->
              <div class="tab-pane fade" id="navs-pills-top-out-of-stock"
                   role="tabpanel">
                <p>
                  Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                  jelly
                  beans macaroon gummies
                  cupcake gummi bears cake chocolate.
                </p>
                <p class="mb-0">
                  Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                  apple pie brownie cake. Sweet
                  roll icing sesame snaps caramels danish toffee. Brownie biscuit
                  dessert dessert. Pudding jelly
                  jelly-o tart brownie jelly.
                </p>
              </div>
              <!-- pending -->
              <div class="tab-pane fade" id="navs-pills-top-out-of-pending"
                   role="tabpanel">
                <p>
                  Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                  jelly
                  beans macaroon gummies
                  cupcake gummi bears cake chocolate.
                </p>
                <p class="mb-0">
                  Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                  apple pie brownie cake. Sweet
                  roll icing sesame snaps caramels danish toffee. Brownie biscuit
                  dessert dessert. Pudding jelly
                  jelly-o tart brownie jelly.
                </p>
              </div>
              <!-- violate -->
              <div class="tab-pane fade" id="navs-pills-top-out-of-Violate"
                   role="tabpanel">
                <p>
                  Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                  jelly
                  beans macaroon gummies
                  cupcake gummi bears cake chocolate.
                </p>
                <p class="mb-0">
                  Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                  apple pie brownie cake. Sweet
                  roll icing sesame snaps caramels danish toffee. Brownie biscuit
                  dessert dessert. Pudding jelly
                  jelly-o tart brownie jelly.
                </p>
              </div>
              <!-- hidden -->
              <div class="tab-pane fade" id="navs-pills-top-out-of-Hidden"
                   role="tabpanel">
                <p>
                  Oat cake chupa chups dragée donut toffee. Sweet cotton candy
                  jelly
                  beans macaroon gummies
                  cupcake gummi bears cake chocolate.
                </p>
                <p class="mb-0">
                  Cake chocolate bar cotton candy apple pie tootsie roll ice cream
                  apple pie brownie cake. Sweet
                  roll icing sesame snaps caramels danish toffee. Brownie biscuit
                  dessert dessert. Pudding jelly
                  jelly-o tart brownie jelly.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
