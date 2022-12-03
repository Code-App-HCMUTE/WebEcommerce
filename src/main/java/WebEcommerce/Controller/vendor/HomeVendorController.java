package WebEcommerce.Controller.vendor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.Impl.StoreServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeVendor", urlPatterns = {"/vendor/home"})
public class HomeVendorController extends HttpServlet {
    StoreService storeService=new StoreServiceImpl();
	private static final long serialVersionUID = -25713478272773637L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StoreModel> stores=storeService.getAllStore();
        request.setAttribute("stores", stores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/home.jsp");
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
