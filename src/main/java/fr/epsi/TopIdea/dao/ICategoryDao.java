package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Category;

import java.util.List;

public interface ICategoryDao {
    Category findOneByName(String name);
    List<Category> findAll();
}
