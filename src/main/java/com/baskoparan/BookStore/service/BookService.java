package com.baskoparan.BookStore.service;

import com.baskoparan.BookStore.entity.Book;

import java.util.List;

public interface BookService {

    void save(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void deleteBookById(Long id);

}
