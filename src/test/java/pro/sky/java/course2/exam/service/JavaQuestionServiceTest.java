package pro.sky.java.course2.exam.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.exam.question.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private List<Question> mockQuestions;

    @BeforeEach
    void setUp() {
        mockQuestions = new ArrayList<>();
    }

    @Test
    void testAddDuplicateQuestion() {
        Question question = new Question("Что такое java?", "Язык программирования");
        javaQuestionService.add(question);
        int sizeBefore = mockQuestions.size();
        javaQuestionService.add(question);

        System.out.println(Arrays.toString(mockQuestions.toArray()));

        assertEquals(sizeBefore, mockQuestions.size());
    }

    @Test
    void testAddQuestionByString() {
        javaQuestionService.add("Что такое ооп?", "Объектно-ориентированное программирование");
        assertFalse(mockQuestions.contains(new Question("Что такое ооп?", "Объектно-ориентированное программирование")));
    }

    @Test
    void testRemoveExistingQuestion() {
        Question question = new Question("Что такое java?", "Язык программирования");
        javaQuestionService.add(question);
        javaQuestionService.remove(question);

        assertFalse(mockQuestions.contains(question));
    }

}



