package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Person;
import edu.mriabov.springuniversity.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class DashboardController {

    final PersonRepository personRepository;

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model, Authentication authentication, HttpSession httpSession) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if (person.getEazyClass() != null && person.getEazyClass().getName() != null) {
            model.addAttribute("enrolledClass",person.getEazyClass());
        }
        httpSession.setAttribute("loggedInUser", person);
        return "dashboard.html";
    }
}
