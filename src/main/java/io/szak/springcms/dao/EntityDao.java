package io.szak.springcms.dao;

import io.szak.springcms.entity.EntityInterface;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class EntityDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveEntity(EntityInterface entity) {
        entityManager.persist(entity);
    }

    public void updateEntity(EntityInterface entity) {
        entityManager.merge(entity);
    }

    // DO SKONCZENIA
//    public EntityInterface loadById(Long id) {
//        EntityInterface loaded = new Author();
//        return loaded;
//    }

    public void deleteEntity(EntityInterface entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

}
