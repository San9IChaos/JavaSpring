package ru.savelev.springboot.springboot_course1.dao;



import ru.savelev.springboot.springboot_course1.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

//    public void saveEmployee(Employee employee);
//
//    public Employee getEmployee(int id);
//
//    public void deleteEmployee(int id);
}
