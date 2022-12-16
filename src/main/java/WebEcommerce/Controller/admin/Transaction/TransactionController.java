package WebEcommerce.Controller.admin.Transaction;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.TransactionModel;
import WebEcommerce.Service.Impl.TransactionServiceImpl;
import WebEcommerce.Service.TransactionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.dsig.TransformService;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TransacssionController", value = "/admin/transaction")
public class TransactionController extends HttpServlet {
    TransactionService transactionService = new TransactionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TransactionModel> transactionList = transactionService.findAll();
        System.out.println(transactionList);
        request.setAttribute("transactionList", transactionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/transaction/transaction.jsp");
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
