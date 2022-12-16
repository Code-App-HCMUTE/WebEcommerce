package WebEcommerce.Controller.auth;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.CartService;
import WebEcommerce.Service.Impl.CartServiceImpl;
import WebEcommerce.Service.Impl.OrderServiceImpl;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.OrderService;
import WebEcommerce.Service.UserService;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginController", value = "/auth/login")
public class LoginController extends HttpServlet {
    /**
     *
     */
    UserService service = new UserServiceImpl();
    private static final long serialVersionUID = 4678896083212205531L;
    CartService cartService =new CartServiceImpl();
    OrderService orderService = new OrderServiceImpl();

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
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        UserModel data = service.login(email,pass);
        if(isValidEmailAddress(email)){
            if (data!=null) {
                HttpSession session = request.getSession();

                session.setAttribute("user",data);
                session.setAttribute("cart",cartService.ListItemOfUser(data.get_id()));
                session.setAttribute("order",orderService.userOrder(data.get_id()));
                Object temp = session.getAttribute("user");
                UserModel user = (UserModel) temp;
                List<ProductModel> list = cartService.ListItemOfUser(user.get_id());
                int total = 0;
                for (ProductModel item:list) {
                    total+=item.getPrice()*item.getCount();
                }
                session.setAttribute("total",total);
                response.sendRedirect("/WebEcommerce/home");
            } else {
                request.setAttribute("errMess","Sai email hoặc mật khẩu");
                request.getRequestDispatcher("/views/auth/login.jsp").forward(request,response);
            }
        }
        else{
            request.setAttribute("errMess","Email không hợp lệ");
            request.getRequestDispatcher("/views/auth/login.jsp").forward(request,response);
        }

    }
}
