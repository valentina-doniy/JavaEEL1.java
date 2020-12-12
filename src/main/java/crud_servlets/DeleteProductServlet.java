package crud_servlets;

import essence.AbstractDB;
import essence.Product;
import essence.Sales;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = abstractDB.getProductList();
        List<Sales> salesList = abstractDB.getSalesList();
        int id = Integer.parseInt(request.getParameter("productId"));
        products.removeIf(product -> product.getProductId() == id);
        salesList.removeIf(sales -> sales.getProductId() == id);
        response.sendRedirect("user-pages/admin-page.jsp");
    }
}
