package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.IVoteDao;
import fr.epsi.TopIdea.dao.VoteDao;
import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.entity.Vote;
import fr.epsi.TopIdea.entity.voteValue;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class VoteService implements IVoteService {
    @EJB
    IVoteDao voteDao = new VoteDao();

    @Override
    public void addVote(User user, Idea idea, voteValue value) {
        if (idea.getAuthor().getId().equals(user.getId())) {
            throw new IllegalArgumentException("Vous ne pouvez pas voter pour votre propre idee.");
        }

        if (idea.getDate().isBefore(LocalDate.now().minusDays(7))) {
            throw new IllegalArgumentException("Vous ne pouvez pas voter pour une idee postee il y a plus de 7 jours.");
        }

        if (voteDao.exists(user, idea)) {
            throw new IllegalArgumentException("Vous ne pouvez pas voter plusieurs fois pour la meme idee.");
        }

        Vote vote = new Vote();
        vote.setUser(user);
        vote.setIdea(idea);
        vote.setVote(value);

        this.voteDao.addVote(vote);
    }

    @Override
    public Float calcTopPercentage(Idea idea) {
        Long tops = this.voteDao.getTopVotes(idea);
        Long total = this.voteDao.getVotesCount(idea);

        if (total == null || total == 0F) {
            return 0F;
        } else {
            float prctg = (float) tops / total;
            return prctg;
        }
    }
}
