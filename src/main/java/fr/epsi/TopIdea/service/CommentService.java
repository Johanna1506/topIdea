package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dao.CommentDao;
import fr.epsi.TopIdea.dao.ICommentDao;
import fr.epsi.TopIdea.dao.IVoteDao;
import fr.epsi.TopIdea.dao.VoteDao;
import fr.epsi.TopIdea.dto.CommentDto;
import fr.epsi.TopIdea.entity.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class CommentService implements ICommentService {
    @EJB
    ICommentDao commentDao = new CommentDao();

    @EJB
    IUserService userService;

    @EJB
    IIdeaService ideaService;

    @Override
    public List<Comment> getComments(Idea idea) {
        return this.commentDao.findAllCommentsFor(idea);
    }

    @Override
    public void addComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());

        User author = this.userService.findByName(commentDto.getAuthor());
        comment.setAuthor(author);

        Idea idea = this.ideaService.findOne(commentDto.getIdea());
        comment.setIdea(idea);

        this.commentDao.create(comment);
    }
}
