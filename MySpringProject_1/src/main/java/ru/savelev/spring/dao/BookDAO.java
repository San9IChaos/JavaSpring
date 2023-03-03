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
public class BookDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book where id=?",new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name,author,year) VALUES (?,?,?)", book.getName(), book.getAuthor(),
                book.getYear());
    }

    public void update(Book updatedBook, int id) {
        jdbcTemplate.update("UPDATE Book SET name=? author=? year=? WHERE id=?", updatedBook.getName(),
                updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id where Book.id=?",
               new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id = null WHERE id=?", id);
    }

    public void assign(int id, Person selectPerson) {
        jdbcTemplate.update("UPDATE Book SET person_id = ? WHERE id=?", id, selectPerson.getId());
    }
}
