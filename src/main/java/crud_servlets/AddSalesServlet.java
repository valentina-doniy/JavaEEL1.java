package crud_servlets;

import essence.AbstractDB;
import essence.Product;
import essence.Sales;
import essence.Seller;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddSalesServlet")
public class AddSalesServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sales> salesList = abstractDB.getSalesList();
        int id = salesList.stream().mapToInt(Sales::getSalesId).max().getAsInt() + 1;
        int productId = Integer.parseInt(request.getParameter("addProductId"));
        int sellerId = Integer.parseInt(request.getParameter("addSellerId"));
        int countOfProducts = Integer.parseInt(request.getParameter("addCountOfProducts"));
        salesList.add(new Sales(id, productId, sellerId, countOfProducts));
        response.sendRedirect("user-pages/admin-page.jsp");
    }
}
