package crud_servlets;

import essence.AbstractDB;
import essence.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = abstractDB.getProductList();
        int id = productList.stream().mapToInt(Product::getProductId).max().getAsInt() + 1;
        String name = request.getParameter("addProductName");
        int cost = Integer.parseInt(request.getParameter("addProductCost"));
        productList.add(new Product(id, name, cost));
        response.sendRedirect("user-pages/admin-page.jsp");
    }
}
