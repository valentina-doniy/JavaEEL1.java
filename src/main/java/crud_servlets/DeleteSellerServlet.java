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

@WebServlet(name = "DeleteSellerServlet")
public class DeleteSellerServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seller> sellers = abstractDB.getSellerList();
        List<Sales> salesList = abstractDB.getSalesList();
        int id = Integer.parseInt(request.getParameter("sellerId"));
        sellers.removeIf(seller -> seller.getSellerId() == id);
        salesList.removeIf(sales -> sales.getSellerId() == id);
        response.sendRedirect("user-pages/admin-page.jsp");
    }
}
