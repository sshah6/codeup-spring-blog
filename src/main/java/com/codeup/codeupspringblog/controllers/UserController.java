package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Model.Post;
import com.codeup.codeupspringblog.Model.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @Controller
    public class UserController {
        private UserRepository userDao;
        private PasswordEncoder passwordEncoder;

        public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
            this.userDao = userDao;
            this.passwordEncoder = passwordEncoder;
        }

        @GetMapping("/sign-up")
        public String showSignupForm(Model model){
            model.addAttribute("user", new User());
            return "users/sign-up";
        }

        @PostMapping("/sign-up")
        public String saveUser(@ModelAttribute User user){
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            userDao.save(user);
            return "redirect:/login";
        }
    }


    //==========>Previous user controller below <============
//    private UserRepository usersDao;
//
//    public UserController(UserRepository usersDao) {
//        this.usersDao = usersDao;
//    }
//
//    @GetMapping("/register")
//    public String registerPage(){
//        return "/users/register";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password){
//        User user = new User(username, email, password);
//        usersDao.save(user);
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/user/{id}/posts")
//    public String postByUserId(@PathVariable long id, Model model){
//        User user = usersDao.findById(id).get();
//        System.out.println(id);
//        List<Post> usersPost = user.getUserPosts();
//        model.addAttribute("usersPost", usersPost);
//        System.out.println(usersPost);
//        return "/posts/usersPost";
//    }

