package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.entity.Vote;

import java.util.List;

public interface IVoteDao {
    void addVote(Vote vote);
    boolean exists(User user, Idea idea);
    Long getVotesCount(Idea idea);
    Long getTopVotes(Idea idea);
}
