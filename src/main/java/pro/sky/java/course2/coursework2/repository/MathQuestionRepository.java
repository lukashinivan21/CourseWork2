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
public class MathQuestionRepository implements QuestionRepository{

    Set<Question> mathQuestions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question addingQuestion = new Question(question, answer);
        mathQuestions.add(addingQuestion);
        return addingQuestion;
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removingQuestion = new Question(question, answer);
        if (!mathQuestions.remove(removingQuestion)) {
            throw new QuestionNotFoundException("Данный вопрос отсутствует в списке");
        }
        mathQuestions.remove(removingQuestion);
        return removingQuestion;
    }

    @Override
    public Question remove(Question question) {
        if (!mathQuestions.remove(question)) {
            throw new QuestionNotFoundException("Данный вопрос отсутствует в списке");
        }
        mathQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(mathQuestions);
    }

    @Override
    @PostConstruct
    public void init() {
        Question question1 = new Question("Найдите значение выражения: 2+2*2?",
                "Значение выражения равно 6.");
        Question question2 = new Question("Чему равна сумма углов треугольника?",
                "Сумма углов треугольника равна 180 градусам.");
        Question question3 = new Question("Формулировка теоремы Пифагора?",
                "В прямоугольном треугольнике квадрат гипотенузы равен сумме квадратов катетов.");
        Question question4 = new Question("Найдите значение выражения: lg100000000?",
                "Значение выражения равно 8.");
        Question question5 = new Question("Как найти площадь круга?",
                "Площадь круга равна: число пи умножить на радиус круга в квадрате.");
        mathQuestions.add(question1);
        mathQuestions.add(question2);
        mathQuestions.add(question3);
        mathQuestions.add(question4);
        mathQuestions.add(question5);

    }
}
