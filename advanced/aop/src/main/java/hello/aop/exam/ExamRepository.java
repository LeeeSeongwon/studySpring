package hello.aop.exam;

import org.springframework.stereotype.Repository;

import hello.aop.exam.annotation.Retry;
import hello.aop.exam.annotation.Trace;

@Repository
public class ExamRepository {

    private static int seq = 0;

    @Trace
    @Retry(value = 2) // 변경 가능
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("예외발생");
        }
        return "ok";
    }
}
