package com.codeup.blog.springbootblog.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Title cannot be empty!")
    @Size(min = 3, message = "Title must be AT LEAST 3 characters long!")
    private String title;

    @Column
    private String subheading;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "Body cannot be empty!")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    public Post() {}

//    public Post(String title, String body) {
//        this.title = title;
//        this.body = body;
//    }

    public Post(String title, String subheading, String body, Long id, User user) {
        this.title = title;
        this.subheading = subheading;
        this.body = body;
        this.id = id;
        this.user = user;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSubheading() {
        return subheading;
    }
    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
