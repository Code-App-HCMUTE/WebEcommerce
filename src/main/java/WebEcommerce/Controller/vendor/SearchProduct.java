package WebEcommerce.Controller.vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("txt");
        String index = request.getParameter("index");
        
        System.out.println(index);
        if(index==null)
        {
        	index="1";
        }
        System.out.println(index);
        request.setAttribute("products", productService.search(query, 10, Integer.parseInt(index)));
        request.setAttribute("txt",query);
        int count=productService.CountProduct(query);
        request.setAttribute("index",index);
        request.setAttribute("pageCount",count+1);
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

}
