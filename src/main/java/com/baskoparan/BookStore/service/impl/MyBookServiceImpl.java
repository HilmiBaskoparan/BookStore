package com.baskoparan.BookStore.service.impl;

import com.baskoparan.BookStore.entity.MyBook;
import com.baskoparan.BookStore.repository.MyBookRepository;
import com.baskoparan.BookStore.service.MyBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookServiceImpl implements MyBookService {

    private final MyBookRepository myBookRepository;

    public MyBookServiceImpl(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    @Override
    public void saveMyBooks(MyBook book) {
        myBookRepository.save(book);
    }

    @Override
    public List<MyBook> getAllMyBooks() {
        return myBookRepository.findAll();
    }

    @Override
    public void deleteMyBookById(Long id) {
        myBookRepository.deleteById(id);
    }
}
