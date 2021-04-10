package fr.epsi.TopIdea.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean isActive;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Collection<Role> roles;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private Collection<Idea> ideas;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Collection<Vote> votes;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;

    // business methods
    public boolean isAdmin() {
        for (Role role: roles) {
            if (role.getName().equals("ADMIN")) {
                return true;
            }
        }
        return false;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(Collection<Idea> ideas) {
        this.ideas = ideas;
    }

    public Collection<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Collection<Vote> votes) {
        this.votes = votes;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
