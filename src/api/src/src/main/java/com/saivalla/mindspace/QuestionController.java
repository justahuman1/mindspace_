package com.saivalla.mindspace;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @RequestMapping(method = RequestMethod.GET, path="/questions")
    public String initialize(){
        return "Question Initializer";
    }
}
