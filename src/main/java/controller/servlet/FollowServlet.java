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

import static util.Namespace.USER_LOGIN_TO_FOLLOW;

@WebServlet(name = "FollowServlet", value = "/follow")
public class FollowServlet extends HttpServlet {
    private UserManagementService userManagementService;
    @Override
    public void init() throws ServletException {
        userManagementService = new UserManagementServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentUserLogin = LoginFromSession.getUserLoginFromSession(req);
        String userLoginToFollow = req.getParameter(USER_LOGIN_TO_FOLLOW);
        userManagementService.follow(currentUserLogin, userLoginToFollow);
        req.getRequestDispatcher("users").forward(req, resp);
    }
}
