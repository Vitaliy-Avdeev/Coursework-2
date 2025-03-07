package pro.sky.java.course2.exam.exception;

import org.springframework.http.HttpStatus;

public class ThrowingAnExceptionTooManyQuestions extends RuntimeException {
    private final HttpStatus status;

    public ThrowingAnExceptionTooManyQuestions(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
