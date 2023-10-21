package com.example.springbootstarterwebex10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name ="BOOKS")
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "bookTitle")
    private String title;
    @Column(name = "authorName")
    private String author;
    private String ISBN;
    private Integer pagesNum;
}
