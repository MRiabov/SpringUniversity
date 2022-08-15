package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Person;
import edu.mriabov.springuniversity.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
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
    final Environment environment;


    @RequestMapping("/dashboard")
    public String displayDashboard(Model model,Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if (person.getEazyClass() != null && person.getEazyClass().getName() != null) {
            model.addAttribute("enrolledClass",person.getEazyClass());
        }
        session.setAttribute("loggedInUser", person);
        logMessages();
        return "dashboard.html";
    }
    private void logMessages() {
        log.error("defaultPageSize value with Environment is : "+environment.getProperty("springuniversity.pageSize"));
        log.error("successMsg value with Environment is : "+environment.getProperty("springuniversity.contact.successMsg"));
        log.error("Java Home environment variable using Environment is : "+environment.getProperty("JAVA_HOME"));
    }
}
