package WebEcommerce.Controller.web;

import WebEcommerce.Model.*;
import WebEcommerce.Service.CartService;
import WebEcommerce.Service.Impl.CartServiceImpl;
import WebEcommerce.Service.Impl.OrderItemServiceImpl;
import WebEcommerce.Service.Impl.OrderServiceImpl;
import WebEcommerce.Service.OrderItemService;
import WebEcommerce.Service.OrderService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CheckOutController", urlPatterns = {"/checkout"})
public class CheckOutController extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 5470713967110329358L;
    CartService cartService = new CartServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    OrderItemService orderItemService = new OrderItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object temp = session.getAttribute("user");
        UserModel user = (UserModel) temp;

        request.setAttribute("products", cartService.ListItemOfUser(user.get_id()));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/checkOut.jsp");
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
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            HttpSession session = request.getSession();
            Object temp = session.getAttribute("user");
            UserModel user = (UserModel) temp;
            Object temp2 = session.getAttribute("cart");
            List<ProductModel> listProduct = (List<ProductModel>) temp2;
            OrderModel order = new OrderModel();
            order.setUserId(user.get_id());
            order.setAddress(user.getAddress());
            order.setPhone(user.getPhone());
            order.setStatus("Đang xử lý");
            orderService.insert(order);

            for (ProductModel item : listProduct
            ) {
                OrderItemModel orderItem = new OrderItemModel();
                orderItem.setProductId(item.getId());
                orderItem.setCount(item.getCount());
                orderItem.setOrderId(orderService.LastInserted());
                orderItemService.insert(orderItem);
            }
            cartService.delete(user.get_id());
            session.setAttribute("order",orderService.userOrder(user.get_id()));
            session.setAttribute("cart",cartService.ListItemOfUser(user.get_id()));
            response.sendRedirect("/WebEcommerce/cart");
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}