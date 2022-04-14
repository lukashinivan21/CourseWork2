package pro.sky.java.course2.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository javaQuestionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return javaQuestionRepository.remove(question, answer);
    }

    @Override
    public Collection<Question> getQuestions() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int a = random.nextInt(javaQuestionRepository.getAll().size());
        Iterator<Question> iter = javaQuestionRepository.getAll().iterator();
        int b = -1;
        Question result = null;
        while (iter.hasNext() && b != a) {
            result = iter.next();
            b++;
        }
        return result;
    }
}
