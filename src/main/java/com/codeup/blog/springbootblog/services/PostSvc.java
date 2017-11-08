package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.Post;
import com.codeup.blog.springbootblog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("PostSvc")
public class PostSvc {
    private final PostsRepository postsDao;

    @Autowired
    public PostSvc(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }

    public Iterable<Post> showAll() {
        return postsDao.findAll();
    }

    public Post showOne(long id) {
        return postsDao.findOne(id);
    }

    public void save(Post post) {
        postsDao.save(post);
    }

    public void createPost(String title, String body) {
        Post post = new Post(title, body);
        postsDao.save(post);
    }

    public void update (Post post) {
        postsDao.save(post);
    }

    public void delete (long id) {
        postsDao.delete(id);
    }

}
