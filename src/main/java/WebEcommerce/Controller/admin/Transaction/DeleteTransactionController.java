package WebEcommerce.Controller.admin.Transaction;

import WebEcommerce.Service.Impl.TransactionServiceImpl;
import WebEcommerce.Service.TransactionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTransactionController", value = "/admin/transaction/delete")
public class DeleteTransactionController extends HttpServlet
{
    TransactionService transactionService = new TransactionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        transactionService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/transaction");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
