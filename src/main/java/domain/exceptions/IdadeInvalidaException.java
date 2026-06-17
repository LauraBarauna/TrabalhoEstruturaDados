package domain.exceptions;

public class IdadeInvalidaException extends RuntimeException {

    public IdadeInvalidaException() {
        super("A idade informada é inválida.");
    }

    public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}