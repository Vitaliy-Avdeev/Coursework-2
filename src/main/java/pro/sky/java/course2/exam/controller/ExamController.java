package pro.sky.java.course2.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.exam.question.Question;
import pro.sky.java.course2.exam.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
public class ExamController {
    public final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/java/questions")
    public Collection<Question> getJavaQuestions(@RequestParam("amount") int amount) {
        return examinerService.getJavaQuestions(amount);
    }
}