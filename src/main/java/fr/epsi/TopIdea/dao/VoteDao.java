package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.entity.Vote;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class VoteDao implements IVoteDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    @Override
    public void addVote(Vote vote) {
        try {
            userTransaction.begin();
            entityManager.persist(vote);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(User user, Idea idea) {
        return (this.entityManager.createQuery("select v from Vote v where v.user = :user and v.idea = :idea")
                .setParameter("user", user)
                .setParameter("idea", idea)
                .getSingleResult() != null);
    }
}
