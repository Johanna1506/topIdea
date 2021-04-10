package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserDao implements IUserDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    @Override
    public List<User> findBrains() {
        List<User> brains = this.entityManager.createQuery("select u from User u order by size(u.ideas) desc")
                .setMaxResults(3)
                .getResultList();
        return brains;
    }

    @Override
    public User findOneByName(String name) {
        User user = (User) this.entityManager.createQuery("select u from User u where u.username = :username").setParameter("username", name).getSingleResult();
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = this.entityManager.createQuery("select u from User u")
                .getResultList();
        return users;
    }

    @Override
    public User findOne(Long id) {
        User user = (User) this.entityManager.createQuery("select u from User u where u.id = :id").setParameter("id", id).getSingleResult();
        return user;
    }

    @Override
    public void deactivate(User user) {
        user.setActive(false);
        try {
            userTransaction.begin();
            entityManager.merge(user);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void activate(User user) {
        user.setActive(true);
        try {
            userTransaction.begin();
            entityManager.merge(user);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try {
            userTransaction.begin();
            entityManager.remove(user);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
