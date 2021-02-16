package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.IIdeaDao;
import fr.epsi.TopIdea.dao.IdeaDao;
import fr.epsi.TopIdea.entity.Idea;

import javax.ejb.EJB;
import java.util.List;

public class IdeaService implements IIdeaService {

    @EJB
    IIdeaDao ideaDao = new IdeaDao();

    @Override
    public List<Idea> getTops() {
        return this.ideaDao.findTops();
    }

    @Override
    public List<Idea> getBuzz() {
        return this.ideaDao.findBuzz();
    }
}
