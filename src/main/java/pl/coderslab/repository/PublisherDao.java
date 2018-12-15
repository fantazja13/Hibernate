package pl.coderslab.repository;


import org.springframework.stereotype.Component;
import pl.coderslab.domain.Book;
import pl.coderslab.domain.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Publisher findPublisher(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void savePublisher(Publisher entity) {
        entityManager.persist(entity);
    }

    public List<Publisher> returnAllPublishers() {
        Query query = entityManager.createQuery("select p from Publisher p");
        List<Publisher> allPublishers = query.getResultList();
        return allPublishers;
    }
}
