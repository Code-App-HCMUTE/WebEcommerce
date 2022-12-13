package WebEcommerce.Controller.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.ProductService;
import WebEcommerce.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/vendor/searchproduct" })
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();

	public SearchProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String txt1 = request.getParameter("txt");
		List<ProductModel> products = productService.searchProduct(txt1);
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/product.jsp");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
