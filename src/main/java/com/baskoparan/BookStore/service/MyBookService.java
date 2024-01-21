package com.baskoparan.BookStore.service;

import com.baskoparan.BookStore.entity.MyBook;

import java.util.List;

public interface MyBookService {

    void saveMyBooks(MyBook book);

    List<MyBook> getAllMyBooks();

    void deleteMyBookById(Long id);
}
