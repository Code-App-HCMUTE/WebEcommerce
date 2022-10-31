package WebEcommerce.Controller.vendor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeVendor", urlPatterns = {"/vendor/home"})
public class HomeController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -25713478272773637L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/home.jsp");


//        String name="";
//        //Nhận cookie
//        Cookie[] cookie = request.getCookies();
//        for (Cookie c: cookie) {
//            if(c.getName().equals("email")) {
//                name = c.getValue();}}
//        request.setAttribute("user", name);
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
