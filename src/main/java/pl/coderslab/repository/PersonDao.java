package pl.coderslab.repository;


import org.springframework.stereotype.Repository;
import pl.coderslab.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
    }


}
