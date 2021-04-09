package fr.epsi.TopIdea.dao;
import fr.epsi.TopIdea.entity.Idea;

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
public class IdeaDao implements IIdeaDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    @Override
    public List<Idea> findTops() {
        List<Idea> tops = this.entityManager.createQuery("SELECT i, COUNT(v) AS TotalVotes, i.date AS Date, 100*SUM(v.vote)/COUNT(v.vote) AS TopPercentage FROM Idea i LEFT OUTER JOIN Vote v ON v.idea = i GROUP BY i ORDER BY TopPercentage DESC, TotalVotes DESC, Date DESC")
                .getResultList();
        return tops;
    }

    @Override
    public List<Idea> findBuzz() {
        List<Idea> buzz = this.entityManager.createQuery("select i from Idea i order by size(i.votes) desc")
                .setMaxResults(3)
                .getResultList();
        return buzz;
    }

    @Override
    public void create(Idea idea) {
        try {
            userTransaction.begin();
            entityManager.persist(idea);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Idea> findAll() {
        List<Idea> ideas = this.entityManager.createQuery("select i from Idea i order by i.date desc").getResultList();
        return ideas;
    }

    @Override
    public Idea findOne(Long id) {
        Idea idea = (Idea) this.entityManager.createQuery("select i from Idea i where i.id = :id").setParameter("id", id).getSingleResult();
        return idea;
    }
}
