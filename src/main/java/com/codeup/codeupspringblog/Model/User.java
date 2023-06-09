package com.codeup.codeupspringblog.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(100)", nullable = false, length = 60)
    private String username;
    @Column(columnDefinition = "varchar(100)", nullable = false, length = 60)
    private String email;
    @Column(columnDefinition = "varchar(100)", nullable = false, length = 60)
    private String password;

    //establishes the relationship of one to many below
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Post> userPosts;

    public User(User copy){
        id = copy.id;
        username = copy.username;
        email = copy.email;
        password = copy.password;

    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userPosts=" + userPosts +
                '}';
    }
}
