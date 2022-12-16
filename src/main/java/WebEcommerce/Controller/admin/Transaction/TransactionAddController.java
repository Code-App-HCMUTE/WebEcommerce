package WebEcommerce.Controller.admin.Transaction;

import WebEcommerce.Model.CommissionModel;
import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.TransactionModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.Impl.TransactionServiceImpl;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.TransactionService;
import WebEcommerce.Service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TransactionAddController", value = "/admin/transaction/add")
public class TransactionAddController extends HttpServlet {
    TransactionService transactionService = new TransactionServiceImpl();
    UserService userService = new UserServiceImpl();
    StoreService storeService = new StoreServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserModel> users =  userService.GetAllUser();
        List<StoreModel> stores =  storeService.getAllStore();
        System.out.println(users);

        request.setAttribute("users", users);
        request.setAttribute("stores", stores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/transaction/addTransaction.jsp");
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
        TransactionModel transaction = new TransactionModel();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("userId")) {
                    transaction.setUserId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("storeId")) {
                    transaction.setStoreId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("isUp")) {
                    transaction.setIsUp(item.getString("UTF-8").equals("on"));
                } else if (item.getFieldName().equals("amount")) {
                    transaction.setAmount(Integer.parseInt(item.getString("UTF-8")));
                }
                Date date = java.sql.Date.valueOf(LocalDate.now());
                transaction.setCreatedAt(date);
                transaction.setUpdatedAt(date);
            }
            transactionService.insert(transaction);
            response.sendRedirect(request.getContextPath() + "/admin/transaction");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
