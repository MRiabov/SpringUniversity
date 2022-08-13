package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Contact;
import edu.mriabov.springuniversity.service.ContactInquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @RequestMapping(value="/displayMessages/page/{pageNum}")
    public ModelAndView displayMessages(Model model, @PathVariable(name = "pageNum") int pageNum,
                                        @RequestParam(name = "sortField") String sortField,
                                        @RequestParam(name = "sortDir") String sortDir){
        Page<Contact> msgPage = contactInquiryService.findMsgsWithOpenStatus(pageNum, sortField, sortDir);
        List<Contact> contactMsgs = msgPage.getContent();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        model.addAttribute("currentPage",pageNum);
        model.addAttribute("totalPages", msgPage.getTotalPages());
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("sortField",sortField);
        model.addAttribute("totalMsgs",msgPage.getTotalElements());
        model.addAttribute("reverseSortDir",sortDir.equals("desc")?"asc":"desc");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }
    @GetMapping(value="/closeMsg")
    public String closeMsg(@RequestParam int id){
        contactInquiryService.updateMsgStatus(id);
        return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
    }



}
