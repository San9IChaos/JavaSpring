package ru.savelev.spring.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.savelev.spring.config.MyConfig;
import ru.savelev.spring.models.UniLibrary;

public class Test {
    public static void main(String[] args) {
        System.out.println("Method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);

        context.close();
        System.out.println("Method main ends");
    }
}
