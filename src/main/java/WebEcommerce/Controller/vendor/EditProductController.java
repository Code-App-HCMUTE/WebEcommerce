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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.ProductService;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet("/vendor/product/edit")
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();

	public EditProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductModel product = productService.get(id);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/edit-product.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductModel product = new ProductModel();
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
					product.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					product.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("images")) {
					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);
						product.setListImages(fileName);
					} else {
						int id = Integer.parseInt(request.getParameter("id"));
						ProductModel oldproduct = productService.get(id);
						product.setListImages(oldproduct.getListImages());
					}
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("promotionalprice")) {
					product.setPromotionalPrice(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("quantity")) {
					product.setQuantity(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("id")) {
					product.setId(Integer.parseInt(item.getString("UTF-8")));
				}
				Date date = java.sql.Date.valueOf(LocalDate.now());
				product.setUpdatedAt(date);
			}
			productService.edit(product);
			response.sendRedirect(request.getContextPath() + "/vendor/products");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
