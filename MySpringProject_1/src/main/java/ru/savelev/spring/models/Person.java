package ru.savelev.spring.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "FIO isn't should be empty")
    @Size(min = 2, max = 100, message = "Maximum values = 100 symbols, minimum = 2")
    private String FIO;
    @NotNull
    @Min(value = 0, message = "Year should be > 0")
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
