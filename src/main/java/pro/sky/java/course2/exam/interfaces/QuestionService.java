package pro.sky.java.course2.exam.interfaces;

import pro.sky.java.course2.exam.question.Question;

import java.util.Collection;

public interface QuestionService {
    void add(Question question);

    void add(String question, String answer);

    Collection<Question> getAll();

    void remove(Question question);

    Question getRandomQuestion();

    String getType();
}
