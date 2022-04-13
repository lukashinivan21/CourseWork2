package pro.sky.java.course2.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.exceptions.AmountIsTooMuchLargeException;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;

import java.util.*;

@Service
@RequestScope
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final QuestionRepository javaQuestionRepository;
    private final QuestionRepository mathQuestionRepository;

    private Set<Question> randomQuestions = new HashSet<>();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService,
                               @Qualifier("javaQuestionRepository") QuestionRepository javaQuestionRepository,
                               @Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        this.javaQuestionRepository = javaQuestionRepository;
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1 || amount > javaQuestionRepository.getAll().size() + mathQuestionRepository.getAll().size()) {
            throw new AmountIsTooMuchLargeException("Введно не корректное количество.");
        }
        Random random = new Random();
        int a = random.nextInt(0, amount + 1);
        int b = javaQuestionRepository.getAll().size();
        int c = mathQuestionRepository.getAll().size();
        if (a < amount - c || a > b) {
            randomQuestions = new HashSet<>(javaQuestionRepository.getAll());
            while (randomQuestions.size() != amount) {
                randomQuestions.add(mathQuestionService.getRandomQuestion());
            }
        }
        while (randomQuestions.size() != a) {
            randomQuestions.add(javaQuestionService.getRandomQuestion());
        }
        while (randomQuestions.size() != amount) {
            randomQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return Collections.unmodifiableSet(randomQuestions);
    }
}
