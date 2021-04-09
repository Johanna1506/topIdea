package fr.epsi.TopIdea.dao;

import fr.epsi.TopIdea.entity.Comment;
import fr.epsi.TopIdea.entity.Idea;

import java.util.List;

public interface ICommentDao {
    void create(Comment comment);
    List<Comment> findAllCommentsFor(Idea idea);
}
