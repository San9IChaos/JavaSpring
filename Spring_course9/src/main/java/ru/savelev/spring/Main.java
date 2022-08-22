package ru.savelev.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.savelev.spring.entity.Detail;
import ru.savelev.spring.entity.Employee;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class).
                buildSessionFactory();

        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Zaur","Tregulov","IT",500);
//            Detail detail = new Detail("Baku","123456789","zaurtregulov@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//
//
//            System.out.println("Done!");
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg","Smirnov","Sales",700);
//            Detail detail = new Detail("Moscow","987654321","olejka@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class,2);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
