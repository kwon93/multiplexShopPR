package backend.shop.com.multiplexshop.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> invalidExceptionHandler(MethodArgumentNotValidException e){
        HashMap<String, String > errorMap = new HashMap<>();
        e.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errorMap.put(fieldName, errorMessage);
                });

        ErrorResponse response = ErrorResponse.builder()
                .code("400")
                .message("잘못된요청입니다.")
                .validation(errorMap)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
