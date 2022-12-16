package WebEcommerce.Controller.vendor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Service.ProductService;
import WebEcommerce.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/vendor/product/delete"})
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService=new ProductServiceImpl();
    public DeleteProductController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		productService.deleteByStore(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath() + "/vendor/products");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
