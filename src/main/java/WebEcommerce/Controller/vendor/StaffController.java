package WebEcommerce.Controller.vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.Impl.StoreServiceImpl;

@WebServlet(urlPatterns = {"/vendor/staff"})
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService storeService=new StoreServiceImpl();
    public StaffController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel owner=storeService.getOwnerStore();
		request.setAttribute("owner", owner);
		int staff=storeService.countStaffInStore();
		request.setAttribute("staff", staff);
		UserModel nv=storeService.getStaff();
		request.setAttribute("nv", nv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/Staff.jsp");
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
