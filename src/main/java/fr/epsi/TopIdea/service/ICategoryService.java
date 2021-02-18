package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category findByName(String name);
    List<Category> findAll();
}
