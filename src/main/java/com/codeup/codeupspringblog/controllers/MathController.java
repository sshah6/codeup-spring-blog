package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public Integer returnSum(@PathVariable int num1, @PathVariable int num2){
       return  num1 + num2;
    }

    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public Integer returnSubtract(@PathVariable int num1, @PathVariable int num2){
        return  num1 - num2;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public Integer returnTimes(@PathVariable int num1, @PathVariable int num2){
        return  num1 * num2;
    }

    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public Integer returnDivide(@PathVariable int num1, @PathVariable int num2){
        return  num1 / num2;
    }
}
