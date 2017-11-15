package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.Post;
import com.codeup.blog.springbootblog.models.User;
import com.codeup.blog.springbootblog.repositories.UsersRepository;
import com.codeup.blog.springbootblog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostsController {
    private final PostSvc postSvc;
    private final UsersRepository userDao;

    @Autowired
    public PostsController(PostSvc postSvc, UsersRepository userDao) {
        this.postSvc = postSvc;
        this.userDao = userDao;
    }

    @GetMapping("/home")
    public String homePage() {
        return "home/home";
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
//        //3 different posts
//        Post post = new Post("a title", "a body");
//        // IF WE DONT MAKE A CUSTOM CONSTRUCTOR, WE haVE TO USE SETS. BETTER TO MAKE A CUSTOM SO THAT A USER HAS TO PASS THE FIELDS WERE LOOKING FOR IN ORDER TO MAKE THE OBJECT
////        post.setTitle("a title");
////        post.setBody("a body");
//
//        Post post2 = new Post("2 title", "2 body");
////        post2.setTitle("2 title");
////        post2.setBody("2 body");
//
//        Post post3 = new Post("3 title", "3 body");
////        post3.setTitle("3 title");
////        post3.setBody("3 body");
//
//        // create an array list
//        ArrayList<Object> posts = new ArrayList<>();
//
//        // IF WE CREATE THE ARRAY LIST FIRST WE CAN CPASS OBJECTS AS WE CREATE THEM
////        posts.add(new Post("a title", "a body"));
//
//        // add my post objects to the list
//        posts.add(post);
//        posts.add(post2);
//        posts.add(post3);
//
//        // list of post
//        model.addAttribute("posts", posts);

        // pass the list to view
//        Iterable<Post> allPosts = postSvc.showAll();
//        model.addAttribute("posts", allPosts);

        model.addAttribute("posts", postSvc.showAll());

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String postsID(@PathVariable int id, Model model) {

//        Post post = new Post("a title", "a body");
////        post.setTitle("a title");
////        post.setBody("a body");

        Post onePost = postSvc.showOne(id);
        User postCreator = onePost.getUser();
        if (postSvc.userMatch(postCreator)) {
            model.addAttribute("editable", true);
        }
        model.addAttribute("post", onePost);

        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitCreateForm(@Valid Post post, Errors notValid, Model model) {
        if (notValid.hasErrors()) {
            model.addAttribute(notValid);
            model.addAttribute(post);
            return "posts/create";
        }
        // NEED TO FIND A WAY TO ASSIGN THE USER TO THE POST BEFORE SAVING IT
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Post editPost = postSvc.showOne(id);
        model.addAttribute("post", editPost);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String submitEditForm(@Valid Post post, Errors notValid, Model model) {
        Post editPost = postSvc.showOne(post.getId());
        User user = editPost.getUser();
        if (!postSvc.userMatch(user)) {
            return "redirect:/posts";
        }
        if (notValid.hasErrors()) {
            model.addAttribute(notValid);
            model.addAttribute(editPost);
            return "/posts/edit";
        }
        post.setUser(user);
        postSvc.update(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        Post editPost = postSvc.showOne(id);
        User user = editPost.getUser();
        if (!postSvc.userMatch(user)) {
            return "redirect:/posts";
        }
        postSvc.delete(id);
        return "redirect:/posts";
    }

    @GetMapping("posts/ajax")
    public String viewPostsWithAjax() {
        return "posts/ajax";
    }

    @GetMapping("/posts.json")
    public @ResponseBody
    Iterable<Post> posts() {
        return postSvc.showAll();
    }
}
