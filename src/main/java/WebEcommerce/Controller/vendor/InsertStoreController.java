package WebEcommerce.Controller.vendor;

import java.io.File;
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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import WebEcommerce.Model.CommissionModel;
import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.CommissionService;
import WebEcommerce.Service.StoreService;
import WebEcommerce.Service.Impl.CommissionServiceImpl;
import WebEcommerce.Service.Impl.StoreServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet("/auth/CreateStore")
public class InsertStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreService storeService = new StoreServiceImpl();
	CommissionService commissionService=new CommissionServiceImpl();
	public InsertStoreController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CommissionModel> commissions =commissionService.findAll();
		request.setAttribute("commissions", commissions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/auth/createStore.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserModel u = (UserModel) session.getAttribute("account");
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
				} else if (item.getFieldName().equals("avatar")) {
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
				else if (item.getFieldName().equals("commission")) {
					store.setCommissionId(Integer.parseInt(item.getString("UTF-8")));
				}
				//Date date = new Date();
				Date date = java.sql.Date.valueOf(LocalDate.now());
				store.setCreatedAt(date);
				store.setUpdatedAt(date);
				store.setOwnerId(u.get_id());
			}
			storeService.insertStore(store);
			StoreModel storeNewModel=storeService.getStoreByName(store.getName());
			Constant.idStore=storeNewModel.get_id();
			response.sendRedirect(request.getContextPath() + "/vendor/home");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
