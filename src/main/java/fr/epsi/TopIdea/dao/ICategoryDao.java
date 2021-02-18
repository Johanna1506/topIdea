package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Category;

public interface ICategoryDao {
    Category findOneByName(String name);
}
