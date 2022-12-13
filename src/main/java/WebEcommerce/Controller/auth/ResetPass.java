package WebEcommerce.Controller.auth;

import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/resetPass"})
public class ResetPass extends HttpServlet {
    UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/resetPass.jsp");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");
        HttpSession session = req.getSession();
        Object temp = session.getAttribute("user");
        UserModel user = (UserModel) temp;
        int id = user.get_id();
        String oldPass = user.getHashed_password();

        if(password.equals(oldPass))
        {
            service.ResetPassword(id,rePassword);
            req.setAttribute("success", true);
            req.getRequestDispatcher("/views/web/checkOut.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("success", true);
            req.getRequestDispatcher("/views/auth/resetPass.jsp").forward(req,resp);
        }
    }
}
