package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PostSvc")
public class PostSvc {
    private List<Post> posts;

    public PostSvc() {
        posts = new ArrayList<>();
        hardcode();
    }

    public List<Post> showAll() {
        return posts;
    }

    public Post showOne(Integer id) {
        return posts.get((id - 1));
    }

    public void save(Post post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
    }

    public void createPost(String title, String body) {
        Post post = new Post(title, body);
        posts.add(post);
    }

    public void update (Post post) {
        posts.set((int)(post.getId()-1), post);
    }

    public List<Post> hardcode() {
        Post post = new Post("a title", "a body", 1L);
        Post post2 = new Post("2 title", "2 body", 2L);
        Post post3 = new Post("3 title", "3 body", 3L);
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        return posts;
    }

}
