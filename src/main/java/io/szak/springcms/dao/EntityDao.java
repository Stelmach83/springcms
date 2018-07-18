package io.szak.springcms.dao;

import io.szak.springcms.entity.Article;
import io.szak.springcms.entity.Category;
import io.szak.springcms.entity.EntityInterface;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public Article loadArticleById(Long id) {
        Article loaded = entityManager.find(Article.class, id);
        return loaded;
    }

    public void deleteEntity(EntityInterface entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Article> loadAllArticles() {
        Query query = entityManager.createQuery("SELECT art FROM Article art");
        List<Article> articleList = query.getResultList();
        return articleList;
    }

    public List<Article> loadSomeArticles(int limit) {
        Query query = entityManager.createQuery("SELECT art FROM Article art ORDER BY art.created desc");
        List<Article> articleList = query.setMaxResults(limit).getResultList();
        return articleList;
    }

    public List<Category> loadAllCategories() {
        Query query = entityManager.createQuery("SELECT cat FROM Category cat");
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }

    public Category loadCategoryByName(String name) {
        Query query = entityManager.createQuery("SELECT cat FROM Category cat WHERE cat.name = :name");
        query.setParameter("name", name);
        Category category = (Category) query.getSingleResult();
        return category;
    }

}
