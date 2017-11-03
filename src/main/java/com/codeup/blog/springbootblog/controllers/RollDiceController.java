package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String guess() {
         return "diceRollGuess";
    }

    @GetMapping("/roll-dice/{guess}")
    public String userGuess (@PathVariable int guess, Model viewModel){
        if (guess>6 || guess < 1) {
            viewModel.addAttribute("error", "Dice only has 6 sides :p");
        }
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        String match = "";
        if (n == guess) {
            match= "You got it right!";
        } else {
            match="You got it wrong :(";
        }

        viewModel.addAttribute("diceroll", n);
        viewModel.addAttribute("guess", guess);
        viewModel.addAttribute("match", match);

        return "dicerollresults";
    }
}
