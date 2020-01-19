package service;

import model.User;

import java.util.Set;

public interface UserManagementService {
    void saveUser(User user);

    void deleteUser(Long userID);

    void follow(String currentUserLogin, String userLoginToFollow);

    void stopFollowing(String login, String userLoginToUnfollow);

    Set<User> getNotFollowedUsers(String login);

    boolean isUserValid(String login, String password);

    boolean isUserExist(String login);

    boolean isEmailExist(String email);
}
