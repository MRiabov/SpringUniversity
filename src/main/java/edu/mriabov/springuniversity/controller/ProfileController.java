package edu.mriabov.springuniversity.controller;

import edu.mriabov.springuniversity.model.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {

    @RequestMapping(value = "/profile")
    public ModelAndView displayProfile(Model model, Authentication auth){
        Profile profile = new Profile();
        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }

}
