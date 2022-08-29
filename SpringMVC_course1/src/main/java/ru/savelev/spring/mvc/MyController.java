package ru.savelev.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "myView";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
//        Employee emp = new Employee();
//        emp.setName("Name");
//        emp.setSurname("Surname");
//        emp.setSalary(100);

        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp) {
        String name = emp.getName();
        emp.setName("Mr. " + name);
        String surname = emp.getSurname();
        emp.setSurname(surname + "!");
        int salary = emp.getSalary();
        emp.setSalary(salary*10);


        return "show-emp-details-view";
    }
}
