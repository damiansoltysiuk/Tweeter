package service.impl;

import dao.TweetDAO;
import dao.UserDAO;
import dao.impl.TweetDAOImpl;
import dao.impl.UserDAOImpl;
import model.Tweet;
import model.User;
import service.TweetManagementService;

import java.util.HashSet;
import java.util.Set;

public class TweetManagementServiceImpl implements TweetManagementService {
    private UserDAO userDAO = new UserDAOImpl();
    private TweetDAO tweetDAO = new TweetDAOImpl();

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
        Set<Tweet> followedTweets = new HashSet<>();
        Set<User> follows = userDAO.getFollows(userLogin);
        followedTweets.addAll(tweetDAO.getUserTweets(userLogin));
        follows.stream().forEach(p -> followedTweets.addAll(tweetDAO.getUserTweets(p.getLogin())));
        return followedTweets;
    }
}
