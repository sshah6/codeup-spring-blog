package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Model.Post;
import com.codeup.codeupspringblog.Model.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class UserController {
    private UserRepository usersDao;

    public UserController(UserRepository usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping("/register")
    public String registerPage(){
        return "/users/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password){
        User user = new User(username, email, password);
        usersDao.save(user);
        return "redirect:/posts";
    }

    @GetMapping("/user/{id}/posts")
    public String postByUserId(@PathVariable long id, Model model){
        User user = usersDao.findById(id).get();
        System.out.println(id);
        List<Post> usersPost = user.getUserPosts();
        model.addAttribute("usersPost", usersPost);
        System.out.println(usersPost);
        return "/posts/usersPost";
    }
}
