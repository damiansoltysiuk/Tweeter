package dao;

import model.Tweet;
import model.User;

import java.util.List;

public interface TweetDAO {
    void addTweet(User user, String message);

    void updateTweet(Long tweetID, String message);

    void deleteTweet(Long tweetID);

    List<Tweet> getUserTweets(String userLogin);
}
