package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @ResponseBody
    @GetMapping("/add/{int1}/and/{int2}")
    public Integer add(@PathVariable Integer num1, @PathVariable Integer num2) {
        return (num1 + num2);
    }

    @ResponseBody
    @GetMapping("/subtract/{int1}/from/{int2}")
    public Integer subtract(@PathVariable Integer num1, @PathVariable Integer num2) {
        return (num2 - num1);
    }

    @ResponseBody
    @GetMapping("/multiply/{int1}/and/{int2}")
    public Integer multiply(@PathVariable Integer num1, @PathVariable Integer num2) {
        return (num1 * num2);
    }

    @ResponseBody
    @GetMapping("/divide/{int1}/by/{int2}")
    public Double divide(@PathVariable Integer num1, @PathVariable Integer num2) {
        return (double) (num1 / num2);
    }
}
