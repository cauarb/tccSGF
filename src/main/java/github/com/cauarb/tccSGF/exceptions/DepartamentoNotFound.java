package github.com.cauarb.tccSGF.exceptions;

public class DepartamentoNotFound extends RuntimeException{

    public  DepartamentoNotFound() { super("Insercao do deparmento e obrigatorio");}

    public DepartamentoNotFound(String message) {super(message);}
}
