package pro.sky.java.course2.exam.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.exam.exception.ThrowingAnExceptionTooManyQuestions;
import pro.sky.java.course2.exam.interfaces.ExaminerService;
import pro.sky.java.course2.exam.interfaces.QuestionService;
import pro.sky.java.course2.exam.question.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;
    private final int javaServiceId;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
        if (questionServices.getFirst().getType().equals("JAVA")) {
            javaServiceId = 0;
        } else {
            javaServiceId = 1;
        }
    }

    @Override
    public Collection<Question> getJavaQuestions(int amount) {
        List<Question> questions = new ArrayList<>();
        if (questionServices.get(javaServiceId).getAll().size() < amount) {
            throw new ThrowingAnExceptionTooManyQuestions("Запрошено больше вопросов, чем есть в сервисе");
        }
        for (int i = 0; i < amount; ) {
            Question question = questionServices.get(javaServiceId).getRandomQuestion();
            if (!questions.contains(question)) {
                questions.add(question);
                i++;
            }
        }
        return questions;

    }
}
