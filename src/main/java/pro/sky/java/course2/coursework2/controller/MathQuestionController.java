package pro.sky.java.course2.coursework2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    private final QuestionRepository questionRepository;

    public MathQuestionController(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hello, student!!! ;) Are you ready for math questions?!";
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionRepository.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionRepository.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionRepository.getAll();
    }
}
