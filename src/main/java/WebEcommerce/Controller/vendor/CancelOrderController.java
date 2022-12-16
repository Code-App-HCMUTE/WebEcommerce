package WebEcommerce.Controller.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebEcommerce.Model.OrderModel;
import WebEcommerce.Service.Impl.OrderServiceImpl;
import WebEcommerce.Service.OrderService;

@WebServlet("/vendor/cacelorder")
public class CancelOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService orderService=new OrderServiceImpl();
    public CancelOrderController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderModel> ordersList=orderService.getAllOrderCancel();
		request.setAttribute("orders", ordersList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/order.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
