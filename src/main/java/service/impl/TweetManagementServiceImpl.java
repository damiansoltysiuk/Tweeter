package service.impl;

import dao.TweetDAO;
import dao.UserDAO;
import model.Tweet;
import model.User;
import service.TweetManagementService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TweetManagementServiceImpl implements TweetManagementService {
    private UserDAO userDAO;
    private TweetDAO tweetDAO;

    @Override
    public void addTweet(String userLogin, String message) {
        User user = userDAO.getUserByLogin(userLogin);
        tweetDAO.addTweet(user, message);
    }

    @Override
    public void updateTweet(Long tweetID, String message) {
        tweetDAO.updateTweet(tweetID, message);
    }

    @Override
    public void deleteTweet(Long tweetID) {
        tweetDAO.deleteTweet(tweetID);
    }

    @Override
    public Set<Tweet> getFollowedTweets(String userLogin) {
        User user = userDAO.getUserByLogin(userLogin);
        Set<User> follows = user.getFollows();
        Set<Tweet> result = new LinkedHashSet<>();

        for (User u : follows) {
            List<Tweet> userTweets = tweetDAO.getUserTweets(u.getLogin());
            for (Tweet t : userTweets) {
                result.add(t);
            }
        }

        result.addAll(tweetDAO.getUserTweets(userLogin));

        return result;
    }
}
