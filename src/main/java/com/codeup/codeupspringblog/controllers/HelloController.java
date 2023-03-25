package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

    @GetMapping("/howdy")
    public String returnHello(Model model){
        model.addAttribute("name", "Alex");
        model.addAttribute("favNum", 2);
        return "hello";
    }
}
