package WebEcommerce.Controller.web;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.Impl.UserServiceImpl;
import WebEcommerce.Service.UserService;
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
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/UserProfile"})
public class UserProfile extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 5470713967110329358L;
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/userProfile.jsp");
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
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            UserModel user = new UserModel();
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("images")) {
                    if (item.getSize() > 0) {
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File(Constant.DIR + "/user/" + fileName);
                        item.write(file);
                        user.setAvatar(fileName);
                    }
                    else {
                        HttpSession session = request.getSession();
                        Object temp = session.getAttribute("user");
                        UserModel oldUser = (UserModel) temp;
                        user.setAvatar(oldUser.getAvatar());
                    }

                }
                else if(item.getFieldName().equals("firstName")){
                    user.setFistName(item.getString("UTF-8"));
                }else if(item.getFieldName().equals("lastName")){
                    user.setLastName(item.getString("UTF-8"));
                }else if(item.getFieldName().equals("phone")){
                    user.setPhone(item.getString("UTF-8"));
                }else if(item.getFieldName().equals("email")){
                    user.setEmail(item.getString("UTF-8"));
                }else if(item.getFieldName().equals("address")){
                    user.setAddress(item.getString("UTF-8"));
                }
                Date date = java.sql.Date.valueOf(LocalDate.now());
                user.setCreatedAt(date);
                user.setUpdatedAt(date);
            }
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            service.update(id,user);
            session.setAttribute("user",user);
            request.setAttribute("success", true);
            request.getRequestDispatcher("/views/auth/userProfile.jsp").forward(request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}




