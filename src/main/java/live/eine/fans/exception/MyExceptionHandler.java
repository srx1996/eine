package live.eine.fans.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e) {
        log.error("捕获异常！原因是:" + e);
        return "error/5xx";
    }
}
