package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String getGuess() {
        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String getGuessN(@PathVariable int n, Model model){
        System.out.println(n);
        Random random = new Random();
        int randomNum = random.nextInt(6) + 1;
        model.addAttribute("random", randomNum);
        //you can compare here too but in this case its compared in html file
//        if(n == randomNum){
//            System.out.println("correct");
//            return "roll-dice";
//        }else{
//            System.out.println("incorrect");
//            return "roll-dice";
//        }
        return "roll-dice";
    }
}
