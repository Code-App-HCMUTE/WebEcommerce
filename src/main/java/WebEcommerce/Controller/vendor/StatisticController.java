package WebEcommerce.Controller.vendor;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Service.Impl.OrderServiceImpl;
import WebEcommerce.Service.TransactionService;

import WebEcommerce.Service.OrderService;
import WebEcommerce.Service.ProductService;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.Impl.TransactionServiceImpl;

@WebServlet("/vendor/statistic")
public class StatisticController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	OrderService orderService=new OrderServiceImpl();
	TransactionService transactionService=new TransactionServiceImpl();
	public StatisticController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Integer> listCount = new ArrayList<Integer>();
		List<String> listDate = new ArrayList<String>();
		List<Integer> listAmount = new ArrayList<Integer>();
		List<Integer> listCountOrder = new ArrayList<Integer>();
		for(int i=0;i<7;i++)
		{
			String dayString = Integer.toString(LocalDate.now().getDayOfMonth() + i - 6 );
			String str="2022-12-"+dayString;
			Date datebefore=java.sql.Date.valueOf(str);
			listCount.add(productService.countProductByDate(datebefore));
			listDate.add(Integer.toString(LocalDate.now().getDayOfMonth() + i - 6));
			listAmount.add(transactionService.doanhthu(datebefore));
			listCountOrder.add(orderService.countOrderByDate(datebefore));
		}
		System.out.println(listDate);
		request.setAttribute("countAllProduct", productService.countAll());
		request.setAttribute("countAllOrder", orderService.countAll());
		request.setAttribute("top1sold", productService.getTop1Sold());
		request.setAttribute("listCount",listCount);
		request.setAttribute("listDate",listDate);
		request.setAttribute("listAmount",listAmount);
		request.setAttribute("listCountOrder",listCountOrder);
		request.setAttribute("maxcount", Collections.max(listCount));
		request.setAttribute("maxTotal", Collections.max(listAmount));
		request.setAttribute("maxOrder", Collections.max(listCountOrder));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/chart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
