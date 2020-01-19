package dao.impl;

import dao.AbstractDao;
import dao.TweetDAO;
import model.Tweet;
import model.User;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class TweetDAOImpl extends AbstractDao implements TweetDAO {
    @Override
    public void addTweet(User user, String message) {
        Tweet tweet = new Tweet();
        tweet.setAuthor(user);
        tweet.setMessage(message);
        hibernateUtil.save(tweet);
    }

    @Override
    public void updateTweet(Long tweetID, String message) {
        Tweet tweet = getTweet(tweetID);
        tweet.setMessage(message);
        tweet.setPublishedAt(new Date());
        hibernateUtil.save(tweet);
    }

    @Override
    public void deleteTweet(Long tweetID) {
        hibernateUtil.delete(Tweet.class, tweetID);
    }

    @Override
    public List<Tweet> getUserTweets(String userLogin) {
        TypedQuery<Tweet> query = entityManager.createQuery("SELECT t FROM Tweet t WHERE t.author.login = :login", Tweet.class);
        query.setParameter("login", userLogin);
        return query.getResultList();
    }

    private Tweet getTweet(Long tweetID) {
        return entityManager.find(Tweet.class, tweetID);
    }
}
