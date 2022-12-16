package WebEcommerce.Controller.admin.User;

import WebEcommerce.Model.UserLevelModel;
import WebEcommerce.Service.Impl.UserLevelServiceImpl;
import WebEcommerce.Service.UserLevelService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserLevelController", value = "/admin/userLevel/delete")
public class DeleteUserLevelController extends HttpServlet {
    UserLevelService userLevelService = new UserLevelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userLevelService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/userLevel");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
