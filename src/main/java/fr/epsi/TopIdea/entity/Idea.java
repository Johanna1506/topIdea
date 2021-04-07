package fr.epsi.TopIdea.entity;


import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Collection;

@Entity
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String title;
    private String description;
    private String image;

    @ManyToOne
    private User author;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "idea")
    private Collection<Vote> votes;

    @OneToMany(mappedBy = "idea")
    private Collection<Comment> comments;

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
