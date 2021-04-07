package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;
import fr.epsi.TopIdea.entity.voteValue;

public interface IVoteService {
    void addVote(User user, Idea idea, voteValue vote);
}
