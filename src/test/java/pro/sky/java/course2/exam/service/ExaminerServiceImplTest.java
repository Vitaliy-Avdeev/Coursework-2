package pro.sky.java.course2.exam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.exam.exception.ThrowingAnExceptionTooManyQuestions;
import pro.sky.java.course2.exam.interfaces.QuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService javaQuestionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        when(javaQuestionService.getType()).thenReturn("JAVA");

        examinerService = new ExaminerServiceImpl(List.of(javaQuestionService));
    }

    @Test
    void getJavaQuestions_ShouldThrowException_WhenAmountTooHigh() {
        when(javaQuestionService.getAll()).thenReturn(List.of());
        assertThrows(ThrowingAnExceptionTooManyQuestions.class, () -> examinerService.getJavaQuestions(23));
    }
}