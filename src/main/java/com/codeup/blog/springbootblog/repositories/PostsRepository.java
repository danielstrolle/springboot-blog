package com.codeup.blog.springbootblog.repositories;

import com.codeup.blog.springbootblog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends CrudRepository<Post, Long> {

}
