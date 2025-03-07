package pro.sky.java.course2.exam.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.exam.interfaces.QuestionService;
import pro.sky.java.course2.exam.question.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
@Primary
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();

    public JavaQuestionService() {
        rescheduleQuestions();
    }

    @Override
    public void add(Question question) {
        if (questions.contains(question)) {
            return;
        }
        questions.add(question);

    }

    @Override
    public void add(String question, String answer) {
        questions.add(new Question(question, answer));

    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public void remove(Question question) {
        if (!questions.contains(question)) {
            throw new IllegalArgumentException("Такой пример отсутствует");
        }
        questions.remove(question);

    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return getAll().toArray(new Question[0])[random.nextInt(getAll().size())];
    }

    @Override
    public String getType() {
        return "JAVA";
    }

    private void rescheduleQuestions() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions/questions.json");
        if (inputStream == null) {
            throw new RuntimeException("Файл не найден!");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questionsJSON;
        try {
            questionsJSON = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        questions.addAll(questionsJSON);
    }
}