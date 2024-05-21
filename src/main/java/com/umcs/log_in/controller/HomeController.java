package com.umcs.log_in.controller;

import com.umcs.log_in.model.Book;
import com.umcs.log_in.service.BookService;
import com.umcs.log_in.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    private IBookService bookService;

    @GetMapping({"/home"})
    public String home() {
        return "home";
    }

    @RequestMapping(path = {"/", "/main", "/index"}, method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("books", this.bookService.getAll());
        return "main";
    }

}
