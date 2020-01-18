import hibernate.util.HibernateUtil;
//import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import util.HibernateUtil;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        User u1 = new User.Builder().login("Danyy").email("danyy@wp.pl").name("Dami").lastName("Solti").password("********").build();
//        User u2= new User.Builder().login("Bobby").email("bobby@wp.pl").name("Bob").lastName("Budowniczy").password("1234qwer").build();
//        User u3= new User.Builder().login("Norbi").email("Norbi@wp.pl").name("Nie").lastName("podam").password("hahaha1").build();
//        List<User> users = Arrays.asList(u1, u2, u3);
//
//        Role r1 = new Role("ADMIN");
//        Role r2 = new Role("ADMIN");

        HibernateUtil instance = HibernateUtil.getInstance();


    }
}
