package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Role;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
public class RoleDao implements IRoleDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    @Override
    public Role findOneByName(String name) {
        Role role = (Role) this.entityManager.createQuery("select r from Role r where r.name = :name").setParameter("name", name).getSingleResult();
        return role;
    }

    @Override
    public void create(Role role) {
        try {
            userTransaction.begin();
            entityManager.persist(role);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
