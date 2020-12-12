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

@WebServlet(name = "UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    @Inject
    AbstractDB abstractDB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        updateProducts(id, name, price);
        response.sendRedirect("user-pages/admin-page.jsp");
    }

    private void updateProducts(int id, String name, int price) {
        abstractDB.getProductList().set(id-1, new Product(id, name, price));
    }

}
