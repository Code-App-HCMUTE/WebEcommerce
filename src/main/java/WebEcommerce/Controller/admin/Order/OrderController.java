package WebEcommerce.Controller.admin.Order;

import WebEcommerce.Model.DeliveryModel;
import WebEcommerce.Model.OrderModel;
import WebEcommerce.Service.Impl.OrderServiceImpl;
import WebEcommerce.Service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderController", value = "/admin/order")
public class OrderController extends HttpServlet {
    OrderService orderService  = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderModel> Orders = orderService.findAll();
        System.out.println(Orders);
        request.setAttribute("listOrder", Orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/order/order.jsp");
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
