package github.com.cauarb.tccSGF.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message){
        super(message);
    }
}
