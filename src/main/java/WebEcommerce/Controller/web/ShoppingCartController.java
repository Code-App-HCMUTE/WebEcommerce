package WebEcommerce.Controller.web;

import WebEcommerce.Model.CartModel;
import WebEcommerce.Model.ProductModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.CartService;
import WebEcommerce.Service.Impl.CartServiceImpl;
import WebEcommerce.Service.Impl.ProductServiceImpl;
import WebEcommerce.Service.ProductService;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ShoppingCartController", urlPatterns = {"/cart"})
public class ShoppingCartController extends HttpServlet {
    /**
     *
     */
    ProductService productService = new ProductServiceImpl();
    CartService cartService = new CartServiceImpl();
    private static final long serialVersionUID = -5138667958464983262L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/shopingCart.jsp");
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
            HttpSession session = request.getSession();
            Object temp = session.getAttribute("user");
            UserModel user = (UserModel) temp;
            if (temp != null) {
                int projectId = Integer.parseInt(request.getParameter("productId"));
                ProductModel product = productService.get(projectId);
                CartModel cart = new CartModel();
                cart.setCount(Integer.parseInt(request.getParameter("quantity")));
                cart.setUserId(user.get_id());
                cart.setStoreId(product.getStoreId());
                cart.setProductId(projectId);
            cartService.addToCart(cart);
                session.setAttribute("cart", cartService.ListItemOfUser(user.get_id()));
//            response.sendRedirect("/WebEcommerce/product/detail?id="+projectId);
                request.setAttribute("success", true);
                request.getRequestDispatcher("/product/detail?id=" + projectId).forward(request, response);
            }
            else {
                request.setAttribute("success", false);
                request.getRequestDispatcher("/product/detail?id=" + request.getParameter("productId")).forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hehe");
    }
}
