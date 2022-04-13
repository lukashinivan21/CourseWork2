package pro.sky.java.course2.coursework2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.exceptions.QuestionNotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    Set<Question> javaQuestions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question addingQuestion = new Question(question, answer);
        javaQuestions.add(addingQuestion);
        return addingQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removingQuestion = new Question(question, answer);
        if (!javaQuestions.remove(removingQuestion)) {
            throw new QuestionNotFoundException("Данный вопрос отсутствует в списке");
        }
        javaQuestions.remove(removingQuestion);
        return removingQuestion;
    }

    @Override
    public Question remove(Question question) {
        if (!javaQuestions.remove(question)) {
            throw new QuestionNotFoundException("Данный вопрос отсутствует в списке");
        }
        javaQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(javaQuestions);
    }

    @Override
    @PostConstruct
    public void init() {
        Question question1 = new Question("Что такое переменная?",
                "Переменная - это именованная ячейка памяти, которой может быть присвоено значение.");
        Question question2 = new Question("Какой тип данных хранит в себе переменная типа int?",
                "Переменная типа int хранит в себе данные целочисленного типа.");
        Question question3 = new Question("Назовите три основных принципа ООП?",
                "Инкапсуляция, наследование, полиморфизм.");
        Question question4 = new Question("Что такое метод?",
                "Метод - это блок кода, который выполняет определённую функцию и позволяет использовать себя в нескольких местах.");
        Question question5 = new Question("Назовите основные части памяти в Java?",
                "В Java можно выделить две основные части памяти: Stack и Heap (куча).");
        javaQuestions.add(question1);
        javaQuestions.add(question2);
        javaQuestions.add(question3);
        javaQuestions.add(question4);
        javaQuestions.add(question5);
    }
}
