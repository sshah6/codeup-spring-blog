package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String getGuess(){
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String getGuess(@RequestParam int guess){
        System.out.println(guess);
        Random random = new Random();
        int randomNum = random.nextInt(6) + 1;
        if(guess == randomNum){
            System.out.println("Correct");
        }else{
            System.out.println("Not correct");
        }
        return "redirect:/";
    }
}
