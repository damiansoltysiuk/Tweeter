package controller.servlet;

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

@WebServlet(urlPatterns = "/deleteTweet")
public class DeleteTweetServlet extends HttpServlet {
    private TweetManagementService service;

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
        String tweetID = req.getParameter(Namespace.TWEET_ID);
        if(tweetID == null || tweetID.isEmpty()) {
            req.getRequestDispatcher("/messages.jsp").forward(req, resp);
            return;
        }
        service.deleteTweet(Long.parseLong(tweetID));
        req.getRequestDispatcher("messages").forward(req, resp);
    }
}
