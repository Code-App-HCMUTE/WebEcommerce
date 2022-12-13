<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <h4>Cập nhật mật khẩu</h4>
            <form action="/WebEcommerce/resetPass?id=${user.get_id()}" method="POST">
                 <div class="checkout__input">
                    <p>Account Password<span>*</span></p>
                    <input type="password" name="password" placeholder="Enter password">
                </div>
                 <c:if test="${success == true}">
                    <div class="alert alert-primary" role="alert">
                      Mật khẩu cũ không đúng
                    </div>
                </c:if>
                <div class="checkout__input">
                    <p>New Password<span>*</span></p>
                    <input type="password" name="rePassword" placeholder="Enter new password" >
                </div>
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
                        <button type="submit" value="changePass" class="btn btn-primary">Save changes</button>
                      </div>
                    </div>
                  </div>
                </div>

            </form>
            <div>
        </div>
            </div>

    </section>