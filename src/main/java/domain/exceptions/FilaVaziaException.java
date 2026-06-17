package domain.exceptions;

public class FilaVaziaException extends RuntimeException {

    public FilaVaziaException() {
        super("A fila está vazia.");
    }

    public FilaVaziaException(String mensagem) {
        super(mensagem);
    }
}
