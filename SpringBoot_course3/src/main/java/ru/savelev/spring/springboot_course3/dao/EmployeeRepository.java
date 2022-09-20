package ru.savelev.spring.springboot_course3.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.savelev.spring.springboot_course3.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByName(String name);
}
