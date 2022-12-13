package WebEcommerce.Controller.admin.User;

import WebEcommerce.Model.StyleModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserModel> styleList = userService.findAll();
        request.setAttribute("listStyles", styleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/user/user.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
