package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.IRoleDao;
import fr.epsi.TopIdea.dao.IUserDao;
import fr.epsi.TopIdea.dao.RoleDao;
import fr.epsi.TopIdea.dao.UserDao;
import fr.epsi.TopIdea.dto.UserDto;
import fr.epsi.TopIdea.entity.Role;
import fr.epsi.TopIdea.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService implements IUserService {
    @EJB
    IUserDao userDao = new UserDao();

    @Override
    public User findByName(String name) {
        return this.userDao.findOneByName(name);
    }

    @Override
    public List<User> getBrains() {
        return this.userDao.findBrains();
    }

    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }

    @Override
    public User findOne(Long id) {
        return this.userDao.findOne(id);
    }

    @Override
    public void deactivate(User user) {
        this.userDao.deactivate(user);
    }

    @Override
    public void activate(User user) {
        this.userDao.activate(user);
    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    public void register(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setActive(false);

//        try {
//            Role role = this.roleDao.findOneByName("USER");
//        } catch(NoResultException e) {
//            Role role = new Role();
//            role.setName("USER");
//            this.roleDao.create(role);
//        }

//        Role role = this.roleDao.findOneByName("USER");
//        List<Role> roles = new ArrayList<Role>();
//        roles.add(role);
//        user.setRoles(roles);

        this.userDao.create(user);
    }
}
