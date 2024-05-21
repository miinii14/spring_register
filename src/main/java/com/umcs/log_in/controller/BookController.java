package com.umcs.log_in.controller;

import com.umcs.log_in.model.Book;
import com.umcs.log_in.service.BookService;
import com.umcs.log_in.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = {"/book"})
public class BookController {
    @Autowired
    private IBookService bookService;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Book book) {
        this.bookService.saveOrUpdate(book);
        return "redirect:/admin/adminpanel";
    }

    @RequestMapping(path = {"/update/{id}"}, method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Optional<Book> bookOpt = this.bookService.getById(id);
        if(bookOpt.isEmpty()) {
            return "redirect:/main";
        }
        model.addAttribute("book", bookOpt.get());
        return "book-form";
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @ModelAttribute Book book) {
        this.bookService.saveOrUpdate(book);
        return "redirect:/admin/adminpanel";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        this.bookService.delete(id);
        return "redirect:/admin/adminpanel";
    }
}
