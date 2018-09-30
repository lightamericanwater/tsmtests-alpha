package by.lightamericanwater.hibernatedemo.controller;

import by.lightamericanwater.hibernatedemo.model.Person;
import by.lightamericanwater.hibernatedemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", personService.listPerson());
        return "/person";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person) {
        if (person.getId() == 0) {
            personService.addPerson(person);
        } else {
            personService.updatePerson(person);
        }
        return "redirect:/persons";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removePerson(@PathVariable("id") int id) {
        personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.getPersonId(id));
        model.addAttribute("listPersons", personService.listPerson());
        return "/person";
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}