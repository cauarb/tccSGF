package github.com.cauarb.tccSGF.infra;

import github.com.cauarb.tccSGF.exceptions.DataIntegrityViolationException;
import github.com.cauarb.tccSGF.exceptions.DriverNotFoundException;
import github.com.cauarb.tccSGF.exceptions.VehicleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<String> handleVehicleNotFoundException(DriverNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<String> handleDriverNotFoundException(DriverNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
