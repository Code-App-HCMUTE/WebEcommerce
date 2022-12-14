package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.StoreLevelModel;
import WebEcommerce.Service.Impl.StoreLevelServiceImpl;
import WebEcommerce.Service.StoreLevelService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StoreLevelController", value = "/admin/storeLevel")
public class StoreLevelController extends HttpServlet {
    StoreLevelService storeLevelService =  new StoreLevelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StoreLevelModel> storeLevelList = storeLevelService.findAll();
        System.out.println(storeLevelList);
        request.setAttribute("listStoreLevel", storeLevelList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/store/storeLevel.jsp");
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
