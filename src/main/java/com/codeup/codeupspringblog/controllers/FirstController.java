package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

    @GetMapping("/hello")
    @ResponseBody
    public String returnHelloWorld(){
        return "<h1> Hello Code-up! </h1>";
    }

    //we can pass variables to query string as follows
    @GetMapping("/hello/{name}/{lname}")
    @ResponseBody
    public String getName(@PathVariable String name, @PathVariable String lname){
        return "<h1> Hello " + name +" " + lname + "</h1>";
    }

    @GetMapping("/upper")
    @ResponseBody
    public String returnUpperCase(@RequestParam(defaultValue = "true") boolean uppercase){
        if(uppercase){
            return "HELLO WORLD!";
        }else{
            return "Hello World!";

        }
    }

//    @PostMapping("")
}
