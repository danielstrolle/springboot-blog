package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showPage() {
        return "diceRollGuess";
    }

    @GetMapping("/roll-dice/{guess}")
    public String userGuess(@PathVariable int guess, Model viewModel) {
        if (guess > 6 || guess < 1) {
            viewModel.addAttribute("error", "Dice only has 6 sides :p");
        }
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        int n2 = rand.nextInt(6) + 1;
        int n3 = rand.nextInt(6) + 1;

        int counter = 0;
        if (n == guess) {
            counter += 1;
        } else if (n2 == guess) {
            counter += 1;
        } else if (n3 == guess) {
            counter += 1;
        }

        String match;

        if (counter > 0) {
            match = "You got " + counter + " out of 3 right!";
        } else {
            match = "Sorry, you didnt get any right :(";
        }

        viewModel.addAttribute("diceroll1", n);
        viewModel.addAttribute("diceroll2", n2);
        viewModel.addAttribute("diceroll3", n3);
        viewModel.addAttribute("guess", guess);
        viewModel.addAttribute("match", match);

        return "dicerollresults";
    }
}
