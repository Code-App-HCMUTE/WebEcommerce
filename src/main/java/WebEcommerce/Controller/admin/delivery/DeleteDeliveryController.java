package WebEcommerce.Controller.admin.delivery;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.DeliveryModel;
import WebEcommerce.Service.DeliveryService;
import WebEcommerce.Service.Impl.DeliveryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteDeliveryController", value = "/admin/delivery/delete")
public class DeleteDeliveryController extends HttpServlet {
    DeliveryService deliveryService = new DeliveryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DeliveryModel deliveryModel = deliveryService.get(id);
        deliveryService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/delivery");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
