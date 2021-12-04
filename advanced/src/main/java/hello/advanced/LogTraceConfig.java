package hello.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        // return new FieldLogTrace(); // singleton으로 등록됨
        return new ThreadLocalLogTrace();
    }

}
