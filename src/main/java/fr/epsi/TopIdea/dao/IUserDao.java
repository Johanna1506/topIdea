package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> findBrains();
    User findOneByName(String name);
    List<User> getAll();
//    List<User> getAdmins();
//    List<User> getUsers();
    User findOne(Long id);
    void deactivate(User user);
    void activate(User user);
    void delete(User user);
    void create(User user);
}
