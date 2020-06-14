package com.justahuman1.mindspace.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

// Question and Answer have a many to many relationship.
// This is in the case that Mindspace
// would like to determine a question to ask
// given an expected answer type from the user.
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Answer value may not be blank")
    @Column(name = "title")
    @Size(min = 1, max = 300)
    private String title;

    @ManyToMany(mappedBy = "question")
    private Set<Question> questions = new HashSet<>();
}
