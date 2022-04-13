package pro.sky.java.course2.coursework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.exceptions.AmountIsTooMuchLargeException;
import pro.sky.java.course2.coursework2.repository.JavaQuestionRepository;
import pro.sky.java.course2.coursework2.repository.MathQuestionRepository;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;
import pro.sky.java.course2.coursework2.service.*;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.mock;
import static pro.sky.java.course2.coursework2.Constants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private final QuestionService javaQuestionServiceMock = mock(JavaQuestionService.class);
    private final QuestionService mathQuestionServiceMock = mock(MathQuestionService.class);
    private final QuestionRepository javaQuestionRepositoryMock = mock(JavaQuestionRepository.class);
    private final QuestionRepository mathQuestionRepositoryMock = mock(MathQuestionRepository.class);

    private ExaminerService out;

    private final Collection<Question> actualQuestions1 = new HashSet<>();
    private final Collection<Question> actualQuestions2 = new HashSet<>();
    private final Collection<Question> actualQuestions3 = new HashSet<>();
    private final Collection<Question> actualQuestions4 = new HashSet<>();
    private final Collection<Question> actualQuestions5 = new HashSet<>();
    private int amountQuestions;
    private static final int numberForIncreaseAmountQuestions = 3;
    private static final int zero = 0;

    @BeforeEach
    public void initOut() {
        out = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock,
                javaQuestionRepositoryMock, mathQuestionRepositoryMock);
    }

    @BeforeEach
    public void setUp() {
        actualQuestions1.add(QUESTION1);
        actualQuestions1.add(QUESTION2);
        actualQuestions1.add(QUESTION3);
        actualQuestions1.add(QUESTION8);
        actualQuestions1.add(QUESTION9);
        actualQuestions2.add(QUESTION4);
        actualQuestions2.add(QUESTION5);
        actualQuestions2.add(QUESTION6);
        actualQuestions2.add(QUESTION7);
        //actualQuestions3.add(QUESTION1);
        actualQuestions3.add(QUESTION3);
        //actualQuestions3.add(QUESTION5);
        actualQuestions4.add(QUESTION5);
        actualQuestions5.add(QUESTION3);
        actualQuestions5.add(QUESTION5);
        Assertions.assertNotNull(javaQuestionServiceMock);
        Assertions.assertNotNull(mathQuestionServiceMock);
        Assertions.assertNotNull(javaQuestionRepositoryMock);
        Assertions.assertNotNull(mathQuestionRepositoryMock);
        amountQuestions = actualQuestions1.size() + actualQuestions2.size() + numberForIncreaseAmountQuestions;
    }

    @Test
    public void getQuestions() {
        Mockito.when(javaQuestionRepositoryMock.getAll()).thenReturn(actualQuestions3);
        Mockito.when(mathQuestionRepositoryMock.getAll()).thenReturn(actualQuestions4);
        Mockito.when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(QUESTION3);
        Mockito.when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(QUESTION5);
        Collection<Question> expected = out.getQuestions(2);
        Assertions.assertEquals(expected, actualQuestions5);
    }

    @Test
    public void getQuestionsThrowException() {
        Mockito.when(javaQuestionRepositoryMock.getAll()).thenReturn(actualQuestions1);
        Mockito.when(mathQuestionRepositoryMock.getAll()).thenReturn(actualQuestions2);
        Assertions.assertThrows(AmountIsTooMuchLargeException.class, () -> out.getQuestions(amountQuestions));
    }

    @Test
    public void getQuestionsThrowException1() {
        Mockito.when(javaQuestionRepositoryMock.getAll()).thenReturn(actualQuestions1);
        Mockito.when(mathQuestionRepositoryMock.getAll()).thenReturn(actualQuestions2);
        Assertions.assertThrows(AmountIsTooMuchLargeException.class, () -> out.getQuestions(zero));
    }
}
