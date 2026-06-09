package domain.exceptions;

public class EstruturaVaziaException extends RuntimeException {

    public EstruturaVaziaException() {
        super("A estrutura está vazia.");
    }

    public EstruturaVaziaException(String mensagem) {
        super(mensagem);
    }
}
