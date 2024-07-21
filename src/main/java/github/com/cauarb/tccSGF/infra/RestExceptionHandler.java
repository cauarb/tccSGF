package github.com.cauarb.tccSGF.infra;


import github.com.cauarb.tccSGF.exceptions.DepartamentoNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartamentoNotFound.class)
    private ResponseEntity<String> departamentoNotFoundHandler(DepartamentoNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("insercao do departamento e obrigatorio");
    }
}
