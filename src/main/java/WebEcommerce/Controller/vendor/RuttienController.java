package WebEcommerce.Controller.vendor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.TransactionService;
import WebEcommerce.Service.UserService;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.Impl.TransactionServiceImpl;
import WebEcommerce.Service.Impl.UserServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet("/vendor/Withdraw")
public class RuttienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService storeService = new StoreServiceImpl();
	TransactionService transactionService = new TransactionServiceImpl();
	UserService userService = new UserServiceImpl();

	public RuttienController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			UserModel u = (UserModel) session.getAttribute("account");
			String money = request.getParameter("money");
			String password = request.getParameter("password");
			if (money == "") {
				money = "0";
			}
			int sotien = Integer.parseInt(money);
			StoreModel storeModel = storeService.getStoreById(Constant.idStore);
			System.out.println(storeService.getOwnerStore().getHashed_password());
			if (storeModel.getE_wallet() - sotien > 0) {
				if (u.get_id() == storeModel.getOwnerId()) {
					System.out.println(password + " pass");
					if (password.equals(storeService.getOwnerStore().getHashed_password())) {
						storeService.Ruttien(sotien);
						transactionService.insertTransaction(sotien);
						System.out.println("succ");
						response.sendRedirect(request.getContextPath() + "/vendor/transactions");
					}
					else {
						response.sendRedirect(request.getContextPath() + "/vendor/transactions");
					}
				} else {
					response.sendRedirect(request.getContextPath() + "/vendor/transactions");
				}

			} else {
				response.sendRedirect(request.getContextPath() + "/vendor/transactions");
			}
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
