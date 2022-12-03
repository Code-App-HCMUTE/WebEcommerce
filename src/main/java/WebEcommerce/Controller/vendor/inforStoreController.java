package WebEcommerce.Controller.vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.Impl.StoreServiceImpl;

@WebServlet(urlPatterns = {"/vendor/infor"})
public class inforStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService storeService=new StoreServiceImpl();
    public inforStoreController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		StoreModel store=storeService.getStoreById(6);
        request.setAttribute("store", store);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/infoStore.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
