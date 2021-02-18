package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryDao implements ICategoryDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Override
    public Category findOneByName(String name) {
        Category cat = (Category) this.entityManager.createQuery("select c from Category c where c.name = :catname").setParameter("catname", name).getSingleResult();
        return cat;
    }

    @Override
    public List<Category> findAll() {
        List<Category> catList = this.entityManager.createQuery("select c from Category c order by c.name asc").getResultList();
        return catList;
    }
}
