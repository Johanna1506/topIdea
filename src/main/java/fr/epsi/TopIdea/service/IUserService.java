package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dto.UserDto;
import fr.epsi.TopIdea.entity.User;

import java.util.List;

public interface IUserService {
    User findByName(String name);
    List<User> getBrains();
    List<User> getAll();
    List<List<User>> sortUsersByRole();
    User findOne(Long id);
    void deactivate(User user);
    void activate(User user);
    void delete(User user);
    void register(UserDto userDto);
}
