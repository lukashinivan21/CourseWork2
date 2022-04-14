package pro.sky.java.course2.coursework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.coursework2.domain.Question;
import pro.sky.java.course2.coursework2.exceptions.QuestionNotFoundException;
import pro.sky.java.course2.coursework2.repository.JavaQuestionRepository;
import pro.sky.java.course2.coursework2.repository.QuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static pro.sky.java.course2.coursework2.Constants.*;

public class JavaQuestionRepositoryTest {

    private final QuestionRepository out = new JavaQuestionRepository();

    private final Set<Question> actualQuestions = new HashSet<>();

    @BeforeEach
    public void setUp() {
        out.add(QUESTION3);
        out.add(QUESTION6);
        out.add(QUESTION1);
        out.add(QUESTION12, ANSWER2);
        actualQuestions.add(QUESTION1);
        actualQuestions.add(QUESTION2);
        actualQuestions.add(QUESTION3);
        actualQuestions.add(QUESTION6);
    }

    @Test
    public void getAllQuestions() {
        Collection<Question> expected = out.getAll();
        Assertions.assertEquals(expected, actualQuestions);
    }

    @Test
    public void add() {
        Question expected = out.add(QUESTION14, ANSWER4);
        Collection<Question> expectedColl = out.getAll();
        actualQuestions.add(QUESTION4);
        Assertions.assertEquals(expected, QUESTION4);
        Assertions.assertEquals(expectedColl, actualQuestions);
    }

    @Test
    public void addQuestion() {
        Question expected = out.add(QUESTION5);
        Collection<Question> expectedColl = out.getAll();
        actualQuestions.add(QUESTION5);
        Assertions.assertEquals(expected, QUESTION5);
        Assertions.assertEquals(expectedColl, actualQuestions);
    }

    @Test
    public void remove() {
        Question expected = out.remove(QUESTION11, ANSWER1);
        Collection<Question> expectedColl = out.getAll();
        actualQuestions.remove(QUESTION1);
        Assertions.assertEquals(expected, QUESTION1);
        Assertions.assertEquals(expectedColl, actualQuestions);
    }

    @Test
    public void removeQuestion() {
        Question expected = out.remove(QUESTION3);
        Collection<Question> expectedColl = out.getAll();
        actualQuestions.remove(QUESTION3);
        Assertions.assertEquals(expected, QUESTION3);
        Assertions.assertEquals(expectedColl, actualQuestions);
    }

    @Test
    public void removingThrowsException() {
        Assertions.assertThrows(QuestionNotFoundException.class, ()-> out.remove(QUESTION13, ANSWER6));
    }

    @Test
    public void removeThrowsException() {
        Assertions.assertThrows(QuestionNotFoundException.class, ()-> out.remove(QUESTION4));
    }
}
