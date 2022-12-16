package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Model.StoreLevelModel;
import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.Impl.StoreLevelServiceImpl;
import WebEcommerce.Service.StoreLevelService;
import WebEcommerce.Service.StoreService;
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

@WebServlet(name = "AddStorelevelController", value = "/admin/storeLevel/add")
public class AddStorelevelController extends HttpServlet {
    StoreLevelService storeLevelService = new StoreLevelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/store/addStoreLevel.jsp");
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
            }
            storeLevelService.insert(storeLevel);
            response.sendRedirect(request.getContextPath() + "/admin/storeLevel");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
