package com.saivalla.mindspace.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Question Title may not be blank.")
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
    // TODO: Add getter/setter for QA updates
}
