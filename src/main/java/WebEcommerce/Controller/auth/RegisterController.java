package WebEcommerce.Controller.auth;

import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "RegisterController", value = "/auth/register")
public class RegisterController extends HttpServlet {
    /**
	 * 
	 */
    UserService service = new UserServiceImpl();
	private static final long serialVersionUID = 9043214505787199706L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/register.jsp");
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
        try {
            UserModel user = new UserModel();
            user.setFirstName(request.getParameter("username"));
            user.setPhone(request.getParameter("phone"));
            user.setEmail(request.getParameter("email"));
            String pass = request.getParameter("password");
            user.setHashed_password(pass);
            String rePass = request.getParameter("re-password");
            Date date = java.sql.Date.valueOf(LocalDate.now());
            user.setCreatedAt(date);
            user.setUpdatedAt(date);
            if(service.SearchEmailCount(request.getParameter("email"))==0)
            {
                if (pass.equals(rePass)) {

                    service.Register(user);
                    response.sendRedirect("/WebEcommerce/auth/login");
                } else {
                    request.setAttribute("errMess", "Mật khẩu không trùng khớp");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/register.jsp");
                }
            }
            else{
                request.setAttribute("errMess", "Email đã tồn tại");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/register.jsp");
            }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
