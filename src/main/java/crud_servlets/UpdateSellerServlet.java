package crud_servlets;

import essence.AbstractDB;
import essence.Product;
import essence.Seller;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateSellerServlet")
public class UpdateSellerServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("sellerName");
        updateSeller(id, name);
        response.sendRedirect("user-pages/admin-page.jsp");
    }

    private void updateSeller(int id, String name) {
        abstractDB.getSellerList().set(id-1, new Seller(id, name));
    }
}
