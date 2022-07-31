package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.ContactInquiry;
import edu.mriabov.springuniversity.service.ContactInquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class ContactController {

    ContactInquiryService contactInquiryService;

    @Autowired
    public ContactController(ContactInquiryService contactInquiryService) {
        this.contactInquiryService = contactInquiryService;
    }

    @RequestMapping(value ="/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact",new ContactInquiry());
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") ContactInquiry contact, Errors errors){
        if (errors.hasErrors()) {
            log.error("Error due to + " + errors);
            return "contact.html";
        }
        contactInquiryService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value="/displayMessages")
    public ModelAndView displayMessages(Model model){
        List<ContactInquiry> Inquiries=contactInquiryService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",Inquiries);
        return modelAndView;
    }
    @RequestMapping(value="/closeMsg")
    public String closeMessage(@RequestParam int id, Authentication authentication){
        contactInquiryService.updateMsgStatus(id,authentication.getName());
        return "redirect:/displayMessages";
    }


}
