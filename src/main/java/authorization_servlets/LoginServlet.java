package authorization_servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        if (session.getAttribute("usernameCookie") == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            forwardToPage(session, request, response);
        }
    }

    private void forwardToPage(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Cookie usernameCookie = (Cookie) session.getAttribute("usernameCookie");
        Cookie passwordCookie = (Cookie) session.getAttribute("passwordCookie");
        String name = usernameCookie.getValue();
        String pass = passwordCookie.getValue();
        try {
            if (name.equals("user") & pass.equals("user")){
                request.getRequestDispatcher("/user-pages/user-page.jsp").forward(request, response);
            }else if(name.equals("admin") & pass.equals("admin")){
                request.getRequestDispatcher("/pages/admin-page.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
