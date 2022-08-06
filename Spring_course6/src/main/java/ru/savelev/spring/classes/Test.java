package ru.savelev.spring.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.savelev.spring.config.MyConfig;
import ru.savelev.spring.models.Student;
import ru.savelev.spring.models.University;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);
        university.addStudents();
        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        }
        catch (Exception e) {
            System.out.println("Было поймано исключение " + e);
        }

        context.close();
    }
}
