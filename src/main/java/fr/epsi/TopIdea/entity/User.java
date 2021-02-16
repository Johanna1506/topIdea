package fr.epsi.TopIdea.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String mail;
    private String password;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    private Collection<Vote> votes;

    @OneToMany(mappedBy = "author")
    private Collection<Idea> ideas;

    @OneToMany(mappedBy = "author")
    private Collection<Comment> comments;

    // business methods
    public void submit() {
        // submit a new idea -> IdeaDTO
    }

    public void vote() {
        // vote (like or dislike) for an Idea
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Collection<Vote> votes) {
        this.votes = votes;
    }

    public Collection<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(Collection<Idea> ideas) {
        this.ideas = ideas;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
