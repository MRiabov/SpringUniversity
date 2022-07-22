package edu.mriabov.springuniversity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ContactController {
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);
    @RequestMapping(value = {"/contact"})
    public String displayContactPage(Model model) {
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
                                    @RequestParam String email,@RequestParam String subject, @RequestParam String message){
        log.info("Name : "+name);
        log.info("Email : "+email);
        log.info("Mobile number : "+mobileNum);
        log.info("Subject : "+subject);
        log.info("String : " + message);

        return new ModelAndView("redirect:/contact");
    }

}
