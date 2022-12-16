package WebEcommerce.Controller.admin.Product;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/admin/product")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("search");
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
            query = "";
        }
        System.out.println(query);
        request.setAttribute("listProducts", productService.search(query, 10, Integer.parseInt(index)));
        request.setAttribute("search", query);
        int count = productService.SearchCount(query,"select * from product ");
        int pag = count / 10;

        request.setAttribute("index", index);
        request.setAttribute("pageCount", pag + 1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/product/Product.jsp");
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
        String query =  request.getParameter("search");
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        request.setAttribute("listProducts", productService.search(query, 10, Integer.parseInt(index)));
        request.setAttribute("search", query);
        int count = productService.SearchCount(query,"select * from product ");
        int pag = count / 10;

        request.setAttribute("index", index);
        request.setAttribute("pageCount", pag + 1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/product/Product.jsp");
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
}
