package com.baskoparan.BookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "my_books")
@AllArgsConstructor
@NoArgsConstructor
public class MyBook extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

}
