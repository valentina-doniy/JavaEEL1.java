package authorization_servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthorizationServlet extends HttpServlet {

    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        if (name.equals("user") & pass.equals("user")){
            insertIntoSession(name, pass, request, response, "/user-pages/user-page.jsp");
        }else if(name.equals("admin") & pass.equals("admin")){
            insertIntoSession(name, pass, request, response, "/user-pages/admin-page.jsp");
        }
    }

    private void insertIntoSession(String name, String pass, HttpServletRequest request, HttpServletResponse response, String URL) throws ServletException, IOException {
        Cookie usernameCookie = new Cookie("usernameCookie", name);
        Cookie passwordCookie = new Cookie("passwordCookie", pass);
        session = request.getSession();
        session.setAttribute("usernameCookie", usernameCookie);
        session.setAttribute("passwordCookie", passwordCookie);
        request.getRequestDispatcher(URL).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
