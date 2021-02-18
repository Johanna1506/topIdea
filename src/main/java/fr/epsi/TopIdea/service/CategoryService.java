package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.CategoryDao;
import fr.epsi.TopIdea.dao.ICategoryDao;
import fr.epsi.TopIdea.entity.Category;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoryService implements ICategoryService {
    @EJB
    ICategoryDao categoryDao = new CategoryDao();

    @Override
    public Category findByName(String name) {
        return this.categoryDao.findOneByName(name);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryDao.findAll();
    }
}
