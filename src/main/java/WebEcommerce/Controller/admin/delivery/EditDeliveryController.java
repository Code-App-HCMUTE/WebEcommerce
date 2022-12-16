package WebEcommerce.Controller.admin.delivery;

import WebEcommerce.Model.DeliveryModel;
import WebEcommerce.Service.DeliveryService;
import WebEcommerce.Service.Impl.DeliveryServiceImpl;
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

@WebServlet(name = "EditDeliveryController", value = "/admin/delivery/edit")
public class EditDeliveryController extends HttpServlet {
    DeliveryService deliveryService =  new DeliveryServiceImpl();
    private int id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        DeliveryModel deliveryModel = deliveryService.get(id);
        request.setAttribute("delivery", deliveryModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/delivery/editDelivery.jsp");
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
        DeliveryModel delivery = new DeliveryModel();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("name")) {
                    delivery.setName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("description")) {
                    delivery.setDescription(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("price")) {
                    delivery.setPrice(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("isDeleted")) {
                    delivery.setIsDeleted(item.getString("UTF-8").equals("on"));
                }
                Date date = java.sql.Date.valueOf(LocalDate.now());
                delivery.setCreatedAt(date);
                delivery.setUpdatedAt(date);
                delivery.set_id(id);
            }
            deliveryService.edit(delivery);
            response.sendRedirect(request.getContextPath() + "/admin/delivery");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
