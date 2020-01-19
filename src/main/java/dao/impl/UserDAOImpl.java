package dao.impl;

import dao.AbstractDao;
import dao.UserDAO;
import model.User;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImpl extends AbstractDao implements UserDAO {
    @Override
    public void saveUser(User user) {
        hibernateUtil.save(user);
    }

    @Override
    public void deleteUser(Long userID) {
        hibernateUtil.delete(User.class, userID);
    }

    @Override
    public User getUserByLogin(String login) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class);
        return query.setParameter("login", login).getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        return query.setParameter("email", email).getSingleResult();
    }

    @Override
    public Set<User> getFollows(String login) {
        return getUserByLogin(login).getFollows();
    }

    @Override
    public Set<User> getFollowers(String login) {
        return getUserByLogin(login).getFollowers();
    }


    @Override
    public Set<User> getNotFollowedUsers(String login) {
        List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.login != :login", User.class).setParameter("login",login).getResultList();
        Set<User> followedUser = getFollowers(login);
        users.removeAll(followedUser);
        users.remove(login);
        return new HashSet<User>(users);
    }
}