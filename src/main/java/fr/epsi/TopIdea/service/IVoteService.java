package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;

public interface IVoteService {
    void addVote(User user, Idea idea, int vote);
}
