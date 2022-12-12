package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StoreController", value = "/store")
public class StoreController extends HttpServlet {
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
