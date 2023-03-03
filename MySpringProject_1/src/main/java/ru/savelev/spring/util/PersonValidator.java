package ru.savelev.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.savelev.spring.dao.PersonDAO;
import ru.savelev.spring.models.Person;

public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
    Person person = (Person) target;

        if (personDAO.getFullFIO(person.getFIO()).isPresent())
            errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");

    }
}