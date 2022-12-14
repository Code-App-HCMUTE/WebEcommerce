package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StoreHomeController", value = "/admin/store")
public class StoreHomeController extends HttpServlet {
    StoreService storeService = new StoreServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<StoreModel> storeList =  storeService.getAllStore();
         request.setAttribute("storeList",storeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/store/store.jsp");
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
