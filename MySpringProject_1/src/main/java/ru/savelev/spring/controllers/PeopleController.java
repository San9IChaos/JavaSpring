package ru.savelev.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.savelev.spring.dao.PersonDAO;
import ru.savelev.spring.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        model.addAttribute("books", personDAO.getBookByPersonId(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping
    public String update(@ModelAttribute("person") @Valid Person person, @PathVariable("id") int id
            , BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "people/edit";

        personDAO.update(person, id);
        return "redirect:/people";
    }
        @DeleteMapping
        public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
        }
    }

