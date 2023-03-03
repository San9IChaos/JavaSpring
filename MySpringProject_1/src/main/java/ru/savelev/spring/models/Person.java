package ru.savelev.spring.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Person {
    private int id;
    @NotEmpty
    private String FIO;
    @NotNull
    @Min(value = 0)
    private int year;

    public Person() {}

    public Person( String FIO, int year) {
        this.FIO = FIO;
        this.year = year;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
