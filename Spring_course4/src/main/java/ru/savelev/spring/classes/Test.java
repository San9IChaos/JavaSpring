package ru.savelev.spring.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.savelev.spring.models.Book;
import ru.savelev.spring.models.SchoolLibrary;
import ru.savelev.spring.models.UniLibrary;
import ru.savelev.spring.config.MyConfig;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//        Book book = context.getBean("book", Book.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.returnMagazine();
        uniLibrary.addBook();


//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
