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
            Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
