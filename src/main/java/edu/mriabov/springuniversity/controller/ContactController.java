package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Contact;
import edu.mriabov.springuniversity.service.ContactInquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class ContactController {

    private final ContactInquiryService contactInquiryService;

    @Autowired
    public ContactController(ContactInquiryService contactInquiryService) {
        this.contactInquiryService = contactInquiryService;
    }

    @RequestMapping(value ="/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if (errors.hasErrors()) {
            log.error("Error due to + " + errors);
            return "contact.html";
        }
        contactInquiryService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value="/displayMessages")
    public ModelAndView displayMessages(Model model){
        List<Contact> contactMsgs =contactInquiryService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs", contactMsgs);
        return modelAndView;
    }
    @RequestMapping(value="/closeMsg",method = RequestMethod.GET)
    public String closeMsg(@RequestParam int id){
        contactInquiryService.updateMsgStatus(id);
        return "redirect:/displayMessages";
    }


}
