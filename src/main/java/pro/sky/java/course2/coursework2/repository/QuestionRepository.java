package pro.sky.java.course2.coursework2.repository;

import pro.sky.java.course2.coursework2.domain.Question;

import java.util.Collection;


public interface QuestionRepository {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    void init();
}
