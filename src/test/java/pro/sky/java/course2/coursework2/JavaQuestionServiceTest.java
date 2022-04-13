package pro.sky.java.course2.coursework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.repository.JavaQuestionRepository;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;
import pro.sky.java.course2.coursework2.service.JavaQuestionService;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.mock;
import static pro.sky.java.course2.coursework2.Constants.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private final QuestionRepository questionRepositoryMock = mock(JavaQuestionRepository.class);

    private QuestionService out;

    private final Collection<Question> actualQuestions = new HashSet<>();

    @BeforeEach
    public void initOut() {
        out = new JavaQuestionService(questionRepositoryMock);
    }

    @BeforeEach
    public void setUp() {
        actualQuestions.add(QUESTION1);
        actualQuestions.add(QUESTION2);
        //actualQuestions.add(QUESTION3);
        Assertions.assertNotNull(questionRepositoryMock);
        Mockito.when(questionRepositoryMock.getAll()).thenReturn(actualQuestions);
    }

    @Test
    public void getRandomQuestion() {
        Question expected = out.getRandomQuestion();
        Assertions.assertEquals(expected, QUESTION1);
    }
}
