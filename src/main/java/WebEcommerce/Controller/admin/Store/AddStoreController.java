package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "StoreController", value = "/admin/store/add")
public class AddStoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreService storeService =  new StoreServiceImpl();
        List<StoreModel> listStore =  storeService.getAllStore();


        request.setAttribute("", listStore);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
