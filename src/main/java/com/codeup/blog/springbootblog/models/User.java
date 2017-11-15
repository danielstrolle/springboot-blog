package com.codeup.blog.springbootblog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3, message = "Username must be AT LEAST 3 characters long!")
    private String username;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email cannot be empty!")
    @Email
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    @NotBlank(message = "Email cannot be empty!")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List<Post> posts;

    public User () {}

    public User(User copy) {
        id = copy.id;
        username = copy.username;
        email = copy.email;
        password = copy.password;
    }

    public User (String username, String email, String password) {
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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


}
