package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Idea;

import java.util.List;

public interface IIdeaDao {
    List<Idea> findAll();
    List<Idea> findTops();
    List<Idea> findBuzz();
    void create(Idea idea);
}
