package WebEcommerce.Controller.vendor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
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

import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.UserService;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import WebEcommerce.Service.Impl.UserServiceImpl;

@WebServlet("/vendor/addStaff")
public class AddStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();

	public AddStaffController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/AddStaff.jsp");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel user = new UserModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("firstname")) {
					user.setFistName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("lastname")) {
					user.setLastName(item.getString("UTF-8"));
				}
				else if (item.getFieldName().equals("phone")) {
					user.setPhone(item.getString("UTF-8"));
				}
				else if (item.getFieldName().equals("email")) {
					user.setEmail(item.getString("UTF-8"));
				}
				else if (item.getFieldName().equals("address")) {
					user.setAddress(item.getString("UTF-8"));
				}
				Date date = java.sql.Date.valueOf(LocalDate.now());
				user.setCreatedAt(date);
				user.setUpdatedAt(date);
			}
			service.addStaffInStore(user);
			UserModel usernewModel=service.getStaffbyPhone(user.getPhone());
			StoreService storeService=new StoreServiceImpl();
			storeService.updateStaffStore(usernewModel.get_id());
			response.sendRedirect(request.getContextPath() + "/vendor/staff");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
