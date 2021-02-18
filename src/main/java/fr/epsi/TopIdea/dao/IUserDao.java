package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> findBrains();
    User findOneByName(String name);
}
