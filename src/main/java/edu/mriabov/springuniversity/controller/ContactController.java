package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.ContactInquiry;
import edu.mriabov.springuniversity.service.ContactInquiryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    ContactInquiryService contactInquiryService;

    @Autowired
    public ContactController(ContactInquiryService contactInquiryService) {
        this.contactInquiryService = contactInquiryService;
    }

    @RequestMapping(value = {"/contact"})
    public String displayContactPage(Model model) {
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(ContactInquiry contactInquiry){
        contactInquiryService.saveMessageDetails(contactInquiry);
        return new ModelAndView("redirect:/contact");
    }





}
