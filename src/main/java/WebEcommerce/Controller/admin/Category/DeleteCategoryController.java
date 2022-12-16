package WebEcommerce.Controller.admin.Category;

import WebEcommerce.Service.CategoryService;
import WebEcommerce.Service.Impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryController", value = "/admin/category/delete")
public class DeleteCategoryController extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        categoryService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/category");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
