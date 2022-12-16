package WebEcommerce.Controller.admin.Order;

import WebEcommerce.Service.Impl.OrderServiceImpl;
import WebEcommerce.Service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteOrderController", value = "/admin/order/delete")
public class DeleteOrderController extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/order");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
