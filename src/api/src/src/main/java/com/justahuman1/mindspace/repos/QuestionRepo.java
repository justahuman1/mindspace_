package com.justahuman1.mindspace.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.justahuman1.mindspace.models.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
