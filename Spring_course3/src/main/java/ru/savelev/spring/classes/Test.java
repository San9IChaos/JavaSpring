package ru.savelev.spring.classes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.savelev.spring.models.SchoolLibrary;
import ru.savelev.spring.models.UniLibrary;
import ru.savelev.spring.config.MyConfig;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.returnBook();
        uniLibrary.getMagazine();

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();

        context.close();
    }
}
