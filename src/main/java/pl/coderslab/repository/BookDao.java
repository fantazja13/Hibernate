package pl.coderslab.repository;

import org.springframework.stereotype.Component;
import pl.coderslab.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional

public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public void updateBook(Book entity) {
        entityManager.merge(entity);
    }

    public Book findBook(long id) {
        return entityManager.find(Book.class, id);
    }

    public void deleteBook(long id) {
        Book entity = findBook(id);
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }


}
