package fr.epsi.TopIdea.dto;

import fr.epsi.TopIdea.entity.Idea;

public class CommentDto {

    private String author;
    private Long idea;
    private String text;

    // getters & setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIdea() {
        return idea;
    }

    public void setIdea(Long idea) {
        this.idea = idea;
    }
}
