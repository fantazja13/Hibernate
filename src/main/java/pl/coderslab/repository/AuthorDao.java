package pl.coderslab.repository;


import org.springframework.stereotype.Component;
import pl.coderslab.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveAuthor(Author entity) {
        entityManager.persist(entity);
    }

    public Author findAuthorById(Long id) {
        return entityManager.find(Author.class, id);
    }
}
