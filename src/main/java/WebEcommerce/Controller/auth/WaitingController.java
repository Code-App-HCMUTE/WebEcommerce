package WebEcommerce.Controller.auth;

import WebEcommerce.Model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {
            UserModel u = (UserModel) session.getAttribute("user");
            if(u.getRole().equals("user"))
            {
                response.sendRedirect(request.getContextPath() + "/home");
            }
            else if(u.getRole().equals("admin"))
            {
                response.sendRedirect(request.getContextPath() + "/admin/home");
            }
			/*request.setAttribute("user", u);
			request.getRequestDispatcher("/common/vendor/header.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/vendor/home");*/
        } else {
            response.sendRedirect(request.getContextPath() + "/auth/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
