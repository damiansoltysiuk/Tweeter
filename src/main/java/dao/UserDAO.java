package dao;

import model.User;

import java.util.Set;

public interface UserDAO {
    void saveUser(User user);

    void deleteUser(Long userID);

    User getUserByLogin(String login);

    User getUserByEmail(String email);

    Set<User> getFollows(String login);

    Set<User> getFollowers(String login);

    Set<User> getNotFollowedUsers(String login);
}
