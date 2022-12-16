package WebEcommerce.Controller.vendor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Service.Impl.OrderServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import WebEcommerce.Model.OrderDetailModel;
import WebEcommerce.Model.OrderModel;
import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.OrderDetailService;
import WebEcommerce.Service.OrderService;
import WebEcommerce.Service.ProductService;
import WebEcommerce.Service.UserService;
import WebEcommerce.Service.Impl.OrderDetailServiceImpl;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.Impl.UserServiceImpl;

@WebServlet("/vendor/order/detail")
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDetailService orderDetailService=new OrderDetailServiceImpl();
	OrderService orderService=new OrderServiceImpl();
	UserService userService=new UserServiceImpl();
	ProductService productService=new ProductServiceImpl();
    public OrderDetailController() {
        super();
    }
    String orderId;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderId = request.getParameter("id");
		OrderModel order = orderService.getOrderById(Integer.parseInt(orderId));
		System.out.println(order.getId());
		List<OrderDetailModel> orderDetail=orderDetailService.getAllOrderByOrderId(Integer.parseInt(orderId));
		System.out.println(orderDetail.get(0).getProductId());
		List<ProductModel> products=new ArrayList<ProductModel>();
		for(int i=0;i<orderDetail.size();i++)
		{
			products.add(productService.getByStore(orderDetail.get(i).getProductId()));
		}
		System.out.println(products.get(0).getId());
		UserModel user=userService.getUserbyId(order.getUserId());
		System.out.println(user.getFirstName());
		request.setAttribute("user", user);
		request.setAttribute("products", products);
		request.setAttribute("order", order);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/orderdetail.jsp");
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
		OrderModel order = new OrderModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("status")) {
					order.setStatus(item.getString("UTF-8"));
                }
				Date date = java.sql.Date.valueOf(LocalDate.now());
				order.setUpdatedAt(date);
			}
			orderService.UpdateStatus(order.getStatus(),Integer.parseInt(orderId));
			response.sendRedirect(request.getContextPath() + "/vendor/orders");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
