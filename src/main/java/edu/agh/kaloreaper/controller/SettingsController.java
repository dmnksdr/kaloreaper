package edu.agh.kaloreaper.controller;

import edu.agh.kaloreaper.model.User;
import edu.agh.kaloreaper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
class SettingsController {

    @Autowired
    private UserRepository users;


    @GetMapping("/settings")
    public String showHistoryMealList(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByName(userName);

        model.addAttribute("user", user);
        return "settings/settings";
    }

    @PostMapping("/settings")
    public String processUpdateProductForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "settings/settings";
        } else {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            int userId = users.findByName(userName).getId();
            user.setId(userId);
            this.users.save(user);
            return "redirect:/settings";
        }
    }


}
