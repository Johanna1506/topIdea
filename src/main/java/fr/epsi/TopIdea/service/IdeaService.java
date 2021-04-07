package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.IIdeaDao;
import fr.epsi.TopIdea.dao.IdeaDao;
import fr.epsi.TopIdea.dto.IdeaDto;
import fr.epsi.TopIdea.entity.Category;
import fr.epsi.TopIdea.entity.Idea;
import fr.epsi.TopIdea.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class IdeaService implements IIdeaService {

    @EJB
    IIdeaDao ideaDao = new IdeaDao();

    @EJB
    private IUserService userService;

    @EJB
    private ICategoryService categoryService;

    @Override
    public List<Idea> getTops() {
        return this.ideaDao.findTops();
    }

    @Override
    public List<Idea> getBuzz() {
        return this.ideaDao.findBuzz();
    }

    @Override
    public void create(IdeaDto ideaDto) {
        Idea idea = new Idea();
        idea.setDate(LocalDate.now().toString());
        idea.setDescription(ideaDto.getDescription());
        idea.setImage(ideaDto.getImage());
        idea.setTitle(ideaDto.getTitle());

        User author = this.userService.findByName(ideaDto.getAuthor());
        idea.setAuthor(author);

        Category category = this.categoryService.findByName(ideaDto.getCategory());
        idea.setCategory(category);

        this.ideaDao.create(idea);
    }

    @Override
    public List<Idea> getAll() {
        return null;
    }
}
