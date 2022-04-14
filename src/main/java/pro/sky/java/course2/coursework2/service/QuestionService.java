package pro.sky.java.course2.coursework2.service;

import pro.sky.java.course2.coursework2.domain.Question;

import java.util.Collection;


public interface QuestionService {

    Question add(String question, String answer);

    Question remove(String question, String answer);

    Collection<Question> getQuestions();

    Question getRandomQuestion();
}
