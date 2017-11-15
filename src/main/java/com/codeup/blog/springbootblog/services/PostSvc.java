package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.Post;
import com.codeup.blog.springbootblog.models.User;
import com.codeup.blog.springbootblog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postsDao.save(post);
    }

    public void update (Post post) {
        postsDao.save(post);
    }

    public void delete (long id) {
        postsDao.delete(id);
    }

    public boolean userMatch (User user) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof String) return  false;
        User loggedIn = (User) principal;
        if (user.getUsername().equals(loggedIn.getUsername())) {
            return true;
        } else {
            return false;
        }
    }

}
