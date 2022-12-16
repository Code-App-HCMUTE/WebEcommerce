package WebEcommerce.Controller.admin.Category;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Service.CategoryService;
import WebEcommerce.Service.Impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/admin/category")
public class CategoryController extends HttpServlet {
    CategoryService categoryService =  new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryModel> categoryList = categoryService.findAll();
        request.setAttribute("listCategorys", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/category/category.jsp");
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
