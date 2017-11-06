package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.Posts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PostSvc")
public class PostSvc {
    private List<Posts> posts = new ArrayList<>();

    public PostSvc() {
        hardcode();
    }

    public List<Posts> showAll() {
        return posts;
    }

    public Posts showOne(Long id) {
        return posts.get((int) (id - 1));
    }

    public Posts save(Posts post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }

    public void createPost(String title, String body) {
        Posts post = new Posts(title, body);
        posts.add(post);
    }

    public List<Posts> hardcode() {
        Posts post = new Posts("a title", "a body", 1L);
        Posts post2 = new Posts("2 title", "2 body", 2L);
        Posts post3 = new Posts("3 title", "3 body", 3L);
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        return posts;
    }

}
