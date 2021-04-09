package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.IUserDao;
import fr.epsi.TopIdea.dao.UserDao;
import fr.epsi.TopIdea.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
}
