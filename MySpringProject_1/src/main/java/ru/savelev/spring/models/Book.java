package ru.savelev.spring.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {
    private int id;
    @NotEmpty(message = "Book must have name")
    private String name;
    @NotEmpty(message = "Book must have a author")
    private String author;
    @Min(value = 1500, message = "We don't have books older 1500 year")
    private int year;

    public Book() {
    }

    public Book( String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
