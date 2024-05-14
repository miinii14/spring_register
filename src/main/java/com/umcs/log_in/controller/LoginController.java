package com.umcs.log_in.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @GetMapping({"/login", "/logout"})
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        @RequestParam(value = "registered", required = false) String registered,
                        Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "You have been logged out.");
        }
        if(registered != null) {
            model.addAttribute("registeredMessage", "You have created a new account.");
        }

        return "login";
    }
}
