package WebEcommerce.Controller.admin.delivery;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.DeliveryModel;
import WebEcommerce.Service.DeliveryService;
import WebEcommerce.Service.Impl.DeliveryServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import vn.iotstar.util.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AddDeliveryController", value = "/admin/delivery/add")
public class AddDeliveryController extends HttpServlet {
    DeliveryService deliveryService = new DeliveryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/delivery/addDelivery.jsp");
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
            }
            deliveryService.insert(delivery);
            response.sendRedirect(request.getContextPath() + "/admin/delivery");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
