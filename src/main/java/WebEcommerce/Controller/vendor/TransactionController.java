package WebEcommerce.Controller.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import WebEcommerce.Model.TransactionModel;
import WebEcommerce.Service.TransactionService;
import WebEcommerce.Service.Impl.TransactionServiceImpl;

@WebServlet("/vendor/transactions")
public class TransactionController extends HttpServlet {
	TransactionService transactionService=new TransactionServiceImpl();
	private static final long serialVersionUID = 1L;
    public TransactionController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TransactionModel> transactions=transactionService.getAll();
		request.setAttribute("transactions", transactions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/transaction.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
