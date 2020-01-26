package controller.servlet;

import util.LoginFromSession;
import util.Namespace;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Namespace.USER_LOGIN;
import static util.Namespace.USER_PASSWORD;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        String login = LoginFromSession.getUserLoginFromSession(req);
        if(login == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        for(Cookie c : req.getCookies()) {
            if(c.getName().equals(USER_LOGIN) || c.getName().equals(USER_PASSWORD)) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }
        req.logout();
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
