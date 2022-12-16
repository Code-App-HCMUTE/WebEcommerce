package WebEcommerce.Controller.admin.Product;

import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteProductController", value = "/admin/product/delete")
public class DeleteProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        productService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/product");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
