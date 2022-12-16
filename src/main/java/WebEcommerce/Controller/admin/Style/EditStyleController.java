package WebEcommerce.Controller.admin.Style;

import WebEcommerce.Model.StyleModel;
import WebEcommerce.Service.Impl.StyleServiceImpl;
import WebEcommerce.Service.StoreService;
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

@WebServlet(name = "EditStyleController", value = "/admin/style/edit")
public class EditStyleController extends HttpServlet {
    StyleService styleService = new StyleServiceImpl();
    private int id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        id = Integer.parseInt(request.getParameter("id"));
        StyleModel styleModel = styleService.get(id);
        List<StyleModel> styleList = styleService.findAll();
        request.setAttribute("styles", styleList);
        request.setAttribute("style", styleModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/style/editStyle.jsp");
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
                style.setId(id);
            }
            styleService.edit(style);
            response.sendRedirect(request.getContextPath() + "/admin/style");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
