package WebEcommerce.Controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebEcommerce.Model.UserModel;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WaitingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println((UserModel)session.getAttribute("account"));
		if (session != null && session.getAttribute("account") != null) {
			UserModel u = (UserModel) session.getAttribute("account");
			System.out.println(u.getRole());
			if(u.getRole().equals("user"))
			{
				response.sendRedirect(request.getContextPath() + "/home");
			}
			else if(u.getRole().equals("admin"))
			{
				response.sendRedirect(request.getContextPath() + "/admin/home");
			}
			/*request.setAttribute("user", u);
			request.getRequestDispatcher("/common/vendor/header.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/vendor/home");*/
		} else {
			response.sendRedirect(request.getContextPath() + "/auth/login");
		}
	}
}
