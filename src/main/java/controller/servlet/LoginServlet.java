package controller.servlet;

import controller.error.ValidationError;
import service.UserManagementService;
import service.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Namespace.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    UserManagementService service;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(USER_LOGIN);
        String password = req.getParameter(USER_PASSWORD);

        if(!service.isUserExist(login)) {
            ValidationError error = new ValidationError(USER_NOT_EXIST_ERROR_HEADER, USER_NOT_EXIST_ERROR_MESSAGE);
            req.setAttribute();
        }

    }
}
