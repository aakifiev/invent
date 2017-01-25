package ru.aakifiev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.aakifiev.model.Person;
import ru.aakifiev.service.PersonService;

/**
 * Created by aakifiev on 22.01.2017.
 */

@org.springframework.stereotype.Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){
        if (p.getId() == 0){
            this.personService.addPerson(p);
        } else {
            this.personService.updatePerson(p);
        }
        return "redirect:/persons";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }
}
