package controller.servlet;

import service.UserManagementService;
import service.impl.UserManagementServiceImpl;
import util.LoginFromSession;
import util.Namespace;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Namespace.USER_LOGIN_TO_UNFOLLOW;

@WebServlet(name = "UnfollowServlet", urlPatterns = "/unfollow")
public class UnfollowServlet extends HttpServlet {
    private UserManagementService service;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentUserLogin = LoginFromSession.getUserLoginFromSession(req);
        String userLoginToUnfollow = req.getParameter(USER_LOGIN_TO_UNFOLLOW);
        service.stopFollowing(currentUserLogin, userLoginToUnfollow);
        req.getRequestDispatcher("users").forward(req, resp);
    }
}
