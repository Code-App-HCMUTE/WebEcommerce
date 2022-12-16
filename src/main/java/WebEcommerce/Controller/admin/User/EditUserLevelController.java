package WebEcommerce.Controller.admin.User;

import WebEcommerce.Model.StoreLevelModel;
import WebEcommerce.Model.UserLevelModel;
import WebEcommerce.Service.Impl.UserLevelServiceImpl;
import WebEcommerce.Service.UserLevelService;
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

@WebServlet(name = "EditUserLevelController", value = "/admin/userLevel/edit")
public class EditUserLevelController extends HttpServlet {
    private int id;
    UserLevelService userLevelService = new UserLevelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        UserLevelModel userLevelModel =  userLevelService.get(id);
        request.setAttribute("userLevel", userLevelModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/user/editUserLevel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserLevelModel userLevelModel = new UserLevelModel();
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
                    userLevelModel.setName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("minPoint")) {
                    userLevelModel.setMinPoint(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("discount")) {
                    userLevelModel.setDiscount(Integer.parseInt(item.getString("UTF-8")));
                }
                else if (item.getFieldName().equals("isDeleted")) {
                    userLevelModel.setIsDeleted(item.getString("UTF-8").equals("on"));
                }
                //Date date = new Date();
                Date date = java.sql.Date.valueOf(LocalDate.now());
                userLevelModel.setCreatedAt(date);
                userLevelModel.setUpdatedAt(date);
                userLevelModel.setId(id);
            }
            userLevelService.edit(userLevelModel);
            response.sendRedirect(request.getContextPath() + "/admin/userLevel");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
