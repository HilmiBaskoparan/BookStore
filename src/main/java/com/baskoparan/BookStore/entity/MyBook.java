package com.baskoparan.BookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "my_books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBook extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

    public MyBook(Long id, Date createdDate, String name, String author, Double price) {
        super(id, createdDate);
        this.name = name;
        this.author = author;
        this.price = price;
    }
}
