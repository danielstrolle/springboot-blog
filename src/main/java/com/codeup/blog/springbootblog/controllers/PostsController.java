package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostsController {

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        //3 different posts
        Posts post = new Posts("a title", "a body");
        // IF WE DONT MAKE A CUSTOM CONSTRUCTOR, WE haVE TO USE SETS. BETTER TO MAKE A CUSTOM SO THAT A USER HAS TO PASS THE FIELDS WERE LOOKING FOR IN ORDER TO MAKE THE OBJECT
//        post.setTitle("a title");
//        post.setBody("a body");

        Posts post2 = new Posts("2 title", "2 body");
//        post2.setTitle("2 title");
//        post2.setBody("2 body");

        Posts post3 = new Posts("3 title", "3 body");
//        post3.setTitle("3 title");
//        post3.setBody("3 body");

        // create an array list
        ArrayList<Object> posts = new ArrayList<>();

        // IF WE CREATE THE ARRAY LIST FIRST WE CAN CPASS OBJECTS AS WE CREATE THEM
//        posts.add(new Posts("a title", "a body"));

        // add my post objects to the list
        posts.add(post);
        posts.add(post2);
        posts.add(post3);

        // list of post
        model.addAttribute("posts", posts);

        // pass the list to view
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsID(Integer id, Model model){

        Posts post = new Posts("a title", "a body");
//        post.setTitle("a title");
//        post.setBody("a body");

        model.addAttribute("post", post);

        return "posts/show";
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
