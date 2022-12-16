package WebEcommerce.Controller.vendor;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.ProductService;
import WebEcommerce.Service.Impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/vendor/products"})
public class ProductsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProductService productService=new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductModel> products = productService.findAllByStore();
        request.setAttribute("products", products);
        List<ProductModel> productsActive = productService.getAllProductIsActive();
        request.setAttribute("productactive", productsActive);
        List<ProductModel> productsUnActive = productService.getAllProductUnActive();
        request.setAttribute("productunactive", productsUnActive);
        List<ProductModel> productsQuantity = productService.getAllProductQuantity();
        request.setAttribute("productquantity", productsQuantity);
        List<ProductModel> productsNoQuantity = productService.getAllProductNoQuantity();
        request.setAttribute("productnoquantity", productsNoQuantity);
        String query = request.getParameter("txt");
        String index = request.getParameter("index");
        if(index==null)
        {
        	index="1";
        	query="";
        }
        request.setAttribute("products", productService.searchByStore(query, 10, Integer.parseInt(index)));
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
