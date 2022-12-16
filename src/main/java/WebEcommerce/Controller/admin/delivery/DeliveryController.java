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

@WebServlet(name = "DeliveryController", value = "/admin/delivery")
public class DeliveryController extends HttpServlet {
    DeliveryService deliveryService = new DeliveryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DeliveryModel> deliverys = deliveryService.findAll();
        request.setAttribute("listDelivery", deliverys);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/delivery/delivery.jsp");
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
