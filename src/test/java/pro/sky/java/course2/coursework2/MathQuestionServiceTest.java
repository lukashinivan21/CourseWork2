package pro.sky.java.course2.coursework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.repository.MathQuestionRepository;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;
import pro.sky.java.course2.coursework2.service.MathQuestionService;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.mock;
import static pro.sky.java.course2.coursework2.Constants.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    private final QuestionRepository questionRepositoryMock = mock(MathQuestionRepository.class);

    private QuestionService out;

    private final Collection<Question> actualQuestions = new HashSet<>();

    @BeforeEach
    public void initOut() {
        out = new MathQuestionService(questionRepositoryMock);
    }

    @BeforeEach
    public void setUp() {
        actualQuestions.add(QUESTION2);
        //actualQuestions.add(QUESTION3);
        actualQuestions.add(QUESTION4);
        actualQuestions.add(QUESTION5);
        Assertions.assertNotNull(questionRepositoryMock);
        Mockito.when(questionRepositoryMock.getAll()).thenReturn(actualQuestions);
    }

    @Test
    public void getRandomQuestion() {
        Question expected = out.getRandomQuestion();
        Assertions.assertEquals(expected, QUESTION4);
    }
}
