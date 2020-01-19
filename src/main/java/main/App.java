package main;

import model.User;
import service.impl.TweetManagementServiceImpl;
import service.impl.UserManagementServiceImpl;

//import model.Role;
//import util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        UserManagementServiceImpl umsi = new UserManagementServiceImpl();
        TweetManagementServiceImpl tmsi = new TweetManagementServiceImpl();
        User u1 = new User.Builder().login("Danyy").email("danyy@wp.pl").name("Dami").lastName("Solti").password("********").build();
        User u2 = new User.Builder().login("Bobby").email("bobby@wp.pl").name("Bob").lastName("Budowniczy").password("1234qwer").build();
        User u3 = new User.Builder().login("Norbi").email("Norbi@wp.pl").name("Nie").lastName("podam").password("hahaha1").build();

        umsi.saveUser(u1);
        umsi.saveUser(u2);
        umsi.saveUser(u3);

        tmsi.addTweet(u1.getLogin(), "User 1, Tweet 1");
        tmsi.addTweet(u1.getLogin(), "User 1, Tweet 2");
        tmsi.addTweet(u2.getLogin(), "User 2, Tweet 1");
        tmsi.addTweet(u2.getLogin(), "User 2, Tweet 2");
        tmsi.addTweet(u3.getLogin(), "User 3, Tweet 1");

        umsi.deleteUser(3l);
        umsi.follow("Danyy", "Bobby");
        umsi.follow("Danyy", "Norbi");

        umsi.stopFollowing("Danyy", "Bobby");

        System.out.println("UserExist: " + umsi.isUserExist("ndjasas"));
        System.out.println("UserExist: " + umsi.isUserExist("Danyy"));

        System.out.println("Password Valid: " + umsi.isUserValid("Danyy", "********"));
        System.out.println("Password Valid: " + umsi.isUserValid("Danyy", "****X****"));

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmsi.deleteTweet(2l);
        tmsi.updateTweet(3l, "Modify tweet");
        tmsi.getFollowedTweets("Danyy").stream().forEach(e -> System.out.println(e));

//        umsi.saveUser(u1);
//        umsi.saveUser(u2);
//        umsi.saveUser(u3);
//        List<User> users = Arrays.asList(u1, u2, u3);
//
//        Role r1 = new Role("ADMIN");
//        Role r2 = new Role("ADMIN");

//        HibernateUtil instance = HibernateUtil.getInstance();


    }
}
