package WebEcommerce.Controller.admin.Commisson;

import WebEcommerce.Model.CommissionModel;
import WebEcommerce.Service.CommissionService;
import WebEcommerce.Service.Impl.CommissionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CommissonController", value = "/admin/commission")
public class CommissonController extends HttpServlet {
    CommissionService commissionService = new CommissionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CommissionModel> commissionList = commissionService.findAll();
        request.setAttribute("commissionList", commissionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/commission/commission.jsp");
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
