package fr.epsi.TopIdea.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Collection<Idea> ideas;

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(Collection<Idea> ideas) {
        this.ideas = ideas;
    }
}
