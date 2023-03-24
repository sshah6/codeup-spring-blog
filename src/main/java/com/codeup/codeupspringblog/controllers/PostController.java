package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//        return "<h1><form method=\"POST\">" +
//                "<label for=\"title\">Title:</label><br>" +
//                "<input type=\"text\" id=\"title\" name=\"title\"><br>" +
//                "<label for=\"content\">Content:</label><br>" +
//                "<textarea id=\"content\" name=\"content\"></textarea><br><br>" +
//                "<button type=\"submit\">Create post</button>" +
//                "</form> </h1>";
        return "<h1> <form method=\"POST\">" +
                "<label for=\"num1\">Number 1:</label>" +
                "<input type=\"number\" id=\"num1\" name=\"num1\"><br>" +
                "<label for=\"num2\">Number 2:</label>" +
                "<input type=\"number\" id=\"num2\" name=\"num2\"><br>" +
                "<button type=\"submit\"><h1>Submit</h1></button>" +
                "</form> <h1>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreate(@RequestParam int num1, @RequestParam int num2){
//        return " <h1> post created with title \"" + title + "\" and content of \"" + content + "\"</h1>";
        int sum = num1 + num2;
        return "<h1> The sum of " + num1 + " and " + num2 + " is " + sum + "</h1>";
    }
}
