package pro.sky.java.course2.exam.interfaces;

import pro.sky.java.course2.exam.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getJavaQuestions(int amount);
}
