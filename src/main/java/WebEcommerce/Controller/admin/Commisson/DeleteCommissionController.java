package WebEcommerce.Controller.admin.Commisson;

import WebEcommerce.Service.CommissionService;
import WebEcommerce.Service.Impl.CommissionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCommissionController", value = "/admin/commission/delete")
public class DeleteCommissionController extends HttpServlet {
    CommissionService  commissionService = new CommissionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        commissionService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/commission");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
