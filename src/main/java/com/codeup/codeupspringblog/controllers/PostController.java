package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String getPosts(){
        return "Home for posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPostId(@PathVariable long id){
        return "post with the id of: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getPostsCreate(){
        return "<h1><form method=\"POST\">" +
                "<label for=\"title\">Title:</label><br>" +
                "<input type=\"text\" id=\"title\" name=\"title\"><br>" +
                "<label for=\"content\">Content:</label><br>" +
                "<textarea id=\"content\" name=\"content\"></textarea><br><br>" +
                "<button type=\"submit\">Create post</button>" +
                "</form> </h1>";
//        return "<h1> <form method=\"POST\">" +
//                "<label for=\"num1\">Number 1:</label>" +
//                "<input type=\"number\" id=\"num1\" name=\"num1\"><br>" +
//                "<label for=\"num2\">Number 2:</label>" +
//                "<input type=\"number\" id=\"num2\" name=\"num2\"><br>" +
//                "<button type=\"submit\"><h1>Submit</h1></button>" +
//                "</form> <h1>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreate(@RequestParam String title, @RequestParam String content, Model model){
        return " <h1> post created with title \"" + title + "\" and content of \"" + content + "\"</h1>";
//        int sum = num1 + num2;
//        return "<h1> The sum of " + num1 + " and " + num2 + " is " + sum + "</h1>";

    }

    @GetMapping("/posts/show")
    public String showPost(Model model){
        List<Post> onePost = new ArrayList<>(List.of(
                new Post(1, "About PC", "Everyone user a pc these days")
        ));

        model.addAttribute("onePost", onePost);
        return "posts/show";
    }

    @GetMapping("/posts/index/{n}")
    public String showPosts(Model model, @PathVariable int n){
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post(1,"About PC", "Everyone user a pc these days"),
                new Post(2, "About bikes", "Biking keeps you healthy"),
                new Post(3, "number 3", "What a beautiful number 3")
        ));
        model.addAttribute("posts", posts);
        return "posts/index";
    }


}
