package WebEcommerce.Controller.admin;

import WebEcommerce.Dao.Impl.ProductDaoImpl;
import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Model.ProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeAdmin", urlPatterns = {"/admin/home"})
public class HomeController extends HttpServlet {
    ProductDao productDao =  new ProductDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/home.jsp");


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

        List<ProductModel> productList = productDao.findAll();
        System.out.println(productList);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
