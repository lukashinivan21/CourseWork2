package pro.sky.java.course2.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;

import java.util.Iterator;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService{

    private final QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int a = random.nextInt(mathQuestionRepository.getAll().size());
        Iterator<Question> iter = mathQuestionRepository.getAll().iterator();
        int b = -1;
        Question result = null;
        while (iter.hasNext() && b != a) {
            result = iter.next();
            b++;
        }
        return result;
    }
}
