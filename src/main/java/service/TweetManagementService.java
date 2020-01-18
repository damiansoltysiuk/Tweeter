package service;

import model.Tweet;

import java.util.Set;

public interface TweetManagementService {
    void addTweet(String userLogin, String message);

    void updateTweet(Long tweetID, String message);

    void deleteTweet(Long tweetID);

    Set<Tweet> getFollowedTweets(String userLogin);
}
