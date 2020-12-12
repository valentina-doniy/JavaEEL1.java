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

@WebServlet(name = "UpdateSalesServlet")
public class UpdateSalesServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int sellerId = Integer.parseInt(request.getParameter("sellerId"));
        int countOfProducts = Integer.parseInt(request.getParameter("countOfProducts"));
        updateSales(id, productId, sellerId, countOfProducts);
        response.sendRedirect("user-pages/admin-page.jsp");
    }

    private void updateSales(int id, int productId, int sellerId, int countOfProducts) {
        abstractDB.getSalesList().set(id-1, new Sales(id, productId, sellerId, countOfProducts));
    }
}
