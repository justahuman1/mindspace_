package com.justahuman1.mindspace.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: Add getter/setter for QA updates

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Question Title may not be blank.")
    @Column(name = "title")
    @Size(min = 1, max = 300)
    private String title;

    @OneToMany(
        cascade = CascadeType.ALL,  // Cascade delete all categories if orphan
        orphanRemoval = true
    )
    private List<QCategory> categories = new ArrayList<>();

    public void setCategories(QCategory category){
        categories.add(category);
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "QuestionAnswer",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    Set<Answer> projects = new HashSet<>();
}
