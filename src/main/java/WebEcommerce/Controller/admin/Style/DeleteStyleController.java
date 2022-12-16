package WebEcommerce.Controller.admin.Style;

import WebEcommerce.Service.Impl.StyleServiceImpl;
import WebEcommerce.Service.StyleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteStyleController", value = "/admin/style/delete")
public class DeleteStyleController extends HttpServlet {
    StyleService styleService = new StyleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        styleService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/style");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
