package edu.agh.kaloreaper.controller;


import edu.agh.kaloreaper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {

    @Autowired
    UserRepository users;

    @GetMapping("/")
    public String logUserIn() {
        if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)
            return "welcome";
        else
            return "redirect:/home";
    }

}
