package WebEcommerce.Controller.admin.Style;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StyleModel;
import WebEcommerce.Service.Impl.StyleServiceImpl;
import WebEcommerce.Service.StyleService;
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

@WebServlet(name = "AddStyleController", value = "/admin/style/add")
public class AddStyleController extends HttpServlet {
    StyleService styleService = new StyleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StyleModel> styleList = styleService.findAll();
        request.setAttribute("styles", styleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/style/addStyle.jsp");
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
        StyleModel style = new StyleModel();
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
                    style.setName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("categoryId")) {
                    style.setCaId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("isDeleted")) {
                    style.setIsDelete(item.getString("UTF-8").equals("on"));
                }
                Date date = java.sql.Date.valueOf(LocalDate.now());
                style.setCreatedAt(date);
                style.setUpdatedAt(date);
            }
            styleService.insert(style);

            response.sendRedirect(request.getContextPath() + "/admin/style");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
