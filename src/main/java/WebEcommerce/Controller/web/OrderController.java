package WebEcommerce.Controller.web;

import WebEcommerce.Model.OrderItemModel;
import WebEcommerce.Model.OrderModel;
import WebEcommerce.Service.Impl.OrderItemServiceImpl;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.OrderItemService;
import WebEcommerce.Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet( value = "/order")

public class OrderController extends HttpServlet {
    OrderItemService orderItemService =new OrderItemServiceImpl();
    ProductService productService =new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        Object temp =  session.getAttribute("order");
        List<OrderModel> orders = (List<OrderModel> )temp;
        for (OrderModel item:orders
             ) {
            item.setOrderItems(orderItemService.ListByOrder(item.getId()));
            for (OrderItemModel i: item.getOrderItems()
                 ) {
                i.setProduct(productService.get(i.getProductId()));
            }
        }
        session.setAttribute("order",orders);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/order.jsp");
//lấy dữ liệu từ tham số của form

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
