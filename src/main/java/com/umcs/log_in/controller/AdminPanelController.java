package com.umcs.log_in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @GetMapping("admin/adminpanel")
    public String adminPanel() {
        return "adminpanel";
    }
}
