package my.com.mbb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice(basePackages = "my.com.mbb.controller")
public class ControllerExceptionHandler {

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<Map<Object, Object>> handleHttpException(HttpServerErrorException ex) {
        Map<Object, Object> error =
                Map.of("Timestamp", LocalDateTime.now(),
                        "message", ex.getStatusText(),
                        "code", ex.getRawStatusCode(),
                        "status", ex.getStatusCode()    );

        return new ResponseEntity<>(error, ex.getStatusCode());
    }
}
