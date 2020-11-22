package com.justahuman1.mindspace;

import com.justahuman1.mindspace.models.Question;
import com.justahuman1.mindspace.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepo repo;

    @RequestMapping(method = RequestMethod.GET, path="/questions")
    public String initialize(){
        return "Question Initializer";
    }

    @RequestMapping(method = RequestMethod.GET, path="/getquestions")
    public List<Question> getQuestions(){
        return repo.findAll();
    }


}
