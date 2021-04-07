package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.IUserDao;
import fr.epsi.TopIdea.dao.IVoteDao;
import fr.epsi.TopIdea.dao.UserDao;
import fr.epsi.TopIdea.dao.VoteDao;
import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.entity.Vote;
import fr.epsi.TopIdea.entity.voteValue;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class VoteService implements IVoteService {
    @EJB
    IVoteDao voteDao = new VoteDao();

    @Override
    public void addVote(User user, Idea idea, voteValue value) {
        if (idea.getAuthor() != user) {
            Vote vote = new Vote();
            vote.setUser(user);
            vote.setIdea(idea);
            vote.setVote(value);

            this.voteDao.addVote(vote);
        }
    }
}
