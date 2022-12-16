package WebEcommerce.Controller.admin;

import WebEcommerce.Dao.Impl.OrderDaoImpl;
import WebEcommerce.Dao.Impl.ProductDaoImpl;
import WebEcommerce.Dao.OrderDao;
import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.TransactionServiceImpl;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.TransactionService;
import WebEcommerce.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "HomeAdmin", urlPatterns = {"/admin/home"})
public class HomeController extends HttpServlet {
    ProductDao productDao = new ProductDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    TransactionService transactionService = new TransactionServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);

        String year = request.getParameter("sellYear");
        String orderYear = request.getParameter("orderYear");

        if (year == null) {
            year = "2022";

        }
        if (orderYear == null) {
            orderYear = "2022";
        }
        request.setAttribute("sellYear", year);
        request.setAttribute("orderYear", orderYear);

        int sumMoneyOder = orderDao.SumMoneySell(Integer.parseInt(year));
        int countOrder = orderDao.CountOrder(Integer.parseInt(orderYear));
        int transaction = transactionService.sumMoneyTransaction(2022);

        float percentTransaction =  (transaction - transactionService.sumMoneyTransaction(2021))/ (transactionService.sumMoneyTransaction(2021)) * 100;

        List<UserModel> userNew = userService.getUserNew();

        request.setAttribute("countOrder", vn.format(countOrder));
        request.setAttribute("countSumSell", vn.format(sumMoneyOder));
        request.setAttribute("transaction", vn.format(transaction));
        request.setAttribute("transactionPercent",percentTransaction);
        request.setAttribute("userNew", userNew);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<ProductModel> productList = productDao.findAll();
        System.out.println(productList);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
