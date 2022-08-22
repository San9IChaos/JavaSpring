package ru.savelev.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.savelev.spring.entity.Employee;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).
                buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Alexander", "Smirnov", "IT", 600);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            System.out.println(emp);
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}