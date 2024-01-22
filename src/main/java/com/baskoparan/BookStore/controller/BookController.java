package com.baskoparan.BookStore.controller;

import com.baskoparan.BookStore.entity.Book;
import com.baskoparan.BookStore.entity.MyBook;
import com.baskoparan.BookStore.service.BookService;
import com.baskoparan.BookStore.service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final MyBookService myBookService;

    public BookController(BookService bookService, MyBookService myBookService) {
        this.bookService = bookService;
        this.myBookService = myBookService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ModelAndView("bookList","book", books);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model)
    {
        List<MyBook> myBooks = myBookService.getAllMyBooks();
        model.addAttribute("book", myBooks);
        return "myBooks";
    }

    @RequestMapping("/mybook/{id}")
    public String getMyList(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        MyBook myBook = new MyBook(book.getId(), book.getCreatedDate(), book.getName(), book.getAuthor(), book.getPrice());
        myBookService.saveMyBooks(myBook);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id,Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")Long id) {
        bookService.deleteBookById(id);
        return "redirect:/available_books";
    }
}
