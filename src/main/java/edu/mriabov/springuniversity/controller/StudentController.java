package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/student")

public class StudentController {

//    final EazyClassRepository eazyClassRepository;
//    final PersonRepository personRepository;
//    final CoursesRepository coursesRepository;

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("courses_enrolled.html");
        Person person = (Person) httpSession.getAttribute("loggedInUser");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
