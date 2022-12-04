package WebEcommerce.Controller.auth;

import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
        try{
            String firstName = request.getParameter("username");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String rePass = request.getParameter("re-password");
            System.out.println(firstName);
            System.out.println(phone);
            System.out.println(pass);
            System.out.println(rePass);

            if(pass.equals(rePass)){

                    service.Register(email,phone,pass,firstName);
                    response.sendRedirect("/WebEcommerce/auth/login");
            }
            else {
                response.sendRedirect("/WebEcommerce/auth/register");
            }
        }
        catch (Exception e) {
            System.out.println(e);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }
}
