package crud_servlets;

import essence.AbstractDB;
import essence.Seller;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddSellerServlet")
public class AddSellerServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seller> sellerList = abstractDB.getSellerList();
        int id = sellerList.stream().mapToInt(Seller::getSellerId).max().getAsInt() + 1;
        String name = request.getParameter("addSellerName");
        sellerList.add(new Seller(id, name));
        response.sendRedirect("user-pages/admin-page.jsp");
    }
}
