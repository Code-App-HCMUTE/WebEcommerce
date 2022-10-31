package WebEcommerce.Controller.auth;

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

        if (user.equals("trung") && pass.equals("123")) {
//khởi tạo cookie
            Cookie cookie = new Cookie("username", user);
//thiết lập thời gian tồn tại 30s của cookie
            cookie.setMaxAge(30);
//thêm cookie vào response
            response.addCookie(cookie);
//chuyển sang trang HelloServlet
            response.sendRedirect("/WebEcommerce/home");
        } else {
//chuyển sang trang LoginServlet
            response.sendRedirect("/WebEcommerce/auth/login");
        }
    }
}
