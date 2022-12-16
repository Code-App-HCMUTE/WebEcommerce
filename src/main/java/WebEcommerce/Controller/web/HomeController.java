package WebEcommerce.Controller.web;


import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.CartService;
import WebEcommerce.Service.CategoryService;
import WebEcommerce.Service.Impl.CartServiceImpl;
import WebEcommerce.Service.Impl.CategoryServiceImpl;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.ProductService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("category",categoryService.findAll());
        req.setAttribute("products", productService.search("",8,1));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/home.jsp");
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
    //logout
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.invalidate();
        System.out.println("You are successfully logged out!");
        resp.sendRedirect("/WebEcommerce/home");
    }
}
