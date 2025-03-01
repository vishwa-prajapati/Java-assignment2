package servlet;

import dao.ProductDAO;
import model.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search") != null ? request.getParameter("search") : "";
        String category = request.getParameter("category") != null ? request.getParameter("category") : "";

        List<Product> productList = ProductDAO.getProducts(search, category);
        request.setAttribute("products", productList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}