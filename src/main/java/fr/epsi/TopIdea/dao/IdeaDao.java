package fr.epsi.TopIdea.dao;
import fr.epsi.TopIdea.entity.Idea;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeaDao implements IIdeaDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Override
    public List<Idea> findTops() {
        List<Idea> tops = this.entityManager.createQuery("select i, i.votes.size as totalVotes, v.vote from Idea i join i.votes v where v.vote = 'TOP' order by totalVotes desc").getResultList(); // TODO ecrire la bonne requete :)
        return tops;
    }

    @Override
    public List<Idea> findBuzz() {
        List<Idea> buzz = this.entityManager.createQuery("select i from Idea i order by i.votes.size desc").getResultList();
        return buzz;
    }
}
