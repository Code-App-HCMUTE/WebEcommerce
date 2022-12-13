package WebEcommerce.Controller.vendor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = {"/vendor/infor"})
public class inforStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService storeService=new StoreServiceImpl();
    public inforStoreController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		StoreModel store=storeService.getStoreById(6);
        request.setAttribute("store", store);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/infoStore.jsp");
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
				} else if (item.getFieldName().equals("description")) {
					store.setBio(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("avatar")) {
					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/store/" + fileName);
						item.write(file);
						store.setAvatar(fileName);
					}
					else {
						StoreModel oldStore = storeService.getStoreById(6);
						store.setAvatar(oldStore.getAvatar());
					}
				} 
				else if (item.getFieldName().equals("cover")) {
					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/store/" + fileName);
						item.write(file);
						store.setCover(fileName);
					}
					else {
						StoreModel oldStore = storeService.getStoreById(6);
						store.setCover(oldStore.getCover());
					}
				}
				else if (item.getFieldName().equals("feature")) {
					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/store/" + fileName);
						item.write(file);
						store.setFeatured_images(fileName);
					}
					else {
						StoreModel oldStore = storeService.getStoreById(6);
						store.setFeatured_images(oldStore.getFeatured_images());
					}
				}
			}
			storeService.editStore(store);
			response.sendRedirect(request.getContextPath() + "/vendor/home");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
