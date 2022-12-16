    <%--
      Created by IntelliJ IDEA.
      User: Tu Nguyen
      Date: 10/28/2022
      Time: 1:05 AM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:url value="/templates/customer" var="URL"></c:url>
   <c:url value="/templates/UploadImages" var="imageUrl"></c:url>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->

    <section class="checkout spad">
        <div class="container">
        <c:if test="${success == true}">
                <div class="alert alert-primary" role="alert">
                  Cập nhật thông tin thành Công
                </div>
            </c:if>
            <div class="checkout__form">
                <h4>Cập nhật thông tin người dùng</h4>
                <form action="/WebEcommerce/UserProfile?id=${user.get_id()}" enctype="multipart/form-data"  method="POST">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Fist Name<span>*</span></p>
                                        <input type="text" name="firstName" value="${user.getFirstName()}">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Last Name<span>*</span></p>
                                        <input type="text" name="lastName" value="${user.getLastName()}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Phone<span>*</span></p>
                                        <input type="text" name="phone" value="${user.getPhone()}">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Email<span>*</span></p>
                                        <input type="text" name="email" value="${user.getEmail()}">
                                    </div>
                                </div>
                                <div class="col-lg-8">
                                    <div class="checkout__input">
                                        <p>Account Password<span>*</span></p>
                                        <input type="password" name="password" placeholder="Enter password">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="checkout__input">
                                        <br/>
                                        <br/>
                                        <a type="button" href="/WebEcommerce/resetPass" style="border:1px solid" class="btn btn-default btn-sm">
                                          <i class="fa fa-key"></i>Lock
                                        </a>
                                    </div>
                                </div>

                                <div class="col-lg-8">
                                    <p>Address<span>*</span></p>
                                    <select class="select" value="${user.getAddress()}" name="address">
                                      <option value="Tp HCM">Tp HCM</option>
                                      <option value="Hà Nội">Hà Nội</option>
                                      <option value="Quảng Ngãi">Quảng Ngãi</option>
                                      <option value="Đồng Nai">Đồng Nai</option>
                                      <option value="Bình Dương">Bình Dương</option>
                                      <option value="Thanh Hóa">Thanh Hóa</option>
                                      <option value="Đà Nẵng">Đà Nẵng</option>
                                      <option value="Đà lạt">Đà lạt</option>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                              Save
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                  <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Xác nhận thay đổi</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                  </div>
                                  <div class="modal-body">
                                    Bạn có muốn lưu không
                                  </div>
                                  <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" value="update" class="btn btn-primary">Save changes</button>
                                  </div>
                                </div>
                              </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6">

                        <img class="rounded-circle" height="200" width="200" id="image"
                            width="100px" src="${imageUrl}/user/${user.getAvatar()}" alt="" style="margin:20px">

                             <input type="file"
                            name="images"
                            onchange="chooseFile(this, id = 'image')" />
                        </div>

                    </div>
                </form >
                            <br/>
                            <br/>
                            <br/>

            </div>

    </section>