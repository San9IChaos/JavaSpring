package ru.savelev.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.savelev.spring.entity.Department;
import ru.savelev.spring.entity.Employee;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class).
                buildSessionFactory();

        Session session = null;
        try {
//            session = factory.getCurrentSession();
//            Department dep = new Department("Sales",800,1500);
//            Employee emp1 = new Employee("Zaur","Tregulov",800);
//            Employee emp2 = new Employee("Elena","Smirnova",1500);
//            Employee emp3 = new Employee("Anton","Sidorov",1200);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class,5);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Подгрузим наших работников");
            department.getEmps().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
