package WebEcommerce.Controller.admin.Style;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StyleModel;
import WebEcommerce.Service.Impl.StyleServiceImpl;
import WebEcommerce.Service.StyleService;
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

@WebServlet(name = "StyleController", value = "/admin/style")
public class StyleController extends HttpServlet {
    StyleService styleService = new StyleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StyleModel> styleList = styleService.findAll();
        request.setAttribute("listStyles", styleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/style/style.jsp");
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
