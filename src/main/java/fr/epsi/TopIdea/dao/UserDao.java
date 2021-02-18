package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserDao implements IUserDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Override
    public List<User> findBrains() {
        List<User> brains = this.entityManager.createQuery("select u from User u order by u.ideas.size desc").getResultList();
        return brains;
    }

    @Override
    public User findOneByName(String name) {
        User user = (User) this.entityManager.createQuery("select u from User u where u.username = :username").setParameter("username", name).getSingleResult();
        return user;
    }
}
