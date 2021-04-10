package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Role;

public interface IRoleDao {
    Role findOneByName(String name);
    void create(Role role);
}
