package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Model.StoreLevelModel;
import WebEcommerce.Service.Impl.StoreLevelServiceImpl;
import WebEcommerce.Service.StoreLevelService;
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

@WebServlet(name = "EditStoreLevelController", value = "/admin/storeLevel/edit")
public class EditStoreLevelController extends HttpServlet {
    private int id;
    StoreLevelService storeLevelService =  new StoreLevelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        StoreLevelModel storeLevelModel =  storeLevelService.get(id);
        request.setAttribute("storeLevel", storeLevelModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/store/editStoreLevel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreLevelModel storeLevel = new StoreLevelModel();
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
                    storeLevel.setName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("minPoint")) {
                    storeLevel.setMinPoint(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("discount")) {
                    storeLevel.setDiscount(Integer.parseInt(item.getString("UTF-8")));
                }
                else if (item.getFieldName().equals("isDeleted")) {
                    storeLevel.setIsDeleted(item.getString("UTF-8").equals("on"));
                }
                //Date date = new Date();
                Date date = java.sql.Date.valueOf(LocalDate.now());
                storeLevel.setCreatedAt(date);
                storeLevel.setUpdatedAt(date);
                storeLevel.setId(id);
            }
            storeLevelService.edit(storeLevel);
            response.sendRedirect(request.getContextPath() + "/admin/storeLevel");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
