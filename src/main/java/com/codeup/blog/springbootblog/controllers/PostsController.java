package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {

    @ResponseBody
    @GetMapping("/posts")
    public String postsIndex() {
        return "posts index page";
    }

    @ResponseBody
    @GetMapping("/posts/{id}")
    public String postsID(Integer id){
        return "view an individual post";
    }

    @ResponseBody
    @GetMapping("/posts/create")
    public String postsCreateForm (){
        return "view the form for creating a post";
    }

    @ResponseBody
    @PostMapping("/posts/create")
    public String postsCreateSubmit () {
        return "create a new post";
    }
}
