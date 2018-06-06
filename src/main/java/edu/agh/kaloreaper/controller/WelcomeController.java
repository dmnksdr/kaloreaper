package edu.agh.kaloreaper.controller;


import edu.agh.kaloreaper.repository.UserRepository;
import edu.agh.kaloreaper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class WelcomeController {

    @Autowired
    UserRepository users;

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

}
