package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Courses;
import edu.mriabov.springuniversity.model.EazyClass;
import edu.mriabov.springuniversity.model.Person;
import edu.mriabov.springuniversity.repository.CoursesRepository;
import edu.mriabov.springuniversity.repository.EazyClassRepository;
import edu.mriabov.springuniversity.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
public class AdminController {

    final EazyClassRepository eazyClassRepository;
    final PersonRepository personRepository;
    final CoursesRepository coursesRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model) {
        List<EazyClass> eazyClasses = eazyClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("eazyClasses", eazyClasses);
        modelAndView.addObject("eazyClass", new EazyClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("eazyClass") EazyClass eazyClass) {
        eazyClassRepository.save(eazyClass);
        return new ModelAndView("redirect:/admin/displayClasses");
    }

    @RequestMapping("/deleteClass")
    public ModelAndView deleteById(Model model, @RequestParam int id) {
        Optional<EazyClass> eazyClass = eazyClassRepository.findById(id);
        for (Person person : eazyClass.get().getPersons()) {
            person.setEazyClass(null);
            personRepository.save(person);
        }
        eazyClassRepository.deleteById(id);
        return new ModelAndView("redirect:/admin/displayClasses");
    }

    @GetMapping("/displayStudents")
    public ModelAndView displayStudents(Model model, @RequestParam int classId, HttpSession session, @RequestParam(value = "error", required = false) String error) {
        String errorMessage;
        ModelAndView modelAndView = new ModelAndView("students.html");
        Optional<EazyClass> eazyClass = eazyClassRepository.findById(classId);
        modelAndView.addObject("eazyClass", eazyClass.get());
        modelAndView.addObject("person", new Person());
        session.setAttribute("eazyClass", eazyClass.get());
        if (error != null) {
            errorMessage="Invalid email entered!";
            modelAndView.addObject("errorMessage",errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(Model model, HttpSession httpSession, @ModelAttribute("person") Person person) {
        ModelAndView modelAndView = new ModelAndView();
        EazyClass eazyClass = (EazyClass) httpSession.getAttribute("eazyClass");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if (personEntity == null || !(personEntity.getPersonId() > 0)) {
            modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + eazyClass.getClassId() + "&error=true");
            return modelAndView;
        }
        personEntity.setEazyClass(eazyClass);
        personRepository.save(personEntity);
        eazyClass.getPersons().add(personEntity);
        eazyClassRepository.save(eazyClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + eazyClass.getClassId());
        return modelAndView;
    }

    @GetMapping("/deleteStudent")
    public ModelAndView deleteStudent(Model model,@RequestParam int personId,HttpSession httpSession){
        Optional<Person> person = personRepository.findById(personId);
        EazyClass eazyClass = (EazyClass) httpSession.getAttribute("eazyClass");

        if (person.isPresent()) {
            person.get().setEazyClass(null);
            personRepository.save(person.get());
            eazyClass.getPersons().remove(person.get());
            eazyClassRepository.save(eazyClass);
        } else return new ModelAndView("redirect:/admin/displayStudents?classId="
                + eazyClass.getClassId() + "&error=true");
        httpSession.setAttribute("eazyClass",eazyClass);
        return new ModelAndView("redirect:/admin/displayStudents?classId=" + eazyClass.getClassId());
    }

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model){
        ModelAndView modelAndView = new ModelAndView("courses_secure.html");
        List<Courses> courses = coursesRepository.findAll();
        modelAndView.addObject("courses",courses);
        modelAndView.addObject("course",new Courses());
        return modelAndView;
    }

    @PostMapping("/addNewCourse")
    public ModelAndView addNewCourse(Model model, @ModelAttribute("course") Courses course){
        ModelAndView modelAndView = new ModelAndView();
        coursesRepository.save(course);
        modelAndView.setViewName("redirect:/admin/displayCourses");
        return modelAndView;
    }
}
