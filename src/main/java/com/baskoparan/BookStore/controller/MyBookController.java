package com.baskoparan.BookStore.controller;

import com.baskoparan.BookStore.service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {

    private final MyBookService myBookService;

    public MyBookController(MyBookService myBookService) {
        this.myBookService = myBookService;
    }

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyBook(@PathVariable("id") Long id) {
        myBookService.deleteMyBookById(id);
        return "redirect:/my_books";
    }
}
