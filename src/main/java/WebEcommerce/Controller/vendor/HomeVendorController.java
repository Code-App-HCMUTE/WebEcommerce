package WebEcommerce.Controller.vendor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import vn.iotstar.util.Constant;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeVendor", urlPatterns = { "/vendor/home" })
public class HomeVendorController extends HttpServlet {
	StoreService storeService = new StoreServiceImpl();
	private static final long serialVersionUID = -25713478272773637L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("account") != null) {
			UserModel u = (UserModel) session.getAttribute("account");
			List<StoreModel> stores = storeService.getStore(u.get_id());
			if(stores.size() > 0)
			{
				request.setAttribute("stores", stores);
				Constant.idStore = stores.get(0).get_id();
				System.out.println(Constant.idStore);
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
			else {
				response.sendRedirect("/WebEcommerce/auth/CreateStore");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/auth/login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("You are successfully logged out!");
		response.sendRedirect("/WebEcommerce/auth/login");
	}
}
