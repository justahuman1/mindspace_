package com.saivalla.mindspace;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    @RequestMapping(method = RequestMethod.GET, path="/answers")
    public String initialize(){
        return "Answer Initializer";
    }
}
