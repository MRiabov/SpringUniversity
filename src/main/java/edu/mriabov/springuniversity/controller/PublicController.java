package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("public")
public class PublicController {
//    @Autowired
//    PersonService personService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String displayRegister(Model model){
        model.addAttribute("person", new Person());
        return "register.html";
    }
    @RequestMapping(value="/createUser",method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors){
        if (errors.hasErrors()){
            return "register.html";
        }
        return "redirect:/login?register=true";
    }

}