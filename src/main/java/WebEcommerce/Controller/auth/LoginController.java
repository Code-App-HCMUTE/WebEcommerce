package WebEcommerce.Controller.auth;

import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/auth/login")
public class LoginController extends HttpServlet {
    /**
	 * 
	 */
    UserService service = new UserServiceImpl();
	private static final long serialVersionUID = 4678896083212205531L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/login.jsp");
//lấy dữ liệu từ tham số của form

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
        String user = request.getParameter("email");
        String pass = request.getParameter("password");
        UserModel data = service.login(user,pass);
        if (data!=null) {
//khởi tạo cookie
            Cookie cookie = new Cookie("user", user);

            cookie.setMaxAge(30);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/WebEcommerce/home");
        } else {
//chuyển sang trang LoginServlet
            response.sendRedirect("/WebEcommerce/auth/login");
        }
    }
}
