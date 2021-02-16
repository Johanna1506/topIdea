package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.entity.Idea;

import java.util.List;

public interface IIdeaService {
    List<Idea> getTops();
    List<Idea> getBuzz();
}
