package controller.servlet;

import model.Tweet;
import service.TweetManagementService;
import service.impl.TweetManagementServiceImpl;
import util.LoginFromSession;
import util.Namespace;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static util.Namespace.FOLLOWED_TWEETS;

@WebServlet(name = "MessageServlet", urlPatterns = "/messages")
public class MessageServlet extends HttpServlet {
    TweetManagementService service;

    @Override
    public void init() throws ServletException {
        service = new TweetManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentUserLogin = LoginFromSession.getUserLoginFromSession(req);
        Set<Tweet> followedTweets = service.getFollowedTweets(currentUserLogin);
        req.setAttribute(FOLLOWED_TWEETS, followedTweets);
        req.getRequestDispatcher("/messages.jsp").forward(req, resp);
    }
}
