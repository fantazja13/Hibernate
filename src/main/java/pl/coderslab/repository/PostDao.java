package pl.coderslab.repository;


import org.springframework.stereotype.Component;
import pl.coderslab.domain.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PostDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePost(Post post) {
        entityManager.persist(post);
    }

}
