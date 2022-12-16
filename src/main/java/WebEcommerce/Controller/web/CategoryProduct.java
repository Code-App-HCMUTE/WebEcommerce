package WebEcommerce.Controller.web;

import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/category"})
public class CategoryProduct extends HttpServlet {
    ProductService service = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int catId =Integer.parseInt(  req.getParameter("id"));
        req.setAttribute("list",service.productByCat(catId,6,1));
        int count = service.SearchCount("catId","select * from product where categoryId = "+catId)/6;
        req.setAttribute("pageCount",count+1);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/productByCat.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
