package fr.epsi.TopIdea.dao;

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
}
