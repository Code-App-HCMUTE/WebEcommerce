package WebEcommerce.Controller.admin.User;

import WebEcommerce.Model.StoreLevelModel;
import WebEcommerce.Model.UserLevelModel;
import WebEcommerce.Service.Impl.UserLevelServiceImpl;
import WebEcommerce.Service.UserLevelService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserLevelController", value = "/admin/userLevel")
public class UserLevelController extends HttpServlet {
    UserLevelService userLevelService = new UserLevelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserLevelModel> userLevelList = userLevelService.findAll();
        request.setAttribute("listUserLevel", userLevelList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/user/userLevel.jsp");
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
