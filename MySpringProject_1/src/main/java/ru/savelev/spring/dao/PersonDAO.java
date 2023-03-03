package ru.savelev.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.savelev.spring.models.Book;
import ru.savelev.spring.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO PERSON(FIO, year) VALUES (?,?)", person.getFIO(), person.getYear());
    }

    public void update(Person updatedPerson, int id) {
        jdbcTemplate.update("UPDATE Person SET FIO=?, year=? WHERE id=?", updatedPerson.getFIO(),
                updatedPerson.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public Optional<Person> getFullFIO(String FIO) {
       return jdbcTemplate.query("SELECT * FROM Person WHERE FIO=?", new Object[]{FIO},
                       new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBookByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
