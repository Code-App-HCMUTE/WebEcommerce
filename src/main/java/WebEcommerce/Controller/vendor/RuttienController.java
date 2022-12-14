package WebEcommerce.Controller.vendor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.TransactionService;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.Impl.TransactionServiceImpl;

@WebServlet("/vendor/Withdraw")
public class RuttienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService storeService = new StoreServiceImpl();
	TransactionService transactionService = new TransactionServiceImpl();

	public RuttienController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String money = request.getParameter("money");
			int sotien = Integer.parseInt(money);
			storeService.Ruttien(sotien);
			transactionService.insertTransaction(sotien);
			response.sendRedirect(request.getContextPath() + "/vendor/transactions");
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
