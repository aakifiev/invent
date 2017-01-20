package ru.aakifiev.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aakifiev on 20.01.2017.
 */
@org.springframework.stereotype.Controller
public class Controller {
    String message = "Welcome to Spring MVC";

    @RequestMapping("/hello")
    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
        System.out.println("in controller");

        ModelAndView mv = new ModelAndView("helloworld");
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
}
