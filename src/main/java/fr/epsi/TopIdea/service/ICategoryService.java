package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.entity.Category;

public interface ICategoryService {
    Category findByName(String name);
}
