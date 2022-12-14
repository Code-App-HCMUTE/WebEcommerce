package WebEcommerce.Controller.admin.Store;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.StoreService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import vn.iotstar.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "StoreController", value = "/admin/store/add")
public class AddStoreController extends HttpServlet {
    StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StoreModel> listStore = storeService.getAllStore();
        request.setAttribute("", listStore);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreModel store = new StoreModel();
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
                    store.setName(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("bio")) {
                    store.setBio(item.getString("UTF-8"));
                } else if (item.getFieldName().equals("ownerId")) {
                    store.setBio(item.getString("UTF-8"));
                }
                else if (item.getFieldName().equals("avatar")) {
                    String originalFileName = item.getName();
                    int index = originalFileName.lastIndexOf(".");
                    String ext = originalFileName.substring(index + 1);
                    String fileName = System.currentTimeMillis() + "." + ext;
                    File file = new File(Constant.DIR + "/store/" + fileName);
                    item.write(file);
                    store.setAvatar("store/" + fileName);
                } else if (item.getFieldName().equals("cover")) {
                    String originalFileName = item.getName() + "Cover";
                    int index = originalFileName.lastIndexOf(".");
                    String ext = originalFileName.substring(index + 1);
                    String fileName = System.currentTimeMillis() + "." + ext;
                    File file = new File(Constant.DIR + "/store/" + fileName);
                    item.write(file);
                    store.setCover("store/" + fileName);
                } else if (item.getFieldName().equals("featured_images")) {
                    String originalFileName = item.getName() + "Fearured_images";
                    int index = originalFileName.lastIndexOf(".");
                    String ext = originalFileName.substring(index + 1);
                    String fileName = System.currentTimeMillis() + "." + ext;
                    File file = new File(Constant.DIR + "/store/" + fileName);
                    item.write(file);
                    store.setFeatured_images("store/" + fileName);
                }
                //Date date = new Date();
                Date date = java.sql.Date.valueOf(LocalDate.now());
                store.setCreatedAt(date);
                store.setUpdatedAt(date);
            }
            storeService.insertStore(store);
            response.sendRedirect(request.getContextPath() + "/vendor/home");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
