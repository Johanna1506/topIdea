package fr.epsi.TopIdea.dao;
import fr.epsi.TopIdea.entity.Comment;
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
public class CommentDao implements ICommentDao {
    @PersistenceContext(unitName = "TopIdeaPU")
    EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    @Override
    public void create(Comment comment) {
        System.out.println(comment.getAuthor().getId());
        System.out.println(comment.getIdea().getId());
        System.out.println(comment.getText());

        try {
            userTransaction.begin();
            entityManager.persist(comment);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> findAllCommentsFor(Idea idea) {
        List<Comment> comments = this.entityManager.createQuery("select c from Comment c where c.idea = :idea order by c.id desc")
                .setParameter("idea", idea)
                .getResultList();
        return comments;
    }
}
