package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dto.IdeaDto;
import fr.epsi.TopIdea.entity.Idea;

import java.util.List;

public interface IIdeaService {
    List<Idea> getAll();
    List<Idea> getTops();
    List<Idea> getBuzz();
    void create(IdeaDto ideaDto);
}
