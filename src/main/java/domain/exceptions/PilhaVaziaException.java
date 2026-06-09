package domain.exceptions;

public class PilhaVaziaException extends RuntimeException {

    public PilhaVaziaException() {
        super("A pilha está vazia.");
    }

    public PilhaVaziaException(String mensagem) {
        super(mensagem);
    }
}
