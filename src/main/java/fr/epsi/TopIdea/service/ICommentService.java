package fr.epsi.TopIdea.service;

import fr.epsi.TopIdea.dto.CommentDto;
import fr.epsi.TopIdea.entity.Comment;
import fr.epsi.TopIdea.entity.Idea;

import java.util.List;

public interface ICommentService {
    List<Comment> getComments(Idea idea);
    void addComment(CommentDto comment);
}
