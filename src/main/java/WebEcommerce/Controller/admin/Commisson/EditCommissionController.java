package WebEcommerce.Controller.admin.Commisson;

import WebEcommerce.Model.CommissionModel;
import WebEcommerce.Service.CommissionService;
import WebEcommerce.Service.Impl.CommissionServiceImpl;
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

@WebServlet(name = "EditCommissionController", value = "/admin/commission/edit")
public class EditCommissionController extends HttpServlet {
    private int id;
    CommissionService commissionService = new CommissionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        CommissionModel commissionModel =  commissionService.get(id);
        System.out.println(commissionModel);
        request.setAttribute("commission", commissionModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/commission/editCommission.jsp");
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
        CommissionModel commission = new CommissionModel();
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
                    commission.setName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("cost")) {
                    commission.setCost(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("description")) {
                    commission.setDescription(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("isDelete")) {
                    commission.setIsDelete(item.getString("UTF-8").equals("on"));
                }
                Date date = java.sql.Date.valueOf(LocalDate.now());
                commission.setCreatedAt(date);
                commission.setUpdatedAt(date);
                commission.setId(id);
            }
            commissionService.edit(commission);
            response.sendRedirect(request.getContextPath() + "/admin/commission");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
