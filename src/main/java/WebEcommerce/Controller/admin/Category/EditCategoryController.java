package WebEcommerce.Controller.admin.Category;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.CategoryService;
import WebEcommerce.Service.Impl.CategoryServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import vn.iotstar.util.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EditCategoryController", value = "/admin/category/edit")
public class EditCategoryController extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();
    private int id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CategoryModel> categoryList = categoryService.findAll();
        id = Integer.parseInt(request.getParameter("id"));
        CategoryModel categoryModel = categoryService.get(id);
        request.setAttribute("categorys", categoryList);
        request.setAttribute("category", categoryModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/category/editCategory.jsp");
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
        CategoryModel category = new CategoryModel();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("name")) {
                    category.setName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("image")) {
                    if (item.getSize() > 0) {
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File(Constant.DIR + "/category/" + fileName);
                        item.write(file);
                        category.setImage(fileName);
                    } else {
                        CategoryModel oldCategory = categoryService.get(id);
                        category.setImage(oldCategory.getImage());
                    }
//                    String originalFileName = item.getName();
//                    int index = originalFileName.lastIndexOf(".");
//                    String ext = originalFileName.substring(index + 1);
//                    String fileName = System.currentTimeMillis() + "." + ext;
//                    File file = new File(Constant.DIR + "/category/" + fileName);
//                    item.write(file);
//                    category.setImage(fileName);
                } else if (item.getFieldName().equals("categoryId")) {
                    category.setCartId(Integer.parseInt(item.getString("UTF-8")));
                } else if (item.getFieldName().equals("isDeleted")) {
                    category.setIsDeleted(item.getString("UTF-8").equals("on"));
                }
                Date date = java.sql.Date.valueOf(LocalDate.now());
                category.setCreatedAt(date);
                category.setUpdatedAt(date);
                category.setId(id);
            }
            categoryService.edit(category);
            response.sendRedirect(request.getContextPath() + "/admin/category");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
