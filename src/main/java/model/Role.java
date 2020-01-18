//package model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = "role_ID")})
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_ID", nullable = false, unique = true)
//    private int roleID;
//    @Column(name = "role", nullable = false, unique = true)
//    private String role;
//    @OneToMany(mappedBy = "roles")
//    private Set<User> users;
//
//    public Role() {
//    }
//
//    public Role(String role) {
//        this.role = role;
//    }
//
//    public int getRoleID() {
//        return roleID;
//    }
//
//    public void setRoleID(int roleID) {
//        this.roleID = roleID;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//}
