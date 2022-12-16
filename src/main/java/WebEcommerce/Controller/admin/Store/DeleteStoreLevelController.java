package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Service.Impl.StoreLevelServiceImpl;
import WebEcommerce.Service.StoreLevelService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteStoreLevelController", value = "/admin/storeLevel/delete")
public class DeleteStoreLevelController extends HttpServlet {
    StoreLevelService storeLevelService = new StoreLevelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        storeLevelService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/storeLevel");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
