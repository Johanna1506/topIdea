package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CategoryDao implements ICategoryDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Override
    public Category findOneByName(String name) {
        Category cat = (Category) this.entityManager.createQuery("select c from Category c where c.name = :catname").setParameter("catname", name).getSingleResult();
        return cat;
    }
}
