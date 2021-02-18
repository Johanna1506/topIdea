package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.entity.User;

import java.util.List;

public interface IUserService {
    User findByName(String name);
    List<User> getBrains();
}
