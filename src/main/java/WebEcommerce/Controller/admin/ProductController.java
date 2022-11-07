package WebEcommerce.Controller.admin;

import WebEcommerce.Dao.Impl.ProductDaoImpl;
import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Model.ProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductController", value = "/admin/product")
public class ProductController extends HttpServlet {
    ProductDao products = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        List<ProductModel> productList = products.findAll();
        request.setAttribute("listProducts", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/a dmin/Product.jsp");
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
