package WebEcommerce.Controller.web;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.ProductService;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.UserService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    UserService userService = new UserServiceImpl();
    StoreService storeService =new StoreServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        String query = request.getParameter("searchValue");
        String index = request.getParameter("index");
        String type = request.getParameter("search");
        System.out.println(type);
        if(type.equals("product")) {
            request.setAttribute("searchValue",query);
            request.setAttribute("search",type);
            request.setAttribute("listName","product");
            request.setAttribute("search",type);
            request.setAttribute("list", productService.search(query, 6, Integer.parseInt(index)));
            int count = productService.SearchCount(query,"select * from product where name like '%"+query+"%'")/6;

            request.setAttribute("pageCount",count+1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/shopGrid.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (type.equals("user")) {
            request.setAttribute("searchValue",query);
            request.setAttribute("search",type);
            request.setAttribute("listName","user");
            request.setAttribute("search",type);
            request.setAttribute("list", userService.Search(query, 6, Integer.parseInt(index)));
            System.out.println(userService.Search(query, 6, Integer.parseInt(index)).size());
            int count = userService.SearchCount(query)/6;
            request.setAttribute("pageCount",count+1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/shopGrid.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            request.setAttribute("searchValue",query);
            request.setAttribute("search",type);
            request.setAttribute("listName","store");
            request.setAttribute("list", storeService.search(query, 6, Integer.parseInt(index)));
            int count = 1/6;

            request.setAttribute("pageCount",count+1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/shopGrid.jsp");
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


    }
}
