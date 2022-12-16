package WebEcommerce.Controller.auth;

import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.UserService;
import vn.iotstar.util.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/auth/login")
public class LoginController extends HttpServlet {
    /**
	 * 
	 */
    private static final long serialVersionUID = 4678896083212205531L;
    UserService userService=new UserServiceImpl();

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/login.jsp");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath() + "/waiting");
            return;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/waiting");
                    return;
                }
            }
        }
        request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        UserModel user = userService.login(username, password);
        boolean isRememberMe = false;
        String remember = request.getParameter("remember");
        if ("on".equals(remember)) {
            isRememberMe = true;
        }
        String alertMsg = "";
        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
            return;
        }
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);
            if (isRememberMe) {
                saveRemeberMe(response, username);
            }
            response.sendRedirect(request.getContextPath() + "/waiting");
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng "+username+" "+password;
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
    }
    private void saveRemeberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }
}
