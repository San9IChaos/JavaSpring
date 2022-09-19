package ru.savelev.spring.springboot_course2.service;



import org.springframework.beans.factory.annotation.Autowired;
import ru.savelev.spring.springboot_course2.dao.EmployeeRepository;
import ru.savelev.spring.springboot_course2.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> findAllByName(String name);
}
