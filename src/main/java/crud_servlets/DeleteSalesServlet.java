package crud_servlets;

import essence.AbstractDB;
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

@WebServlet(name = "DeleteSalesServlet")
public class DeleteSalesServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sales> salesList = abstractDB.getSalesList();
        int id = Integer.parseInt(request.getParameter("salesId"));
        salesList.removeIf(sales -> sales.getSalesId() == id);
        response.sendRedirect("user-pages/admin-page.jsp");
    }
}
