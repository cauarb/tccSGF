package github.com.cauarb.tccSGF.exceptions;

public class DepartamentoNotFoundException extends RuntimeException{
    public DepartamentoNotFoundException(Long message){
        super(String.valueOf(message));
    }
}
