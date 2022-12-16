package WebEcommerce.Controller.admin.Order;

import WebEcommerce.Model.*;
import WebEcommerce.Service.*;
import WebEcommerce.Service.Impl.*;
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

@WebServlet(name = "AddOrderController", value = "/admin/order/add")
public class AddOrderController extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    UserService userService = new UserServiceImpl();
    StoreService storeService = new StoreServiceImpl();
    DeliveryService deliveryService = new DeliveryServiceImpl();
    CommissionService commissionService = new CommissionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserModel> userModelList = userService.GetAllUser();
        List<StoreModel> storeModelList = storeService.getAllStore();
        List<DeliveryModel> deliveryModelList = deliveryService.findAll();
        List<CommissionModel> commissionModelList = commissionService.findAll();
        request.setAttribute("users", userModelList);
        request.setAttribute("stores", storeModelList);
        request.setAttribute("deliverys", deliveryModelList);
        request.setAttribute("commissions", commissionModelList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/order/addOrder.jsp");
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
        OrderModel order = new OrderModel();
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
                    order.setUserId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("storeId")) {
                    order.setStoreId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("deliveryId")) {
                    order.setDeliveryId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("commissionId")) {
                    order.setCommissionId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("address")) {
                    order.setAddress(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("phone")) {
                    order.setPhone(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("status")) {
                    order.setStatus(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("isPaidBefore")) {
                    order.setIsPaidBefore(item.getString("UTF-8").equals("on"));
                } else if (item.getFieldName().equals("amountFromUser")) {
                    order.setAmountFromUser(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("amountFromStore")) {
                    order.setAmountFromStore(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("amountToStore")) {
                    order.setAmountToStore(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("amountToGD")) {
                    order.setAmountToGD(Integer.parseInt(item.getString("UTF-8")));
                }
                Date date = java.sql.Date.valueOf(LocalDate.now());
                order.setCreatedAt(date);
                order.setUpdatedAt(date);
            }
            orderService.insert(order);
            response.sendRedirect(request.getContextPath() + "/admin/order");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
